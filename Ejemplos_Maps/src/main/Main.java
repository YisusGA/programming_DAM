package main;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import modelo.Alumno;

public class Main {
	// Map necesita parametrizarse con el tipo de dato que es la clave (en primera
	// posición) y con el tipo de dato que es el valor (en segunda posición).
	// HashMap guarda las claves en un HashSet, así que la clase a la que
	// pertenezcan las claves tienen que tener un hashCode y equals. En este caso,
	// String tiene hashCode y equals
	private static Map<String, Alumno> alumnos = new HashMap<>();

	public static void main(String[] args) {

		// CREATE

		// Fijarse que ahora el método de añadir no es add, sino put
		alumnos.put("1234", new Alumno("1234")); // De esta forma, hago que tanto la propiedad nif de Alumno (su clave
													// primaria) como la clave del valor en el HashMap, coincidan.
													// Porque aunque no sea obligatorio técnicamente que coincidan,
													// conceptualmente no tiene sentido que sean diferentes. Habría que
													// buscar formas más robustas de hacer que deban ser iguales
		System.out.println("Número de alumnos: " + alumnos.size());

		// Si intentas insertar un nuevo valor con una clave que ya existe, sustituye el
		// valor asociado a esa clave por el nuevo, no añade un nuevo objeto
		alumnos.put("1234", new Alumno("1234"));
		System.out.println("Número de alumnos: " + alumnos.size());

		alumnos.put("5678", new Alumno("5678"));
		System.out.println("Número de alumnos: " + alumnos.size());

		// READ

		// Obtener valor (objeto) a partir de una clave. Este es uno de los grandes
		// potenciales de los HashMap: no hace falta iterar dentro de una colección de
		// objetos, mirando dentro de cada objeto, para encontrar el que queremos.
		// Simplemente se itera en un HashSet de claves para encontrar la que buscamos,
		// y a partir de ahí, accedemos al valor (objeto) asociado a dicha clave
		System.out.println(alumnos.get("1234"));

		// DELETE

		// Eliminar un elemento del HashMap: nombre.remove(Object key). Elimina el valor
		// asociado a la clave, y devuelve el valor asociado a esa clave (similar a cómo
		// funcionaba el pop() de las pilas). Si no contiene la clave que se especifica,
		// devuelve un null. Sabiendo esto, podemos comprobar si se ha eliminado o no
		if (alumnos.remove("5678") != null) {
			System.out.println("Alumno eliminado");
		}

		// UPDATE

		// No tendría sentido usar put, pues aunque put actualiza el valor asociado a
		// una clave que ya existe, si no existe esa clave, añade un nuevo elemento, y
		// eso no lo queremos

		alumnos.replace("1234", new Alumno("1234"));

		// RECORRER

		// Hay varias formas:

		// 1- Recorremos a partir del conjunto de claves
		Set<String> claves = alumnos.keySet();
		for (String key : claves) {
			System.out.println("Clave: " + key + " Valor: " + alumnos.get(key));
		}

		// 2- Sacamos sólo los valores
		Collection<Alumno> values = alumnos.values(); // Devuelve una Collection, así que hay que almacenarlo en una
														// Collection. Si no ponemos Collection, el compilador nos avisa
														// del fallo

		// Recorremos con un for-each
		for (Alumno i : values) {
			System.out.println(i);
		}
		// O con un Iterator, que es obligatorio si queremos modificar o eliminar los
		// valores
		Iterator<Alumno> it = values.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		// 3- MapEntry: es un envolvente del HashMap. Es "una forma amable" de visualizar
		// el HashMap, una vista adaptada del Map. Es un poco como las vistas en bases
		// de datos: son como ventanas que nos sirven para ver sólo los datos que nos
		// interesan. Y a través de esas ventanas, accedemos y trabajamos con los datos
		// reales. Las vistas no son copias de los datos reales, sólo ventanas para
		// acceder de forma más amigable a los datos reales
		
		Set<Map.Entry<String, Alumno>> vistaMap = alumnos.entrySet();
		
		for (Map.Entry<String, Alumno> entry : vistaMap) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}

}
