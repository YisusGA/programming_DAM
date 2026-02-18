package examen_año_anterior05_ejercicio01;

public class MagoFuego extends MagoElemental {
	Double superficie;

	@Override
	public String lanzarHechizo() {
		return "He lanzado un hechizo de fuego capaz de quemar la superficie " + superficie + " m2";
	}
}
