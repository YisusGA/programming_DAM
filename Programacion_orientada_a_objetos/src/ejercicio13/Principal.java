package ejercicio13;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Cafetera cafetera = new Cafetera(scan); //Es necesario poner esto cuando en el método constructor leemos algo por Scanner
		boolean salir = false;
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
			switch(scan.nextInt()) {
				case 1 -> {
					cafetera.llenarCafetera();
				}
				case 2 -> {
					System.out.println("¿Cuál es la capacidad de la taza?");
					cafetera.servirTaza(scan.nextInt());
				}
				case 3 -> {
					cafetera.vaciarCafetera();
				}
				case 4 -> {
					System.out.println("¿Qué cantidad de café quieres agregar a la cafetera?");
					cafetera.agregarCafe(scan.nextInt());
				}
				case 5 -> {
					salir = true;
				}
				default -> {
					System.out.println("El valor introducido no es admitido");
				}
			}
			System.out.printf("%n%nLa cantidad actual de café en la cafetera es: %d %n %n", cafetera.cantidadActual);
		}
		if (salir) {
			System.out.printf("Gracias por confiar en Yisus & Friends Coffe S.L. %nHasta la próxima");
		}
		scan.close();
	}

}
