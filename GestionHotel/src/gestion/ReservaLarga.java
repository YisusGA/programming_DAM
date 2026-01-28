package gestion;

import java.time.LocalDate;

import modelo.Habitacion;

public class ReservaLarga extends Reserva {
	LocalDate fechaFin;

	public ReservaLarga(LocalDate fecha, Habitacion[] habitacionesReservadas, int numeroPersonas, int codigo, LocalDate fechaFin) {
		super(fecha, habitacionesReservadas, numeroPersonas, codigo);
		this.fechaFin = fechaFin;
	}

	public ReservaLarga(LocalDate fecha, int numeroPersonas, int codigo, LocalDate fechaFin) {
		super(fecha, numeroPersonas, codigo);
		this.fechaFin = fechaFin;
	}

	public ReservaLarga() {

	}

	@Override
	public Habitacion[] compruebaReserva(LocalDate fecha) {
		if (fecha.equals(this.fecha) || fecha.equals(this.fechaFin) || (fecha.isAfter(this.fecha) && fecha.isBefore(this.fechaFin))) {
			return habitacionesReservadas;
		}
		return null;
	}

}
