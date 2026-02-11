package logic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// Set es la interfaz, y hay que implementarla.Hay 3 implementaciones de sets
		// (conjuntos): HashSet, LinkedHashSet, TreeSet

		// ejemploHashSet();
		ejemploAlumnoHashSet();

	}

	private static void ejemploHashSet() {
		Set<String> nombres = new HashSet<>(); // Implementamos este set como HashSet, con objetos String

		nombres.add("Juan");
		nombres.add("Ana");
		nombres.add("Bea");
		System.out.println("Tamaño: " + nombres.size());
		System.out.println();

		nombres.add("Juan"); // Este no lo añadirá, porque ya existe uno igual y no puede haber duplicados
		System.out.println("Tamaño tras intentar añadir elemento duplicado: " + nombres.size()); // Y el tamaño sigue
																									// siendo el mismo
		System.out.println();

		// Recorrer colección. El orden de iteración no es el de inserción (no hay un
		// orden como en las listas, pues esto es un conjunto)
		for (String n : nombres) {
			System.out.println(n);
		}
		System.out.println();

		// Esto no se puede hacer porque en un set, no hay un orden
//		for (int i = 0; i < nombres.size(); i++) {
//			System.out.println(nombres.get(i));
//		}

		// Podemos recorrer el set con un iterador. Este iterador se puede usar también
		// para las listas
		Iterator<String> it = nombres.iterator(); // Iterador se convierte en un objeto puntero que puede ir apuntando a
													// los diferentes elementos de la colección. Comienza apuntando a la
													// posición anterior a donde hay elemento
		while (it.hasNext()) { // Mientras haya un elemento siguiente
			String n = it.next(); // Cargamos el iterador con el elemento siguiente, y lo almacenamos en una
									// variable
			System.out.println(n); // Y hacemos lo que queramos con esa variable
		}
		System.out.println();

		// El iterator es poco útil porque se puede hacer un for-each. Sin embargo, sí
		// que tiene la utilidad de que implementa un método remove

		// Eliminar los nombres que empiecen por "A"

		// Esto me generaría problemas de concurrencia
//		for (String n : nombres) {
//			if (n.charAt(0) == 'A') {
//				nombres.remove(n);
//			}
//		}

		it = nombres.iterator();
		while (it.hasNext()) {
			String n = it.next();
			if (n.charAt(0) == 'A') {
				it.remove();
			}
		}
		for (String n : nombres) {
			System.out.println(n);
		}
		System.out.println();

		nombres.remove("Bea"); // Esto se puede hacer así en este caso porque estamos trabajando con un set de
								// String. Y la clase String ya tiene una implementación del método de igualdad

	}

	private static void ejemploAlumnoHashSet() {
		Set<Alumno> alumnos = new HashSet<>();
		alumnos.add(new Alumno("1234", 7.0));
		alumnos.add(new Alumno("5678", 7.0));

		for (Alumno a : alumnos) {
			System.out.println(a);
		}
		System.out.println();

		alumnos.add(new Alumno("1234", 7.0)); // Esto así tal cual nos dejaría añadirlo aún siendo un duplicado, aunque
												// para nosotros sea igual. Es porque Alumno está implementando el
												// hashCode() y equals() de Object, que compara direcciones de memoria.
												// Tenemos que ir a la clase Alumno, click derecho > Source > Generate
												// hashCode() y equals(), y seleccionar la propiedad(es) de la clase que
												// queremos usar para establecer el criterio de igualdad
		for (Alumno a : alumnos) {
			System.out.println(a);
		}
		System.out.println();
		
		System.out.println(alumnos.contains(new Alumno("5678", 8.0)));
		
		alumnos.remove(new Alumno("5678", 8.0));
		
		// BORRAR SUSPENSOS
		Iterator<Alumno> it = alumnos.iterator();
		while (it.hasNext()) {
			Alumno a = it.next();
			if (a.getNota() < 5) {
				it.remove();
			}
		}

	}

}
