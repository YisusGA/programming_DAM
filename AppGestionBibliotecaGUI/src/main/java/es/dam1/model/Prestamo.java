package es.dam1.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import es.dam1.other.TipoMovimiento;

public class Prestamo implements Serializable, Comparable<Prestamo> {

	private static final long serialVersionUID = 2L;

	private int idPrestamo;
	private Libro libro;
	private int cantidad;
	private LocalDate fecha;
	private TipoMovimiento tipoMovimiento;

	// Atributos solicitados para el informe de préstamos
	private double precioVenta;
	private double totalVenta;

	public Prestamo(int idPrestamo, Libro libro, int cantidad, LocalDate fecha, TipoMovimiento tipoMovimiento,
			double precioVenta, double totalVenta) {
		this.idPrestamo = idPrestamo;
		this.libro = libro;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.tipoMovimiento = tipoMovimiento;
		this.precioVenta = precioVenta;
		this.totalVenta = totalVenta;
	}

	public Prestamo() {
	}

	public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

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

	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
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

	@Override
	public int hashCode() {
		return Objects.hash(idPrestamo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prestamo other = (Prestamo) obj;
		return idPrestamo == other.idPrestamo;
	}

	@Override
	public int compareTo(Prestamo o) {
		return this.fecha.compareTo(o.getFecha());
	}

}
