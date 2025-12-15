package ejercicio16;

public class Asignatura {
	private String nombre;
	private String curso;
	private enum curso { //Clase especial enum para que la propiedad curso tenga un conjunto determinado de valores posibles
		primero,
		segundo
	}	
	private double nota;
	
	
	//Constructor para inicializar todas las propiedades
	public Asignatura(String nombre, double nota, String curso) {
		this.nombre = nombre;
		this.curso = curso;
		this.nota = nota;
	}
	
	//Constructor para inicializar todas las propiedades menos la nota
	public Asignatura(String nombre, String curso) {
		this.nombre = nombre;
		this.curso = curso;
		nota = -1;
	}

	//Método para consultar los posibles valores que puede tomar la variable de tipo enum curso
//	public void consultarValoresPosiblesCurso() {
//		for (curso i : curso.values()) {
//			System.out.println("Curso: " + i);
//		}
//	}
	
	/**
	 * Getter para asignar nota en la asignatura
	 * @param Nota obtenida en la asignatura
	 * @return String indicando que se ha asignado correctamente la nota
	 */
	public String califica(double nota) {
		this.nota = nota;
		return "Nota asignada correctamente";
	}
	
	/*
	 * Getter para mostrar la nota obtenida en la asignatura
	 */
	public double resultado() {
		return nota;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve un String con la representación de la asignatura
	 */
	public String toString() {
		//faltaría el curso
		return "Asignatura [nombre=" + nombre + ", nota=" + nota + "]";
	}

	
	
	
}
