package modelo;

public class HabitacionFamiliar extends Habitacion {
	private int numeroCamasDobles;

	public HabitacionFamiliar(int numeroHabitacion, int numeroCamas, double precio, TipoHabitacion tipo,int numeroCamasDobles) {
		super(numeroHabitacion, numeroCamas, precio, tipo);
		this.numeroCamasDobles = numeroCamasDobles;
	}

	public HabitacionFamiliar(int numeroCamasDobles) {
		this.numeroCamasDobles = numeroCamasDobles;
	}

	public HabitacionFamiliar() {

	}

	public int getNumeroCamasDobles() {
		return numeroCamasDobles;
	}

	public void setNumeroCamasDobles(int numeroCamasDobles) {
		this.numeroCamasDobles = numeroCamasDobles;
	}

	@Override
	public int plazasTotales() {
		return numeroCamas + numeroCamasDobles * 2;
	}

	@Override
	public String toString() {
		return "HabitacionFamiliar [numeroHabitacion=" + numeroHabitacion + ", numeroCamas=" + numeroCamas
				+ "numeroCamasDobles=" + numeroCamasDobles + ", precio=" + precio + "]";
	}

}
