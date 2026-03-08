package examen03_240226.ejercicio02;

import java.util.Objects;

public class Proceso implements Comparable<Proceso> {
	private int pid, prioridad, duracion;

	public Proceso(int pid, int prioridad, int duracion) {
		this.pid = pid;
		this.prioridad = prioridad;
		this.duracion = duracion;
	}

	public Proceso() {
	}

	public int getPid() {
		return pid;
	}

	private void setPid(int pid) {
		this.pid = pid;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proceso other = (Proceso) obj;
		return pid == other.pid;
	}

	@Override
	public String toString() {
		return "Proceso [pid=" + pid + ", prioridad=" + prioridad + ", duracion=" + duracion + "]";
	}

	@Override
	public int compareTo(Proceso o) {
		int prioridad = this.prioridad - o.getPrioridad();
		if (prioridad == 0) {
			prioridad = this.duracion - o.getDuracion();
		}
		return prioridad;
	}

}
