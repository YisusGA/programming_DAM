package ejercicios_con_operador_ternario_y_operadores_de_comparacion;

import java.util.Scanner;

public class Ejercicio17 {

	//Escribe un programa que lea por teclado tres variables enteras y muestre en pantalla la suma de
	//dichos números, pero si la suma es mayor que 100, muestra un mensaje indicando que es
	//demasiado grande
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero");
		int n1 = scan.nextInt();
		System.out.println("Introduce otro número entero");
		int n2 = scan.nextInt();
		System.out.println("Introduce un tercer número entero");
		int n3 = scan.nextInt();
		int suma = n1 + n2 + n3;
		String print = suma < 100? "El resultado de sumar los 3 números es: " + suma: "AVISO: El número es demasiado grande";
		System.out.println(print);
		scan.close();

	}

}
