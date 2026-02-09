package ejercicio02;

import java.util.Objects;

public class Alumno {
	private String nif, nombre;
	private Double nota;

	public Alumno(String nif, String nombre, double nota) {
		this.nif = nif;
		this.nombre = nombre;
		this.nota = nota;
	}

	public Alumno(String nif, String nombre) {
		this.nif = nif;
		this.nombre = nombre;
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

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public boolean aprobado() {
		return this.nota >= 5;
	}

	// ¿Podría tener una utilidad para implementar bien el método de devolver una
	// lista ordenada alfabéticamente de alumnos?
	public boolean compararNombre(Alumno alumno) {
		if (this.nombre.toLowerCase().charAt(0) < alumno.getNombre().toLowerCase().charAt(0)) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Alumno [nif=" + nif + ", nombre=" + nombre + ", nota=" + nota + "]";
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

}
