package ejercicio14;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Vehiculo vehiculo1 = new Vehiculo(scan);
		Punto punto = new Punto();
		System.out.println("¿Cuántos desplazamientos hay en tu trayecto? Un desplazamiento es entendido como viajar de un punto a otro");
		int desplazamientos;
		while ((desplazamientos = scan.nextInt()) < 1) {
			System.err.println("Debes introducir al 1 desplazamiento");
		}
		double[] distancias = new double[desplazamientos];
		System.out.println("Introduce la coordenada x del primer punto"); //Esta sólo se lee una vez, pues luego se va sustituyendo la x de partida del cálculo de la distancia por la del nuevo punto al que se ha viajado, tras haber calculado la distancia
		punto.x1 = scan.nextDouble();
		System.out.println("Introduce la coordenada y del primer punto"); //Esta sólo se lee una vez, pues luego se va sustituyendo la x de partida del cálculo de la distancia por la del nuevo punto al que se ha viajado, tras haber calculado la distancia
		punto.y1 = scan.nextDouble();
		for (int i = 0; i < distancias.length; i++) {
			System.out.println("Introduce la coordenada x del siguiente punto");
			double x2 = scan.nextDouble();
			System.out.println("Introduce la coordenada y del siguiente punto");
			double y2 = scan.nextDouble();
			distancias[i] = punto.distancia(x2, y2); //Calculamos la distancia entre los puntos y la añadimos a un array de distancias
		}
		System.out.println("El consumo total del trayecto ha sido: " + vehiculo1.consumoTrayecto(distancias)); //Mostramos el consumo del trayecto usando el método consumoTrayecto de la clase Vehículo, usando el array distancias que hemos llenado antes
		scan.close();
	}

}
