package gestion;

import java.util.Arrays;

public class GestorReservas {
	Reserva[] reservas = new Reserva[0];
	static int codigo = 0;

	public int generarCodigo() {
		return this.codigo++;
	}

	public Reserva hacerReserva() {
		// ToDo
		return null;
	}

	public void addReserva(Reserva reserva) {
		// ToDo
	}

	public void eliminarReserva(int codigo) {
		// ToDo
	}

	public void mostrarReservasPorFecha() {
		Arrays.sort(reservas); // Esto funciona porque hemos implementado el método compareTo(Object o) en
								// Reserva
	}

}
