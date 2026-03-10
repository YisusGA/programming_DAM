package ejercicio08;

/*
 * Si hacemos que herede de RuntimeException en lugar de Exception, el compilador no nos obligará a hacer try-catch 
 * o throws al llamar a un método que pueda devolver una Exception. Sin embargo, esa Exception saltará en tiempo de 
 * ejecución. Entonces, ya queda a decisión del programador qué Exception quiere gestionar en tiempo de escritura de 
 * código y cuáles quiere que se gestionen en tiempo de ejecución
 */

public class VotoNoValidoRuntimeException extends RuntimeException {
	// Se podría dejar vacía y ya. Pero suele ser interesante darle su propio mensaje personalizado cuando se lance
	
	public VotoNoValidoRuntimeException() { // Constructor
		super("El votante no ha sabido ni votar"); // Mensaje personalizado que mostrará cuando se lance
	}

}
