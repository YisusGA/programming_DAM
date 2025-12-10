package ejercicio13;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("¿Cuál es la capacidad de la cafetera?");
		int capacidadMaxima;
		int cantidadActual;
		while ((capacidadMaxima = scan.nextInt()) <= 0) {
			System.err.println("El valor introducido debe ser mayor que 0");
			System.out.println("Prueba de nuevo");
		}
		System.out.println("¿Qué cantidad de café tiene actualmente la cafetera?");
		while ((cantidadActual = scan.nextInt()) < 0) {
			System.err.println("El valor introducido debe ser mayor o igual que 0");
			System.out.println("Prueba de nuevo");
		}
		Cafetera cafetera = new Cafetera(capacidadMaxima, cantidadActual); //Es necesario poner esto cuando en el método constructor leemos algo por Scanner
		boolean salir = false;
		int opcion = 0; //Inicializamos la variable de la opción que escogerá el usuario
		while (!salir) {
			System.out.println("""
					
					Bienvenido a Yisus & Friends Coffe S.L.
					
					¿Qué acción desea realizar?
					
					1-Llenar la cafetera
					2-Servir una taza de café
					3-Vaciar la cafetera
					4-Agregar café a la cafetera
					5-Salir
					
					""");
			switch(opcion = scan.nextInt()) {
				case 1 -> {
					System.out.println(cafetera.llenarCafetera());
				}
				case 2 -> {
					System.out.println("¿Cuál es la capacidad de la taza?");
					System.out.println(cafetera.servirTaza(scan.nextInt()));
				}
				case 3 -> {
					System.out.println(cafetera.vaciarCafetera());
				}
				case 4 -> {
					System.out.println("¿Qué cantidad de café quieres agregar a la cafetera?");
					System.out.println(cafetera.agregarCafe(scan.nextInt()));
				}
				case 5 -> {
					salir = true;
				}
				default -> {
					System.err.println("El valor introducido no es admitido");
				}
			}
			if (opcion != 5) {
				System.out.printf("%n%nLa cantidad actual de café en la cafetera es: %d %n %n", cafetera.cantidadActual);
			}
		}
		if (salir) {
			System.out.printf("Gracias por confiar en Yisus & Friends Coffe S.L. %nHasta la próxima");
		}
		scan.close();
	}

}
