package modelo;

import java.io.Serializable;
import java.util.Objects;

public class Destino implements Serializable {
	private String nombre;
	private double precio;

	public Destino(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public Destino() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Destino other = (Destino) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Destino [nombre=" + nombre + ", precio=" + precio + "]";
	}

}
