package modelo;

public class Habitacion {
	protected int numeroHabitacion, numeroCamas;
	protected double precio;

	public Habitacion(int numeroHabitacion, int numeroCamas, double precio) {
		this.numeroHabitacion = numeroHabitacion;
		this.numeroCamas = numeroCamas;
		this.precio = precio;
	}

	public Habitacion() {
	}

	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public void setNumeroHabitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	public int getNumeroCamas() {
		return numeroCamas;
	}

	public void setNumeroCamas(int numeroCamas) {
		this.numeroCamas = numeroCamas;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int plazasTotales() {
		return numeroCamas;
	}

}
