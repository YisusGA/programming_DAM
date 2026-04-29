package es.dam1.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import es.dam1.other.TipoMovimiento;

public class Movimiento implements Serializable, Comparable<Movimiento> {

	private static final long serialVersionUID = 2L;

	private int idMovimiento;
	private Libro libro;
	private int cantidad;
	private LocalDate fecha;
	private TipoMovimiento tipoMovimiento;

	public Movimiento(int idMovimiento, Libro libro, int cantidad, LocalDate fecha, TipoMovimiento tipoMovimiento) {
		this.idMovimiento = idMovimiento;
		this.libro = libro;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.tipoMovimiento = tipoMovimiento;
	}

	public Movimiento() {
	}

	public int getIdPrestamo() {
		return idMovimiento;
	}

	private void setIdPrestamo(int idPrestamo) {
		this.idMovimiento = idPrestamo;
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

	@Override
	public int hashCode() {
		return Objects.hash(idMovimiento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimiento other = (Movimiento) obj;
		return idMovimiento == other.idMovimiento;
	}

	@Override
	public String toString() {
		return "Prestamo [idPrestamo=" + idMovimiento + ", libro=" + libro + ", cantidad=" + cantidad + ", fecha=" + fecha
				+ ", tipoMovimiento=" + tipoMovimiento + "]";
	}

	@Override
	public int compareTo(Movimiento o) {
		return this.fecha.compareTo(o.getFecha());
	}

}
