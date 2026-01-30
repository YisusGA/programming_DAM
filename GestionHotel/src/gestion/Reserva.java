package gestion;

import java.time.LocalDate;

import modelo.Habitacion;

public class Reserva implements Comparable {
	protected LocalDate fecha;
	protected Habitacion[] habitacionesReservadas;
	protected int numeroPersonas;
	private int codigo;

	public Reserva(LocalDate fecha, Habitacion[] habitacionesReservadas, int numeroPersonas, int codigo) {
		this.fecha = fecha;
		this.habitacionesReservadas = habitacionesReservadas;
		this.numeroPersonas = numeroPersonas;
		this.codigo = codigo;
	}

	public Reserva(LocalDate fecha, int numeroPersonas, int codigo) {
		this.fecha = fecha;
		this.numeroPersonas = numeroPersonas;
		this.codigo = codigo;
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

	public int getCodigo() {
		return codigo;
	}

	private void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Habitacion[] getHabitacionesReservadas(LocalDate fecha) {
		if (fecha.equals(this.fecha)) {
			return this.habitacionesReservadas;
		}
		return null;
	}

	public Habitacion[] getHabitacionesReservadas(int codigo) {
		if (codigo == this.codigo) {
			return this.habitacionesReservadas;
		}
		return null;
	}

	public boolean comprobarFechaReserva(LocalDate fecha) {
		return fecha.equals(this.fecha);
	}

	public boolean comprobarCodigoReserva(int codigo) {
		return codigo == this.codigo;
	}

	public void addHabitacion(Habitacion habitacion) {
		Habitacion[] aux = new Habitacion[habitacionesReservadas.length + 1];
		for (int i = 0; i < habitacionesReservadas.length; i++) {
			aux[i] = habitacionesReservadas[i];
		}
		aux[aux.length - 1] = habitacion;
		habitacionesReservadas = aux;
	}

	@Override
	public int compareTo(Object o) {
		if(this.getFecha().isAfter(((Reserva)o).getFecha())) {
			//Terminar esto
		}
		return 0; // Negativo si el que lo llama va antes que el pasado como parámetro, positivo
					// si va después, 0 si son iguales
	}

}
