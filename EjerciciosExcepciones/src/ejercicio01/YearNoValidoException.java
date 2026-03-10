package ejercicio01;

public class YearNoValidoException extends Exception {

	public YearNoValidoException() {
		super("El año introducido no es válido, debe ser positivo");
	}

}
