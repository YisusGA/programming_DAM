package ejercicio16;

public class Alumno {
	private String nombre;
	private Asignatura asignatura;
	
	
	
	/**
	 * Método constructor de Alumno sólo con su nombre
	 * @param Nombre del alumno
	 */
	public Alumno(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método constructor de Alumno con su nombre y asignatura
	 * @param Nombre del alumno
	 * @param Asignatura asignada al alumno
	 */
	public Alumno(String nombre, Asignatura asignatura) {
		this.nombre = nombre;
		this.asignatura = asignatura;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String asignaAsignatura (Asignatura asignatura) {
		this.asignatura = asignatura;
		return "Asignatura asignada correctamente";
	}
	
	
	public Asignatura getAsignatura() {
		return asignatura;
	}

	public String asignaAsignatura (String nombreAsignatura, Curso curso, double nota) {
		asignatura.setNombre(nombreAsignatura);
		asignatura.setNota(nota);
		asignatura.setCurso(curso);
		return "Asignatura asignada correctamente";
	}
	
	public String cambiaNota(double nota) {
		if (asignatura != null) {
			asignatura.setNota(nota);
			return "Nota cambiada correctamente";
		} else {
			return "El alumno no tiene ninguna asignatura asignada";
		}
	}

	@Override
	public String toString() {
		if (asignatura != null) {
			return "Alumno [nombre=" + nombre + ", asignatura=" + asignatura + "]";
		} else {
			return "Alumno [nombre=" + nombre + "]";
		}
	}
	
	
	
	
}
