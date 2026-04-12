package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Prestamo implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idPrestamo;
	private Libro libro;
	private int cantidad;
	private LocalDate fecha;
	private int tipoMovimiento; // Si es 0, lo consideramos préstamo, si es 1, devolución

	// Atributos solicitados para el informe de préstamos
	private double precioVenta;
	private double totalVenta;

	// Constructor vacío
	public Prestamo() {
	}

	// Constructor con parámetros
	public Prestamo(int idPrestamo, Libro libro, int cantidad, LocalDate fecha, int tipoMovimiento, double precioVenta,
			double totalVenta) {
		this.idPrestamo = idPrestamo;
		this.libro = libro;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.tipoMovimiento = tipoMovimiento;
		this.precioVenta = precioVenta;
		this.totalVenta = totalVenta;
	}

	// Getters y Setters
	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(int tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public double getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

	public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

}