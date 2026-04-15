package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que nos va a servir para gestionar los objetos de la clase Alumno
 */
public class GestorAlumno implements Serializable { // Serializamos el gestor, que tiene dentro la lista de Alumnos
	private static final long serialVersionUID = 1L;
	private List<Alumno> alumnos;

	// Constructor para inicializar la lista de Alumno en una ArrayList
	public GestorAlumno() {
		this.alumnos = new ArrayList<Alumno>();
	}

	public boolean add(Alumno a) {
		boolean added = false;
		if (!alumnos.contains(a)) {
			added = alumnos.add(a);
		}
		return added;
	}

	public boolean add(String nif, String nombre, double nota) {
		boolean added = false;
		Alumno a = new Alumno(nif, nombre, nota);
		if (!alumnos.contains(a)) {
			added = alumnos.add(a);
		}
		return added;
	}

	public int size() {
		int result = alumnos.size();
		return result;
	}

	public List<Alumno> devolverListaAlumnos() {
		List<Alumno> result = null;
		if (this.alumnos != null && this.alumnos.size() > 0) {
			result = this.alumnos;
		}
		return result;
	}

	public Alumno getAlumno(int index) {
		Alumno a = null;
		if (index > -1 && index <= alumnos.size()) {
			a = alumnos.get(index);
		}
		return a;
	}

}
