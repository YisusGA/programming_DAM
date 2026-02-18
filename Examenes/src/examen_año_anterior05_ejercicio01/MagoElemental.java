package examen_año_anterior05_ejercicio01;

public abstract class MagoElemental {
	protected String nombre;

	public MagoElemental(String nombre) {
		this.nombre = nombre;
	}

	public MagoElemental() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public abstract String lanzarHechizo();

	@Override
	public String toString() {
		return "MagoElemental [nombre=" + nombre + "]";
	}

}
