package examen03_240226.ejercicio01;

public class Conejo extends Animal implements Presa {

	public Conejo(String nombre, int energia) {
		super(nombre, energia);
	}

	public Conejo(String nombre) {
		super(nombre);
	}

	public Conejo() {
	}

	@Override
	public void huir() {
		this.energia = 1;

	}

	@Override
	public void comer(int cantidad) {
		if (this.energia + cantidad / 2 > 100) {
			this.energia = 100;
		} else {
			this.energia += cantidad / 2;
		}

	}

}
