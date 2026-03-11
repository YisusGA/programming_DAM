package ejercicio01;

import java.util.Objects;

public class AlumnoAlt {
	private String nombre, nif;
	private int yearBirth;

	// Hacemos el constructor privado para que la única forma que haya de crear un
	// Alumno sea el método crearAlumno que ofrecemos
	private AlumnoAlt(String nombre, String nif, int yearBirth) {
		this.nombre = nombre;
		this.nif = nif;
		this.yearBirth = yearBirth;
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

	// Este método debe ser static, porque como no ofrecemos ningún constructor,
	// debemos poder llamar al método sin instanciar ningún objeto de la clase
	// Alumno
	public static AlumnoAlt crearAlumno(String nombre, String nif, int year) {
		AlumnoAlt a = new AlumnoAlt(nombre, nif, year);
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
		AlumnoAlt other = (AlumnoAlt) obj;
		return Objects.equals(nif, other.nif);
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", nif=" + nif + ", yearBirth=" + yearBirth + "]";
	}

}
