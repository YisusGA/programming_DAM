package examen_año_anterior06_ejercicio01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public abstract class ApunteEconomico {
	protected Integer code; // Lo más sencillo sería separar año de serial y que el serial fuera una
							// propiedad static que se fuera incrementando sola, para así generar seriales
							// únicos. Lo ideal es que todos los códigos que deben ser únicos sean números
							// autoincrementados que se generen en la propia aplicación, y que no quede como
							// responsabilidad del usuario. En el examen, trabajar con un código que se
							// autoincremente
	protected double importe;
	protected String concepto;
	private static Set<Integer> seriales = new HashSet<>();

	public ApunteEconomico(int code, double importe, String concepto) {
		this.code = code;
		this.importe = importe;
		this.concepto = concepto;
	}

	public ApunteEconomico(double importe, String concepto) {
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
		return "ApunteEconomico [code=" + code + ", importe=" + importe + ", concepto=" + concepto + "]";
	}

	public int getEjercicioActual() {
		String aux = "" + code;
		aux = "" + aux.charAt(0) + aux.charAt(1) + aux.charAt(2) + aux.charAt(3);
		int year = Integer.parseInt(aux);
		return year;
	}

	public static Integer generarCode(int year, int serial) {
		String input = null;
		Integer codigo = null;
		boolean generado = false;
		if (seriales.add(serial) && (year > 1900 && year < 2100)) {
			generado = true;
		}
		if (generado) {
			input = "" + year + serial;
			codigo = Integer.parseInt(input);
		}
		return codigo;
	}

	public abstract void describe();

}
