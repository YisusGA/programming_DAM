package ejercicio03_gestion_empleados;

import java.util.Objects;

public abstract class Empleado {
	protected String nombre;
	protected Double salarioBase;

	public Empleado(String nombre, Double salarioBase) {
		this.nombre = nombre;
		this.salarioBase = salarioBase;
	}

	public Empleado() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
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
		Empleado other = (Empleado) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", salarioBase=" + salarioBase + "]";
	}

	public abstract double calcularSalario();

}
