package ejercicio05_sistema_vehiculos;

public class Moto extends Vehiculo implements Conducible {
	private int cilindrada;

	public Moto(String marca, String modelo, int velocidadMaxima, int matricula, int cilindrada) {
		super(marca, modelo, velocidadMaxima, matricula);
		this.cilindrada = cilindrada;
	}

	public Moto(String marca, String modelo, int velocidadMaxima, int matricula) {
		super(marca, modelo, velocidadMaxima, matricula);
	}

	public Moto() {
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	@Override
	public String toString() {
		return "Moto [marca=" + marca + ", modelo=" + modelo + ", velocidadMaxima=" + velocidadMaxima + ", cilindrada="
				+ cilindrada + "]";
	}

}
