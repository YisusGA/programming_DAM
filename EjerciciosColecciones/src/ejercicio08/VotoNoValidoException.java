package ejercicio08;

public class VotoNoValidoException extends Exception {
	// Se podría dejar vacía y ya. Pero suele ser interesante darle su propio mensaje personalizado cuando se lance
	
	public VotoNoValidoException() { // Constructor
		super("El votante no ha sabido ni votar"); // Mensaje personalizado que mostrará cuando se lance
	}

}
