package model;

import java.util.Objects;

public class Empleado {
	private String id;
	private String nombre;
	private int nivel;
	private double salario;
	private static int idGenerado = 0;

	public Empleado(String nombre, int nivel, double salario) {
		this.nombre = nombre;
		this.nivel = nivel;
		this.salario = salario;
		this.id = "E" + idGenerado++;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", nivel=" + nivel + ", salario=" + salario + "]";
	}

}
