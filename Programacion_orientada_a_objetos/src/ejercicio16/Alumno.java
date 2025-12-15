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
		this.asignatura = asignatura.setNombre(asignatura.nombre);
	}
	
	
}
