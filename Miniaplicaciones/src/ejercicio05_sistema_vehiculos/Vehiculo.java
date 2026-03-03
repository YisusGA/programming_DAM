package ejercicio05_sistema_vehiculos;

import java.util.Objects;

public class Vehiculo implements Conducible {
	protected String marca, modelo;
	protected int velocidadMaxima;
	private int matricula;

	public Vehiculo(String marca, String modelo, int velocidadMaxima, int matricula) {
		this.marca = marca;
		this.modelo = modelo;
		this.velocidadMaxima = velocidadMaxima;
		this.matricula = matricula;
	}

	public Vehiculo() {
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public void setVelocidadMaxima(int velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	public int getMatricula() {
		return matricula;
	}

	private void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return matricula == other.matricula;
	}

	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", velocidadMaxima=" + velocidadMaxima
				+ ", matricula=" + matricula + "]";
	}

	@Override
	public String arrancar() {
		return "El vehículo " + " de la marca " + this.marca + " y modelo " + this.modelo + " arranca";
	}

	@Override
	public String detener() {
		return "El vehículo " + " de la marca " + this.marca + " y modelo " + this.modelo + " se detiene";
	}

}
