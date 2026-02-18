package examen_año_anterior04_ejercicio02;

public abstract class CriaturaMistica implements PoderMistico {
	String nombre;
	int edad;

	public CriaturaMistica(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	public CriaturaMistica(String nombre) {
		this.nombre = nombre;
	}

	public CriaturaMistica(int edad) {
		this.edad = edad;
	}

	public CriaturaMistica() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "CriaturaMistica [nombre=" + nombre + ", edad=" + edad + " años]";
	}

	@Override
	public String activarPoder() {
		return null;
	}

	public abstract String describirCriatura();

}
