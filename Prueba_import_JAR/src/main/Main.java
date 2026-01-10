package main;


import teclado.Teclado2;

public class Main {

	public static void main(String[] args) {
		
		//Leer entero
		System.out.println("Introduce un número entero");
		int numInt = Teclado2.leerEntero();
		System.out.println("El número introducido es: " + numInt);
		
		//Leer decimal
		System.out.println("Introduce un número decimal");
		double numDouble = Teclado2.leerDecimal();
		System.out.println("El número introducido es: " + numDouble);
		
		//Leer cadena
		System.out.println("Introduce una palabra o frase");
		String cadena = Teclado2.leerCadena();
		System.out.println("La frase introducida es: " + cadena);
	}

}
