package examen_año_anterior04_ejercicio01;

import java.util.Objects;

public class Carta implements Comparable<Carta> {
	private Palo palo;
	private int numero;

	public Carta(Palo palo, int numero) {
		this.palo = palo;
		this.numero = numero;
	}

	public Carta(Palo palo) {
		this.palo = palo;
	}

	public Carta() {
	}

	public Palo getPalo() {
		return palo;
	}

	public void setPalo(Palo palo) {
		this.palo = palo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Carta [palo=" + palo + ", numero=" + numero + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero, palo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		return numero == other.numero && palo == other.palo;
	}

	@Override
	public int compareTo(Carta o) {
		return this.numero - o.getNumero();
	}

}
