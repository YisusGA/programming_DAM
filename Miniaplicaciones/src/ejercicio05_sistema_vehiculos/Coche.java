package ejercicio05_sistema_vehiculos;

public class Coche extends Vehiculo implements Conducible {
	private int numeroPuertas;

	public Coche(String marca, String modelo, int velocidadMaxima, String matricula, int numeroPuertas) {
		super(marca, modelo, velocidadMaxima, matricula);
		this.numeroPuertas = numeroPuertas;
	}

	public Coche(String marca, String modelo, int velocidadMaxima, String matricula) {
		super(marca, modelo, velocidadMaxima, matricula);
	}

	public Coche() {
	}

	public int getNumeroPuertas() {
		return numeroPuertas;
	}

	public void setNumeroPuertas(int numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}

	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", modelo=" + modelo + ", velocidadMaxima=" + velocidadMaxima
				+ ", numeroPuertas=" + numeroPuertas + "]";
	}

}
