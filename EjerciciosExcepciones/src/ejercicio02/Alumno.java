package ejercicio02;

import java.util.Objects;

public class Alumno {
	private String nif, nombre;
	private int year;

	private Alumno(String nif, String nombre, int year) {
		this.nif = nif;
		this.nombre = nombre;
		this.year = year;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public static Alumno createAlumno(String nif, String nombre, int year) throws CreateAlumnoException {
		if (year < 0) {
			throw new CreateAlumnoException();
		}
		Alumno a = new Alumno(nif, nombre, year);
		return a;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nif);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(nif, other.nif);
	}

	@Override
	public String toString() {
		return "Alumno [nif=" + nif + ", nombre=" + nombre + ", year=" + year + "]";
	}

}
