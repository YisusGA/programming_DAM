package ejercicio13;

import java.util.Scanner;

public class PrincipalAlt {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CafeteraAlt cafetera = new CafeteraAlt(scan); //Es necesario poner esto cuando en el método constructor leemos algo por Scanner
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
