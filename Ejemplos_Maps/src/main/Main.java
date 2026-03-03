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

		alumnos.put("1234", new Alumno());
		System.out.println("Número de alumnos: " + alumnos.size());

		// Si intentas insertar un nuevo valor con una clave que ya existe, sustituye el
		// valor asociado a esa clave por el nuevo, no añade un nuevo objeto
		alumnos.put("1234", new Alumno());
		System.out.println("Número de alumnos: " + alumnos.size());

		alumnos.put("5678", new Alumno());
		System.out.println("Número de alumnos: " + alumnos.size());

		// Obtener valor (objeto) a partir de una clave
		alumnos.get("1224");

	}

}
