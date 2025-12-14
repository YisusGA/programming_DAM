package ejercicio16;

public class Asignatura {
	private String nombre;
	private enum Curso { //Clase especial enum para que la propiedad curso tenga un conjunto determinado de valores posibles
		primero,
		segundo
	}	
	private double nota;
	
	
	
	public Asignatura(String nombre, double nota, String curso) {
		this.nombre = nombre;
		this.nota = nota;
	}



	//Método para consultar los posibles valores que puede tomar la variable de tipo enum curso
	public void consultarValoresPosiblesCurso() {
		for (Curso i : Curso.values()) {
			System.out.println("Curso: " + i);
		}
	}
}
