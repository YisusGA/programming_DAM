package ejercicio16;

public class Asignatura {
	private String nombre;
	private Curso curso;
	private double nota;
	
	
	//Constructor para inicializar todas las propiedades
	public Asignatura(String nombre, double nota, Curso curso) {
		this.nombre = nombre;
		this.nota = nota;
		this.curso = curso;
	}
	
	//Constructor para inicializar todas las propiedades menos la nota
	public Asignatura(String nombre, Curso curso) {
		this.nombre = nombre;
		this.curso = curso;
		nota = -1;
	}
	
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
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	//Método para consultar los posibles valores que puede tomar la clase especial enum
		public String consultarValoresPosiblesCurso() {
			String valoresCurso = "Curso: ";
			for (Curso i : curso.values()) {
				valoresCurso += i + ", ";
			}
			return valoresCurso;
		}

	/**
	 * Devuelve un String con la representación de la asignatura
	 */
	public String toString() {
		return "Asignatura [nombre=" + nombre + ", curso=" + curso + ", nota=" + nota + "]";
	}
	

	
	
	
}
