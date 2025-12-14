package ejercicio14OK;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//Le damos un valor a la propiedad consumo del vehículo que vamos a instanciar
		System.out.println("¿Cuál es el consumo del coche?");
		double consumo;
		while ((consumo = scan.nextDouble()) <= 0) {
			System.out.println("El consumo introducido debe ser mayor que 0");
		}
		Vehiculo vehiculo1 = new Vehiculo(consumo);
		
		//Leemos cuántos puntos de ruta tiene el trayecto
		System.out.println("¿Cuántos puntos de ruta tiene el trayecto?");
		int puntosRuta;
		while ((puntosRuta = scan.nextInt()) < 2) {
			System.out.println("Debe haber al menos 2 puntos de ruta en el trayecto");
		}
		
		//Creamos un array de puntos con tantos puntos como se haya especificado en la variable puntosRuta.
		//Lo rellenamos con puntos cuyas coordenadas leemos por teclado
		Punto[] puntos = new Punto[puntosRuta];
		for (int i = 0; i < puntos.length; i++) {
			System.out.println("Introduce la coordenada x del punto");
			double x = scan.nextDouble();
			System.out.println("Introduce la coordenada y del punto");
			double y = scan.nextDouble();
			puntos[i] = new Punto(x, y);
		}
		
		//Imprimimos el consumo a lo largo del trayecto, redondeado a 2 decimales
		System.out.printf("El consumo de tu coche a lo largo del trayecto es: %.2f", vehiculo1.consumoTrayecto(puntos));
		scan.close();

	}

}
