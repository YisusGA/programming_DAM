package main;

import java.util.HashMap;
import java.util.Map;

import modelo.Alumno;

public class Main {
	// Map necesita parametrizarse con el tipo de dato que es la clave (en primera
	// posición) y con el tipo de dato que es el valor (en segunda posición).
	// HashMap guarda las claves en un HashSet, así que la clase a la que
	// pertenezcan las claves tienen que tener un hashCode y equals. En este caso,
	// String tiene hashCode y equals
	private static Map<String, Alumno> alumnos = new HashMap<>();

	public static void main(String[] args) {

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

		// Obtener valor (objeto) a partir de una clave. Este es uno de los grandes
		// potenciales de los HashMap: no hace falta iterar dentro de una colección de
		// objetos, mirando dentro de cada objeto, para encontrar el que queremos.
		// Simplemente se itera en un HashSet de claves para encontrar la que buscamos,
		// y a partir de ahí, accedemos al valor (objeto) asociado a dicha clave
		System.out.println(alumnos.get("1234"));

	}

}
