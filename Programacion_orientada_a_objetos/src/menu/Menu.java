package menu;

import teclado.Teclado2;

public class Menu {
	
	public static int mostrarMenu() {
		System.out.println("""
				Bienvenido
				Escoge una opción
				1. Opción 1
				2. Opción 2
				3. Opción 3
				4. Opción 4
				5. Opción 5
				0. Salir del menú
				""");
		return Teclado2.leerEntero();
	}
}
