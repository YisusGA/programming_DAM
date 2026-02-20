package ejercicio04_zoologico_virtual;

public class Gato extends Animal {
	private int numeroVidasRestantes;

	public Gato(String nombre, int edad, int numeroColores) {
		super(nombre, edad);
		this.numeroVidasRestantes = numeroColores;
	}

	public Gato(int numeroColores) {
		this.numeroVidasRestantes = numeroColores;
	}

	public Gato() {
	}

	public int getNumeroColores() {
		return numeroVidasRestantes;
	}

	public void setNumeroColores(int numeroColores) {
		this.numeroVidasRestantes = numeroColores;
	}

	@Override
	public String hacerSonido() {
		return "El gato hizo miau";
	}

	@Override
	public String toString() {
		return "Gato [nombre=" + nombre + ", edad=" + edad + ", numeroColores=" + numeroVidasRestantes + "]";
	}

}
