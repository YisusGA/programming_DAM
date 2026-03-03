package modelo;

public class Habitacion {
	protected int numeroHabitacion, numeroCamas;
	protected double precio;

	public Habitacion(int numeroHabitacion, int numeroCamas, double precio) {
		this.numeroHabitacion = numeroHabitacion;
		this.numeroCamas = numeroCamas;
		this.precio = precio;
		// No tiene sentido meter una propiedad boolean disponible porque la
		// disponibilidad depende de la fecha
	}

	public Habitacion() {
	}

	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}

	private void setNumeroHabitacion(int numeroHabitacion) {
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

	@Override
	public String toString() {
		return "Habitacion [numeroHabitacion=" + numeroHabitacion + ", numeroCamas=" + numeroCamas + ", precio="
				+ precio + "]";
	}

}
