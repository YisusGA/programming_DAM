package main;

import java.util.Scanner;

import teclado.TecladoOK;

public class Main {

	public static void main(String[] args) {
		int opcion;

		do {
			opcion = mostrarMenu();

			switch (opcion) {
			case 1 -> {
				//Opción 1
			}
			case 2 -> {
				//Opción 2
			}
			case 3 -> {
				//Opción 3
			}
			case 4 -> {
				//Opción 4
			}
			case 5 -> {
				//Opción 5
			}
			case 0 -> {
				System.out.println("Saliendo del menú...");
			}
			default -> {
				System.err.println("La opción introducida no es válida");
			}
			}
		} while (opcion != 0);
	}

	public static int mostrarMenu() {
		System.out.println("""
				Bienvenido
				Escoge una opción
				1. Insertar
				2. Recuperar
				3. Eliminar
				4. Modificar
				5. Opción 5
				0. Salir del menú
				""");
		return TecladoOK.leerEntero();
	}

}
