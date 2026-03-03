package ejercicio05_sistema_vehiculos;

public class Camion extends Vehiculo implements Conducible {
	private int numeroEjes;

	public Camion(String marca, String modelo, int velocidadMaxima, int matricula, TipoVehiculo tipo, int numeroEjes) {
		super(marca, modelo, velocidadMaxima, matricula, tipo);
		this.numeroEjes = numeroEjes;
	}

	public Camion(String marca, String modelo, int velocidadMaxima, int matricula, TipoVehiculo tipo) {
		super(marca, modelo, velocidadMaxima, matricula, tipo);
	}

	public Camion() {
	}

	public int getNumeroEjes() {
		return numeroEjes;
	}

	public void setNumeroEjes(int numeroEjes) {
		this.numeroEjes = numeroEjes;
	}

	@Override
	public String toString() {
		return "Camion [marca=" + marca + ", modelo=" + modelo + ", velocidadMaxima=" + velocidadMaxima + ", tipo="
				+ tipo + ", numeroEjes=" + numeroEjes + "]";
	}

}
