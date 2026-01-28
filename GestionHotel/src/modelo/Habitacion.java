package modelo;

public class Habitacion {
	protected int numeroHabitacion, numeroCamas;
	protected double precio;
	TipoHabitacion tipo;

	public Habitacion(int numeroHabitacion, int numeroCamas, double precio, TipoHabitacion tipo) {
		this.numeroHabitacion = numeroHabitacion;
		this.numeroCamas = numeroCamas;
		this.precio = precio;
		this.tipo = tipo;
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

	public TipoHabitacion getTipo() {
		return tipo;
	}

	public void setTipo(TipoHabitacion tipo) {
		this.tipo = tipo;
	}

	public int plazasTotales() {
		return numeroCamas;
	}

	@Override
	public String toString() {
		return "Habitacion [numeroHabitacion=" + numeroHabitacion + ", numeroCamas=" + numeroCamas + ", precio="
				+ precio + "]";
	}

}
