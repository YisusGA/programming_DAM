package ejercicio01;

import java.util.Objects;

public class Alumno {
	private String nombre, nif;
	private int yearBirth;

	public Alumno(String nombre, String nif, int yearBirth) {
		this.nombre = nombre;
		this.nif = nif;
		this.yearBirth = yearBirth;
	}

	public Alumno() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public int getYearBirth() {
		return yearBirth;
	}

	public void setYearBirth(int yearBirth) {
		this.yearBirth = yearBirth;
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
		return "Alumno [nombre=" + nombre + ", nif=" + nif + ", yearBirth=" + yearBirth + "]";
	}

}
