package examen_año_anterior05_ejercicio01;

public class MagoFuego extends MagoElemental {
	Double superficie;

	public MagoFuego(String nombre, Double superficie) {
		super(nombre);
		this.superficie = superficie;
	}

	public MagoFuego(String nombre) {
		super(nombre);

	}

	public MagoFuego() {

	}

	public Double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(Double superficie) {
		this.superficie = superficie;
	}

	@Override
	public String toString() {
		return "MagoFuego [nombre=" + nombre + ", superficie=" + superficie + "]";
	}

	@Override
	public String lanzarHechizo() {
		return "He lanzado un hechizo de fuego capaz de quemar la superficie " + superficie + " km2";
	}
}
