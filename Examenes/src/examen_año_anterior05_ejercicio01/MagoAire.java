package examen_año_anterior05_ejercicio01;

public class MagoAire extends MagoElemental {
	Double velocidad;

	public MagoAire(String nombre, Double velocidad) {
		super(nombre);
		this.velocidad = velocidad;
	}

	public MagoAire(String nombre) {
		super(nombre);
	}

	public MagoAire() {
	}

	public Double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(Double velocidad) {
		this.velocidad = velocidad;
	}

	@Override
	public String lanzarHechizo() {
		return "He lanzado un hechizo de viento con la velocidad" + velocidad + " km/h";

	}

}
