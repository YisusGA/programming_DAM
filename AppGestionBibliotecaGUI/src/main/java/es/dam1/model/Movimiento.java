package es.dam1.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import es.dam1.other.TipoMovimiento;

public class Movimiento implements Serializable, Comparable<Movimiento> {

	private static final long serialVersionUID = 2L;

	private Integer idMovimiento;
	private Libro libro;
	// Tengo que hacer esta trampita de aquí de meter el nombre del libro para poder
	// darle la propiedad a la columna de la tabla, pues sólo puede leer propiedades
	// de la clase con la que se vincula (no puede leer libro.getNombre()). Y la
	// tabla necesita que exista un método getter para pillar el valor de la
	// propiedad, por lo que en esta clase he metido un método getter para
	// nombreLibro que lo que hace es devolver libro.getNombre()
	private String nombreLibro;
	private Integer cantidad;
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

	public Integer getIdMovimiento() {
		return idMovimiento;
	}

	private void setIdMovimiento(Integer idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public String getNombreLibro() {
		return libro.getNombre();
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
		return "Prestamo [idPrestamo=" + idMovimiento + ", libro=" + libro + ", cantidad=" + cantidad + ", fecha="
				+ fecha + ", tipoMovimiento=" + tipoMovimiento + "]";
	}

	@Override
	public int compareTo(Movimiento o) {
		return this.fecha.compareTo(o.getFecha());
	}

}
