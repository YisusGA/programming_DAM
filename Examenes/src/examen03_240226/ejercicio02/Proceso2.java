package examen03_240226.ejercicio02;

public class Proceso2 implements Comparable<Proceso2> {
	private int prioridad, duracion;
	private static int pid = 0;

	public Proceso2(int prioridad, int duracion) {
		pid++;
		this.prioridad = prioridad;
		this.duracion = duracion;
	}

	public Proceso2() {
		pid++;
	}

	public int getPid() {
		return pid;
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

	// ¿Por qué no me deja implementar un hashCode y un equals por pid?
	
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

}
