package examen_anterior04_ejercicio01;

public class Main {

	public static void main(String[] args) {
		Baraja baraja = new Baraja();
		Jugador yisus = new Jugador("Yisus", 0);
		Jugador dani = new Jugador("Dani", 0);

		// Robamos las 10 primeras cartas
		for (int i = 0; i < 10; i++) {
			yisus.robarCarta();
			dani.robarCarta();
		}
		
		

	}

}
