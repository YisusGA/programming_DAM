package examen03_240226.ejercicio01;

import java.util.Objects;

public abstract class Animal {
	protected String nombre;
	protected int energia = 1; // Otra forma de hacerlo sería no inicializar la energia aquí, y luego
								// implementar un sólo constructor en el que no se pida energía como parámetro,
								// y en el que dentro this.enegia se inicialice a 1

	public Animal(String nombre, int energia) {
		this.nombre = nombre;
		this.energia = energia;
	}

	public Animal(String nombre) {
		this.nombre = nombre;
	}

	public Animal() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
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
		Animal other = (Animal) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Animal [nombre=" + nombre + ", energia=" + energia + "]";
	}

	public abstract void comer(int cantidad);
}
