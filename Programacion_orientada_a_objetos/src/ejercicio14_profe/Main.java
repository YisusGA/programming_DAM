package ejercicio14_profe;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Cuánto gasta tu coche?");
		double gasto = scan.nextDouble();
		
		Vehiculo v = new Vehiculo(gasto);
		
		System.out.println("TRAYECTORIA");
		System.out.println("Cuántos puntos?");
		int numPuntos = scan.nextInt();
		Punto[] trayectoria = new Punto[numPuntos];
		for(int i=0;i<trayectoria.length;i++) {
			System.out.println("X e Y");
			double x = scan.nextDouble();
			double y = scan.nextDouble();
			trayectoria[i] = new Punto(x,y);
		}
		
		System.out.println("Su gasto ha sido:");
		System.out.println(v.gastadoTrayectoria(trayectoria));

	}

}
