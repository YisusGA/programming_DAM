package modelo;

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

}
