package examen_año_anterior06_ejercicio01alt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public abstract class ApunteEconomico {
	protected Integer code;
	protected double importe;
	protected String concepto;
	protected static int serial = 0; // Si quisiéramos que el serial fuera una propiedad que sirviera como equals de
										// la clase, al ser static, no podría usarse ni para equals ni para el
										// constructor. En ese caso, lo ideal sería declarar en esta clase la propiedad
										// serial como no static, y declarar una propiedad de tipo int como estática en
										// la clase que implemente el main y pasársela al constructor de la clase
										// ApunteEconómico como el serial cada vez que instanciemos un objeto. Y en esa
										// misma clase que implementa el main, irla incrementando en 1 cada vez que se
										// use

	public ApunteEconomico(int year, double importe, String concepto) {
		this.code = generarCode(year);
		this.importe = importe;
		this.concepto = concepto;
	}

	public ApunteEconomico() {
	}

	public int getCode() {
		return code;
	}

	private void setCode(int code) {
		this.code = code;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApunteEconomico other = (ApunteEconomico) obj;
		return code == other.code;
	}

	@Override
	public String toString() {
		return "ApunteEconomico [code=" + code + ", importe=" + importe + ", concepto=" + concepto + ", tipo=" + "]";
	}

	public int getEjercicioActual() {
		String aux = "" + code;
		aux = "" + aux.charAt(0) + aux.charAt(1) + aux.charAt(2) + aux.charAt(3);
		int year = Integer.parseInt(aux);
		return year;
	}

	public static Integer generarCode(int year) {
		String input = "" + year + serial++;
		Integer codigo = Integer.parseInt(input);
		return codigo;
	}

	public abstract void describe();

}
