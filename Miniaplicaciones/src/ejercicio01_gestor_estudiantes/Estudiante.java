package ejercicio01_gestor_estudiantes;

import java.util.Objects;

public class Estudiante {
	private String nombre;
	private int edad;
	private Double notaMedia;

	public Estudiante(String nombre, int edad, double notaMedia) {
		this.nombre = nombre;
		this.edad = edad;
		this.notaMedia = notaMedia;
	}

	public Estudiante(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	public Estudiante(String nombre) {
		this.nombre = nombre;
	}

	public Estudiante() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante other = (Estudiante) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", edad=" + edad + ", notaMedia=" + notaMedia + "]";
	}

}
