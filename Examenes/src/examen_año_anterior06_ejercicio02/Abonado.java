package examen_año_anterior06_ejercicio02;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Abonado implements Acciones {
	protected String nif, nombre;
	protected Set<Actividad> actividades = new HashSet<>();
	protected TipoAbonado tipo;

	public Abonado(String nif, String nombre, Set<Actividad> actividades, TipoAbonado tipo) {
		this.nif = nif;
		this.nombre = nombre;
		this.actividades = actividades;
		this.tipo = tipo;
	}

	public Abonado(String nif, String nombre, TipoAbonado tipo) {
		this.nif = nif;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public Abonado() {
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(Set<Actividad> actividades) {
		this.actividades = actividades;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nif);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Abonado other = (Abonado) obj;
		return Objects.equals(nif, other.nif);
	}

	public double getImporteTotalCuotas() {
		double result = 0;
		if (actividades != null && actividades.size() > 0) {
			for (Actividad i : actividades) {
				result += i.getCuota();
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "Abonado [nif=" + nif + ", nombre=" + nombre + ", actividades=" + actividades + ", tipo=" + tipo + "]";
	}

	@Override
	public abstract boolean registrarActvidad(Actividad actividad);

	@Override
	public abstract boolean cancelarActividad(String nombre);

}
