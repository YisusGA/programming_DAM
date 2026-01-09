package main;


import teclado.Teclado2;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Introduce un número entero");
		int num = Teclado2.leerEntero();
		System.out.println("El número introducido es: " + num);
	}

}
