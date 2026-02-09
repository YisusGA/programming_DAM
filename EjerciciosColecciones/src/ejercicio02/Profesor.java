package ejercicio02;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
	private String nif, nombre;
	private List<Alumno> alumnos = new ArrayList<>();

	public Profesor(String nif, String nombre, List<Alumno> alumnos) {
		this.nif = nif;
		this.nombre = nombre;
		this.alumnos = alumnos;
	}

	public Profesor(String nif, String nombre) {
		this.nif = nif;
		this.nombre = nombre;
	}

	public Profesor() {
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public void push(Alumno alumno) {
		alumnos.addLast(alumno);
	}

	public Alumno pop() {
		Alumno result = new Alumno();
		alumnos.removeLast();
		return result;
	}
	
	public double porcentajeAprobados() {
		int contador = 0;
		for (Alumno i : alumnos) {
			if (i.aprobado()) {
				contador++;
			}
		}
		return (double)contador / alumnos.size();
	}
	
	public List<Alumno> listadoOrdenadoAlumnos() {
		//ToDo
		return null;
	}

}
