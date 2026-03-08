package modelo;

import java.util.Objects;

public class Alumno {
	private String nombre;
	private String nif; // No es necesario para trabajar con el HashMap darle una propiedad nif a
						// alumno, pues ya declararemos un sistema de claves al crear el HashMap. Sin
						// embargo, es recomendable aún así darle a Alumno una clave primaria, pues
						// nunca se sabe si la vamos a necesitar en otros contextos. Ver apuntes
						// cuaderno 03-03-2026
	private double nota;

	public Alumno(String nombre, double nota, String nif) {
		this.nombre = nombre;
		this.nota = nota;
		this.nif = nif;
	}

	public Alumno(String nif) {
		this.nif = nif;
	}

	public Alumno() {
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

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", nif=" + nif + ", nota=" + nota + "]";
	}

	// hashCode y equals no son necesarios para el funcionamiento del HashMap, pero
	// es buena idea sobreescribir estos métodos, pues podríamos querer trabajar con
	// objetos de la clase Alumno en colecciones en otros contextos
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

}
