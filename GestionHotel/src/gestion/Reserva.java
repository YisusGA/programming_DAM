package gestion;

import java.time.LocalDate;

import modelo.Habitacion;

public class Reserva {
	protected LocalDate fecha;
	protected Habitacion[] habitacionesReservadas;
	protected int numeroPersonas;

	public Reserva(LocalDate fecha, Habitacion[] habitacionesReservadas, int numeroPersonas) {
		this.fecha = fecha;
		this.habitacionesReservadas = habitacionesReservadas;
		this.numeroPersonas = numeroPersonas;
	}

	public Reserva(LocalDate fecha, int numeroPersonas) {
		this.fecha = fecha;
		this.numeroPersonas = numeroPersonas;
	}

	public Reserva() {
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Habitacion[] getHabitacionesReservadas() {
		return habitacionesReservadas;
	}

	public void setHabitacionesReservadas(Habitacion[] habitacionesReservadas) {
		this.habitacionesReservadas = habitacionesReservadas;
	}

	public int getNumeroPersonas() {
		return numeroPersonas;
	}

	public void setNumeroPersonas(int numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}

	public Habitacion[] compruebaReserva(LocalDate fecha) {
		if (fecha.equals(this.fecha)) {
			return this.habitacionesReservadas;
		}
		return null;
	}

}
