package modelo;

public class Alumno {
	private String nombre;
	private String nif; // No es necesario para trabajar con el HashMap darle una propiedad nif a alumno, pues ya declararemos 
	private double nota;

	public Alumno(String nombre, double nota, String nif) {
		this.nombre = nombre;
		this.nota = nota;
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

}
