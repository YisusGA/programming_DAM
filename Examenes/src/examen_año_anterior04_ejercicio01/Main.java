package examen_año_anterior04_ejercicio01;

import java.util.Random;

public class Main {
	static Baraja baraja = new Baraja();
	static Jugador anakin = new Jugador("Anakin", 0);
	static Jugador obiwan = new Jugador("Obi-Wan", 0);
	static String palo;

	public static void main(String[] args) {


		// Robamos las 10 primeras cartas
		for (int i = 0; i < 10; i++) {
			anakin.robarCarta();
			obiwan.robarCarta();
		}

		// Generamos el palo de juego de forma pseudoaleatoria
		palo = escogerPalo();
		System.out.println("En esta partida, pinta " + palo);
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println();
		
		// Comienza la partida, que durará hasta que no queden cartas en la baraja
		do {
			// Cada jugador mira su mano
			System.out.println("Manos");
			System.out.println();
			System.out.println("Mano de Anakin: " + anakin.mostrarMano());
			System.out.println("Mano de Obi-Wan: " + obiwan.mostrarMano());
			System.out.println();
			
			
			// Cada jugador juega una carta
			Carta cartaAnakin = anakin.jugarCarta(palo);
			Carta cartaObiwan = obiwan.jugarCarta(palo);
			if (cartaAnakin != null) {
				System.out.println("Anakin juega " + cartaAnakin);
			} else {
				System.err.println("Anakin descarta su carta porque no es del palo " + palo);
			}
			
			if (cartaObiwan != null) {
				System.out.println("Obi-Wan juega " + cartaObiwan);
			} else {
				System.err.println("Obi-Wan descarta su carta porque no es del palo " + palo);
			}			
			System.out.println();

			// Se decide qué sucede en base a las cartas jugadas
			if (cartaAnakin != null & cartaObiwan != null) {
				if (cartaAnakin.compareTo(cartaObiwan) > 0) {
					System.out.println(anakin.incrementarPuntuacion());
				} else {
					System.out.println(obiwan.incrementarPuntuacion());
				}
			} else if (cartaAnakin == null & cartaObiwan == null) {
				while (anakin.numeroCartas() < 11) {
					anakin.robarCarta();
				}
				while (obiwan.numeroCartas() < 11) {
					obiwan.robarCarta();
				}
				System.out.println();
				System.out.println("Ambos roban cartas hasta volver a tener 10 cartas en sus manos");
				System.out.println();
			} else if (cartaAnakin == null) {
				System.out.println(obiwan.incrementarPuntuacion());
			} else {
				System.out.println(anakin.incrementarPuntuacion());
			}
			System.out.println();
			System.out.println("----------------------------------------");
			System.out.println();

		} while (Baraja.cartasRestantes() > 0 && quedanCartasPalo());

		// Mostramos el resultado de la partida y el ganador
		System.out.println("Puntuación final (CERVEZA CRIIIIISTAAAAAAL)");
		System.out.println("----------------");
		System.out.println();
		System.out.printf("Anakin: %d%n", anakin.getPuntuacion());
		System.out.printf("Obi-Wan: %d%n", obiwan.getPuntuacion());
		System.out.println("----------------");
		System.out.println("El ganador es: " + (anakin.getPuntuacion() > obiwan.getPuntuacion() ? "Anakin" : "Obi-Wan"));

	}

	public static String escogerPalo() {
		Random generador = new Random();
		String palo = "OROS";
		boolean valido = false;
		int opcion = generador.nextInt(1, 4);
		do {
			switch (opcion) {
			case 1 -> {
				palo = "OROS";
				valido = true;
			}
			case 2 -> {
				palo = "COPAS";
				valido = true;
			}
			case 3 -> {
				palo = "BASTOS";
				valido = true;
			}
			case 4 -> {
				palo = "ESPADAS";
				valido = true;
			}
			default -> {
				System.err.println("La opción introducida no es válida");
			}
			}
		} while (!valido);
		return palo;
	}
	
	public static boolean quedanCartasPalo () {
		boolean quedan = false;
		if (anakin.tieneCartasPalo(palo) || obiwan.tieneCartasPalo(palo) || Baraja.tieneCartasPalo(palo)) {
			quedan = true;
		}	
		return quedan;
	}

}
