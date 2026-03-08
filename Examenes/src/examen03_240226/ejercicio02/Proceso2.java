package examen03_240226.ejercicio02;

import java.util.Objects;

public class Proceso2 implements Comparable<Proceso2> {
	private int prioridad, duracion, pid;
	private static int stePid = 0;

	public Proceso2(int prioridad, int duracion) {
		this.pid = stePid++;
		this.prioridad = prioridad;
		this.duracion = duracion;
	}

	public Proceso2() {
		this.pid = stePid++;
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

	// ¿Por qué no me deja implementar un hashCode y un equals por pid y a la profe
	// sí?

	@Override
	public String toString() {
		return "Proceso [pid=" + pid + ", prioridad=" + prioridad + ", duracion=" + duracion + "]";
	}

	@Override
	public int compareTo(Proceso2 o) {
		int prioridad = this.prioridad - o.getPrioridad();
		if (prioridad == 0) {
			prioridad = this.duracion - o.getDuracion();
		}
		return prioridad;
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
		Proceso2 other = (Proceso2) obj;
		return pid == other.pid;
	}

}
