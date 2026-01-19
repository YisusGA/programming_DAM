package ejercicio21;

import java.util.Date;

public class Empleado {
	
	private String nif, nombre;
	private double sueldo;
	private Date fechaContrato;
	private Departamento departamento;
	
	
	public String getNif() {
		return nif;
	}
	public String getNombre() {
		return nombre;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public Departamento getDepto() {
		return departamento;
	}
	public void setDepto(Departamento departamento) {
		this.departamento = departamento;
	}
	public Date getFechaContrato() {
		return fechaContrato;
	}
	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
	
	

}
