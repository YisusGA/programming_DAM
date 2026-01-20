package ejemploEnum;

public class Main {

	public static void main(String[] args) {
		Cita cita = new Cita();
		cita.doctor = "Laura";
		cita.dia = DiaSemana.LUNES;
		// dia es un objeto de tipo DiaSemana, y tiene sus métodos
		System.out.println(cita.dia.name());
		System.out.println(cita.dia.ordinal());

		// Podría leer por teclado aquí un valor y en función de eso, hacer una
		// asignación de valor al enum. Pero mejor usar un método que creemos en la
		// clase enum

		do {
			cita.dia = DiaSemana.leerTeclado();
		} while (cita.dia == null);

		System.out.println("Tu cita es con " + cita.doctor + " el día " + cita.dia);

		// El enum se prestaría a meter luego aquí un switch-case para hacer cosas
		switch (cita.dia) {
		case LUNES -> {

		}
		case MARTES -> {

		}
		case MIERCOLES -> {

		}
		case JUEVES -> {

		}
		case VIERNES -> {

		}
		}

	}

}
