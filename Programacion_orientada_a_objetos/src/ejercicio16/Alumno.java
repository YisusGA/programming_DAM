package ejercicio16;

public class Alumno {
	private String nombre;
	private Asignatura asignatura;
	
	/**
	 * Método constructor de Alumno
	 * @param Nombre del alumno
	 * @param Asignatura asignada al alumno
	 */
	public Alumno(String nombre, Asignatura asignatura) {
		this.nombre = nombre;
		this.asignatura = asignatura;
	}
	
	public String asignaAsignatura (Asignatura asignatura) {
		this.asignatura = asignatura;
		return "Asignatura asignada correctamente";
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
		return "Alumno [nombre=" + nombre + ", asignatura=" + asignatura + ", nota=" + asignatura.getNota() + "]";
	}
	
	
	
	
}
