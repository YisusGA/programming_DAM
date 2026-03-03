package ejercicio05_sistema_vehiculos;

public class Coche extends Vehiculo implements Conducible {
	private String numeroPuertas;

	public Coche(String marca, String modelo, int velocidadMaxima, int matricula, String numeroPuertas) {
		super(marca, modelo, velocidadMaxima, matricula);
		this.numeroPuertas = numeroPuertas;
	}

	public Coche(String marca, String modelo, int velocidadMaxima, int matricula) {
		super(marca, modelo, velocidadMaxima, matricula);
	}

	public Coche() {
	}

	public String getNumeroPuertas() {
		return numeroPuertas;
	}

	public void setNumeroPuertas(String numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}

	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", modelo=" + modelo + ", velocidadMaxima=" + velocidadMaxima
				+ ", numeroPuertas=" + numeroPuertas + "]";
	}

}
