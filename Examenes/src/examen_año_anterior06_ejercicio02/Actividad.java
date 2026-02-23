package examen_año_anterior06_ejercicio02;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Actividad {
	private String nombre;
	private Double cuota;
	private List<Character> diasSemana = new ArrayList<>();

	public Actividad(String nombre, Double cuota, List<Character> diasSemana) {
		this.nombre = nombre;
		this.cuota = cuota;
		this.diasSemana = diasSemana;
	}

	public Actividad(String nombre, Double cuota) {
		this.nombre = nombre;
		this.cuota = cuota;
	}
	
	public Actividad(String nombre) {
		this.nombre = nombre;
	}

	public Actividad() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getCuota() {
		return cuota;
	}

	public void setCuota(Double cuota) {
		this.cuota = cuota;
	}

	public List<Character> getDiasSemana() {
		return diasSemana;
	}

	public void setDiasSemana(List<Character> diasSemana) {
		this.diasSemana = diasSemana;
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
		Actividad other = (Actividad) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Actividad [nombre=" + nombre + ", cuota=" + cuota + ", diasSemana=" + diasSemana + "]";
	}

}
