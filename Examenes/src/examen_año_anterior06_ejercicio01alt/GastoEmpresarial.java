package examen_año_anterior06_ejercicio01alt;

import java.time.LocalDate;

public class GastoEmpresarial extends ApunteEconomico {
	LocalDate fecha;
	String DNIResponsable;

	public GastoEmpresarial(int code, double importe, String concepto, TipoApunte tipo, LocalDate fecha,
			String dNIResponsable) {
		super(code, importe, concepto, tipo);
		this.fecha = fecha;
		DNIResponsable = dNIResponsable;
	}

	public GastoEmpresarial(double importe, String concepto, TipoApunte tipo, LocalDate fecha, String dNIResponsable) {
		super(importe, concepto, tipo);
		this.fecha = fecha;
		DNIResponsable = dNIResponsable;
	}

	public GastoEmpresarial(int code, double importe, String concepto, TipoApunte tipo) {
		super(code, importe, concepto, tipo);
	}

	public GastoEmpresarial() {
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getDNIResponsable() {
		return DNIResponsable;
	}

	public void setDNIResponsable(String dNIResponsable) {
		DNIResponsable = dNIResponsable;
	}

	@Override
	public String toString() {
		return "GastoEmpresarial [code=" + code + ", importe=" + importe + ", concepto=" + concepto + ", tipo=" + tipo
				+ ", fecha=" + fecha + ", DNIResponsable=" + DNIResponsable + "]";
	}

	@Override
	public void describe() {
		System.out.println("GastoEmpresarial [code=" + code + ", importe=" + importe + ", concepto=" + concepto
				+ ", fecha=" + fecha + ", DNIResponsable=" + DNIResponsable + "]");

	}

}
