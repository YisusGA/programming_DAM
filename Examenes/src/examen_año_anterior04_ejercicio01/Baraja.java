package examen_año_anterior04_ejercicio01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Baraja {
	static Set<Carta> cartasBaraja = new HashSet<>();

	public Baraja(Set<Carta> cartas) {
		this.cartasBaraja = cartas;
	}

	public Baraja() {

		for (int i = 1; i < 11; i++) {
			cartasBaraja.add(new Carta(Palo.OROS, i));
			cartasBaraja.add(new Carta(Palo.COPAS, i));
			cartasBaraja.add(new Carta(Palo.BASTOS, i));
			cartasBaraja.add(new Carta(Palo.ESPADAS, i));
		}
	}

	public Set<Carta> getCartasBaraja() {
		return cartasBaraja;
	}

	public void setCartasBaraja(Set<Carta> cartasBaraja) {
		this.cartasBaraja = cartasBaraja;
	}

	@Override
	public String toString() {
		return "Baraja [cartasBaraja=" + cartasBaraja + "]";
	}

	public static int cartasRestantes() {
		if (cartasBaraja != null) {
			return cartasBaraja.size();
		}
		return 0;
	}

	public static boolean tieneCartasPalo(String palo) {
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
		boolean encontrado = false;
		for (Carta i : cartasBaraja) {
			if (i.getPalo().equals(carta.getPalo())) {
				encontrado = true;
			}
		}
		return encontrado;
	}

	public static Carta repartirCarta() {
		Carta carta = null;
		Iterator<Carta> it = cartasBaraja.iterator();
		if (it.hasNext()) {
			carta = it.next();
			it.remove();
		}
		return carta;
	}

}
