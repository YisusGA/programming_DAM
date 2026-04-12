package main;

import java.io.File;
import java.util.Scanner;

import logica.Metodos;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Introduzca fichero de préstamos");
		File fileP = new File(scan.nextLine());
		System.out.println("Introduzca fichero de libros");
		File fileL = new File(scan.nextLine());
		
		Metodos.recuperaPrestamos(fileP);
		Metodos.recuperaLibros(fileL);
		
		// Mostrar menú o interfaz gráfica para la gestión
		
		// AL SALIR...
		
		Metodos.guardarLibros(fileL);
		Metodos.guardarPrestamos(fileP);
		
		scan.close();

	}

}
