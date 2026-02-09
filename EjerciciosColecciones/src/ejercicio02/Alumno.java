package ejercicio02;

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
	
	public boolean compararNombre() {
		//ToDo
		return false;
	}

}
