package examen_año_anterior04_ejercicio02;

public class Dragon extends CriaturaMistica implements PoderMistico {
	Double temperaturaFuego;

	public Dragon(String nombre, int edad, Double temperaturaFuego) {
		super(nombre, edad);
		this.temperaturaFuego = temperaturaFuego;
	}

	public Dragon(String nombre, int edad) {
		super(nombre, edad);
	}

	public Dragon() {

	}

	public Double getTemperaturaFuego() {
		return temperaturaFuego;
	}

	public void setTemperaturaFuego(Double temperaturaFuego) {
		this.temperaturaFuego = temperaturaFuego;
	}

	@Override
	public String describirCriatura() {
		return "Dragon [nombre=" + nombre + ", edad=" + edad + " años, temperaturaFuego=" + temperaturaFuego + " ºC]";
	}

	@Override
	public String toString() {
		return "Dragon [nombre=" + nombre + ", edad=" + edad + " años, temperaturaFuego=" + temperaturaFuego + " ºC]";
	}

	@Override
	public String activarPoder() {
		return "El dragón " + this.nombre + " lanzó una llamarada de fuego carmesí que cubrió el cielo";
	}

}
