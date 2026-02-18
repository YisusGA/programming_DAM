package examen_año_anterior05_ejercicio01;

public class MagoEstudiante extends MagoElemental implements Aprendiz {

	public MagoEstudiante(String nombre) {
		super(nombre);
	}

	public MagoEstudiante() {

	}

	@Override
	public String toString() {
		return "MagoEstudiante [nombre=" + nombre + "]";
	}

	@Override
	public String estudiar() {
		return "Shhhh, estoy estudiando";
	}

	@Override
	public String lanzarHechizo() {
		return "Aún estoy en prácticas y no me han dado un elemento...";
	}

}
