package ejercicio08;

public class VotoNoValidoRuntimeException extends RuntimeException {
	// Yo la podría dejar vacía y ya. Pero suele ser interesante darle su propio mensaje personalizado cuando se lance
	
	public VotoNoValidoRuntimeException() { // Constructor
		super("El votante no ha sabido ni votar"); // Mensaje personalizado que mostrará cuando se lance
	}

}
