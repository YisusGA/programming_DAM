package treeset;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	private static Set<Alumno> alumnos = new TreeSet<>(new ComparadorNif()); // Tenemos que haber sobreescrito el método
																				// compareTo en la clase
																				// Alumno, o pasarle un comparador como
																				// parámetro. Ver explicación en el
																				// compareTo(Alumno o) de Alumno

	public static void main(String[] args) {

		insertAlumno(new Alumno("1234", "pepe", 10));
		System.out.println(listadoAlumnos());
		// Como el compare de la clase que implementa Comparator que le hemos pasado a
		// TreeSet usa el nif como criterio de ordenación e igualdad, no nos va a dejar
		// añadir el objeto de aquí debajo, pues el nif es el mismo
		insertAlumno(new Alumno("1234", "pedro", 9));
		System.out.println("intentamos añadir un objeto con el mismo nif");
		System.out.println(listadoAlumnos());
		insertAlumno(new Alumno("5678", "pepe", 8));
		insertAlumno(new Alumno("9999", "aaaa", 6));
		System.out.println("Nuevo listado");
		System.out.println(listadoAlumnos()); // Esto va a salir impreso según el orden de iteración que aplique al
												// TreeSet, que en este caso, es el de la clase que hemos creado que
												// implementa Comparator (cuyo método compare de Alumno que hemos hecho
												// es por nif). Por lo tanto, el orden en el que se va a imprimir es por
												// nif (probar a cambiar el dni de aaaa por 0999, para ver cómo cambia
												// el orden

		List<Alumno> alumnosLista = new LinkedList<>();
		alumnosLista.addAll(alumnos);

		alumnosLista.sort(null); // Esto se va a ordenar según el compareTo que hayamos implementado en la clase
									// Alumno, que en nuestro caso, es por nombre (ordenamiento de Strings usando el
									// compareTo de String)

		System.out.println("Listado de alumnos ordenado por nombre");
		for (Alumno a : alumnosLista) {
			System.out.println(a + "");
		}

	}

	private static void insertAlumno(Alumno a) {
		alumnos.add(a);
	}

	private static String listadoAlumnos() {
		String listado = "";
		for (Alumno a : alumnos) {
			listado += (a + "\n");
		}
		return listado;
	}

}
