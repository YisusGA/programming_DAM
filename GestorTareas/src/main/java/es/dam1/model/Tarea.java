package es.dam1.model;

import java.time.LocalDate;
import java.util.Objects;

public class Tarea {

	private static Integer idGen = 0;
	private Integer id; // ID único identificativo
	private String nombre;
	private String descripcion;
	private LocalDate fechaLimite;
	private boolean completada;

	public Tarea(String nombre, String descripcion, LocalDate fechaLimite) {
		this.id = idGen++;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaLimite = fechaLimite;
		this.completada = false;
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(LocalDate fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public boolean isCompletada() {
		return completada;
	}

	public void setCompletada(boolean completada) {
		this.completada = completada;
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
		Tarea other = (Tarea) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Tarea [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaLimite="
				+ fechaLimite + ", completada=" + completada + "]";
	}

}
