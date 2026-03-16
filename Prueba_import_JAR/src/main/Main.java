package main;


import teclado.TecladoOK;

public class Main {

	public static void main(String[] args) {
		
		//Leer entero
		System.out.println("Introduce un número entero");
		int numInt = TecladoOK.leerEntero();
		System.out.println("El número introducido es: " + numInt);
		
		//Leer decimal
		System.out.println("Introduce un número decimal");
		double numDouble = TecladoOK.leerDecimal();
		System.out.println("El número introducido es: " + numDouble);
		
		//Leer cadena
		System.out.println("Introduce una palabra o frase");
		String cadena = TecladoOK.leerCadena();
		System.out.println("La frase introducida es: " + cadena);
	}

}
