package ejercicio04_zoologico_virtual;

public class Ave extends Animal {
	double envergadura;

	public Ave(String nombre, int edad, double envergadura) {
		super(nombre, edad);
		this.envergadura = envergadura;
	}

	public Ave(double envergadura) {
		this.envergadura = envergadura;
	}

	public Ave() {

	}

	public double getEnvergadura() {
		return envergadura;
	}

	public void setEnvergadura(double envergadura) {
		this.envergadura = envergadura;
	}

	@Override
	public String hacerSonido() {
		return "El ave hizo un graznido";
	}

	@Override
	public String toString() {
		return "Ave [nombre=" + nombre + ", edad=" + edad + ", envergadura=" + envergadura + "]";
	}

}
