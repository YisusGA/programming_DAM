package ejercicio16;

public class Curso {
	
	public static enum curso { //Clase especial enum para que la propiedad curso que metamos en Alummno tenga un conjunto determinado de valores posibles
		primero,
		segundo
	}
	
	//Método para consultar los posibles valores que puede tomar la variable de tipo enum curso
	public void consultarValoresPosiblesCurso() {
		for (curso i : curso.values()) {
			System.out.println("Curso: " + i);
		}
	}

}
