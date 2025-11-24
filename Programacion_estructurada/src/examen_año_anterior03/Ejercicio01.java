package examen_año_anterior03;

import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean cuenta = false;
		int contadorPlato1 = 0;
		int contadorPlato2 = 0;
		int contadorPostre = 0;
		double precioPrimero = 8;
		double precioSegundo = 10;
		double preciocontadorPostre = 5;
		double precioMenu = 20;
		int contadorMenu = 0;
		while (!cuenta) {
			int opcion;
			System.out.println("""
					Bienvenido al Restaurante de Yisus
					Elige una opción:
					1. Ordenar un primer plato que vale 8 euros
					2. Ordenadr un segundo plato que vale 10 euros
					3. Ordenar un contadorPostre que vale 5 euros
					4. Pedir cuenta
					""");
			opcion = scan.nextInt();
			switch (opcion) {
			case 1:
				contadorPlato1++;
				break;
			case 2:
				contadorPlato2++;
				break;
			case 3:
				contadorPostre++;
				break;
			case 4:
				cuenta = true;
				break;
			default:
				System.out.println("El número introducido no es válido, introduce un número entre 1 y 4");
				break;
			}
		}
		while (contadorPlato1 > 0 && contadorPlato2 > 0 && contadorPostre > 0) {
			contadorMenu++;
			contadorPlato1--;
			contadorPlato2--;
			contadorPostre--;
		}
		double precio = precioMenu * contadorMenu + precioPrimero * contadorPlato1 + precioSegundo * contadorPlato2
				+ preciocontadorPostre * contadorPostre;
		if (precio >= 51) {
			precio *= 0.9;
		}
		System.out.printf(
				" Has pedido: %n %d menus %n %d primeros platos %n %d segundos platos %n %d postres. %n Te has gastado: %.2f",
				contadorMenu, contadorPlato1, contadorPlato2, contadorPostre, precio);
		// Otra forma de imprimir esto con la triple comilla
//		System.out.printf("""
//							 Has pedido: 
//							 %d menus
//							 %d primeros platos
//							 %d segundos platos
//							 %d postres
//							 Te has gastado: %.2f""", 
//							 contadorMenu, contadorPlato1, contadorPlato2, contadorPostre, precio);
		scan.close();
	}

}
