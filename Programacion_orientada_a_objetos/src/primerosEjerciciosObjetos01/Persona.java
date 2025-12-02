package primerosEjerciciosObjetos01;

class Persona {
	String nombre; //Nombre de la persona
	int edad; //Edad de la persona
	void saludar() { //Método para saludar
		System.out.printf("Hola soy %s y tengo %d años %n", nombre, edad);
	}
	void despedirse() {
		System.out.println("Adios"); //Método para despedirse
	}
}

