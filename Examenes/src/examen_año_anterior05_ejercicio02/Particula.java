package examen_año_anterior05_ejercicio02;

import java.util.Objects;

public class Particula {
	private int carga;
	private double masa;
	private Punto posicion;

	public Particula(int carga, double masa, Punto posicion) {
		this.carga = carga;
		this.masa = masa;
		this.posicion = posicion;
	}

	public Particula() {
		super();
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}

	public double getMasa() {
		return masa;
	}

	public void setMasa(double masa) {
		this.masa = masa;
	}

	public Punto getPosicion() {
		return posicion;
	}

	public void setPosicion(Punto posicion) {
		this.posicion = posicion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(posicion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Particula other = (Particula) obj;
		return Objects.equals(posicion, other.posicion);
	}

	@Override
	public String toString() {
		return "Carga: " + carga + ", Masa: " + masa + ", Posición: " + posicion;
	}

}
