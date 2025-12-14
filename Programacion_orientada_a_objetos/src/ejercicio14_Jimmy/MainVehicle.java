package ejercicio14_Jimmy;

//Clase hecha por Jimmy de DAM

import java.util.Scanner;

//Ejercicio hecho por Jimmy de DAM

import ejercicio14_Jimmy.Round;

class MainVehicle {

	public static void main(String[] args) {
		
		Scanner KB = new Scanner(System.in);
		Round redondeo = new Round(2);
		
		Vehicle vehiculo = new Vehicle();

		System.out.print("Cuantos puntos tiene tu recorrido: ");
		int route;
		while((route = KB.nextInt())<2)
			System.err.println("ERROR. El recorrido tiene que tener al menos 2 puntos."
					+ "Intentalo de nuevo");
		
		Point[] punto = new Point[route];
		
		for(int i = 0 ; i<route ; i++) {
			System.out.println("Punto "+i);
			punto[i] = new Point();
		}
		System.out.println("Distancia recorrida: "+redondeo.rounder(vehiculo.route(punto)) +"km");
		System.out.println("El coste total de la ruta es de: "
				+redondeo.rounder(vehiculo.total)+"€");
	}
	
}
