package ejercicio02;

public class CreateAlumnoException extends Exception {
	public CreateAlumnoException() {
		super("El año introducido debe ser positivo");
	}

}
