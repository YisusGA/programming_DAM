package ejercicio14;

import java.util.Scanner;

class Vehiculo {
	double consumoVehiculo; //Los litros que consume el vehículo por cada kilómetro
	
	
	//Método constructor para leer por teclado el consumo del coche al instanciar la clase Vehiculo
	Vehiculo (Scanner scan) {
		System.out.println("Introduce el consumo en litros del vehículo por kilómetro recorrido");
		consumoVehiculo = scan.nextDouble();
	}
	
	/**
	 * 
	 * @param distancias. Es un array con las distancias calculadas entre cada punto de la ruta
	 * @return El consumo total del trayecto calculado multiplicando cada distancia por el consumo del vehículo, y se va sumando
	 */
	double consumoTrayecto(double distancias[]) {
		double result = 0;
		for (int i = 0; i < distancias.length; i++) {
			result += distancias[i] * consumoVehiculo;
		}
		return result;
	}
}
