package ejercicio04_zoologico_virtual;

public class Perro extends Animal {
	private String raza;

	public Perro(String nombre, int edad, String raza) {
		super(nombre, edad);
		this.raza = raza;
	}

	public Perro(String raza) {
		this.raza = raza;
	}

	public Perro() {

	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	@Override
	public String hacerSonido() {
		return "El perro hizo guau";
	}

	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + "]";
	}

}
