package application;

import java.util.Objects;

public class Alumno implements Comparable<Alumno> {
	private String nif;
	private String nombre;
	private double notaMedia;
	
	public Alumno(String nif, String nombre, double notaMedia) {
		this.nif = nif;
		this.nombre = nombre;
		this.notaMedia = notaMedia;
	}

	public Alumno() {
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

	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
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
		return "Alumno [nif=" + nif + ", nombre=" + nombre + ", notaMedia=" + notaMedia + "]";
	}

	@Override
	public int compareTo(Alumno o) {
		return this.nombre.compareTo(o.nombre);
	}
	
	

}
