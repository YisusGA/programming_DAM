package examen_año_anterior04_ejercicio01;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Jugador {
	String nombre;
	int puntuacion;
	List<Carta> cartasMano = new ArrayList<>();

	public Jugador(String nombre, int puntuacion, List<Carta> cartasMano) {
		this.nombre = nombre;
		this.puntuacion = puntuacion;
		this.cartasMano = cartasMano;
	}

	public Jugador(String nombre, int puntuacion) {
		this.nombre = nombre;
		this.puntuacion = puntuacion;
	}

	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	public Jugador() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public List<Carta> getCartasMano() {
		return cartasMano;
	}

	public void setCartasMano(List<Carta> cartasMano) {
		this.cartasMano = cartasMano;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", puntuacion=" + puntuacion + "]";
	}

	public void robarCarta() {
		this.cartasMano.add(Baraja.repartirCarta());

	}

	public Carta jugarCarta(String palo) {
		Carta carta = null;
		switch (palo) {
		case "OROS" -> {
			carta = new Carta(Palo.OROS);
		}
		case "COPAS" -> {
			carta = new Carta(Palo.COPAS);
		}
		case "BASTOS" -> {
			carta = new Carta(Palo.BASTOS);
		}
		case "ESPADAS" -> {
			carta = new Carta(Palo.ESPADAS);
		}
		}
		int max = 0;
		boolean encontrado = false;
		for (Carta i : cartasMano) {
			if (i.getPalo().equals(carta.getPalo())) {
				if (i.getNumero() > max) {
					encontrado = true;
					max = i.getNumero();
				}
			}
		}
		carta.setNumero(max);
		if (encontrado) {
			return carta;
		} else {
			return null;
		}
	}
	
	public void mostrarMano() {
		System.out.println(cartasMano);
	}

}
