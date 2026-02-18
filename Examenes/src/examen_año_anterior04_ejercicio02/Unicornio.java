package examen_año_anterior04_ejercicio02;

public class Unicornio extends CriaturaMistica implements PoderMistico {
	Double longitudCuerno;

	public Unicornio(String nombre, int edad, Double longitudCuerno) {
		super(nombre, edad);
		this.longitudCuerno = longitudCuerno;
	}

	public Unicornio(String nombre, int edad) {
		super(nombre, edad);
	}

	public Unicornio() {

	}

	public Double getLongitudCuerno() {
		return longitudCuerno;
	}

	public void setLongitudCuerno(Double longitudCuerno) {
		this.longitudCuerno = longitudCuerno;
	}

	@Override
	public String describirCriatura() {
		return "Unicornio [nombre=" + nombre + ", edad=" + edad + " años, longitudCuerno=" + longitudCuerno + " cm]";
	}

	@Override
	public String toString() {
		return "Unicornio [nombre=" + nombre + ", edad=" + edad + " años, longitudCuerno=" + longitudCuerno + " cm]";
	}

	@Override
	public String activarPoder() {
		return "El cuerno del unicornio " + this.nombre + " comenzó a brillar y salió un rayo iridescente de él";

	}

}
