package examen_año_anterior04_ejercicio02;

public class Elfo extends CriaturaMistica implements PoderMistico {
	int numeroGrimorios;

	public Elfo(String nombre, int edad, int numeroGrimorios) {
		super(nombre, edad);
		this.numeroGrimorios = numeroGrimorios;
	}

	public Elfo(String nombre, int edad) {
		super(nombre, edad);
	}

	public Elfo() {

	}

	public int getNumeroGrimorios() {
		return numeroGrimorios;
	}

	public void setNumeroGrimorios(int numeroGrimorios) {
		this.numeroGrimorios = numeroGrimorios;
	}

	@Override
	public String describirCriatura() {
		return "Elfo [nombre=" + nombre + ", edad=" + edad + " años, numeroGrimorios=" + numeroGrimorios + "]";
	}

	@Override
	public String toString() {
		return "Elfo [nombre=" + nombre + ", edad=" + edad + " años, numeroGrimorios=" + numeroGrimorios + "]";
	}

	@Override
	public String activarPoder() {
		return "La elfa " + this.nombre
				+ " comenzó a mover las manos y a recitar unas palabras en élfico, y el campo a su alrededor se llenó de hermosas flores que brotaron del suelo";

	}

}
