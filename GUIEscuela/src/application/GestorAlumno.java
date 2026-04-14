package application;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que nos va a servir para gestionar los objetos de la clase Alumno
 */
public class GestorAlumno {
	private List<Alumno> alumnos;

	// Constructor para inicializar la lista de Alumno en una ArrayList
	public GestorAlumno() {
		this.alumnos = new ArrayList<Alumno>();
	}
	
	public void add(Alumno a) {
		alumnos.add(a);
	}
	
	public void add(String nif, String nombre, double nota) {
		alumnos.add(new Alumno(nif, nombre, nota));
	}
	
	public int size() {
		int result = alumnos.size();
		return result;
	}

}
