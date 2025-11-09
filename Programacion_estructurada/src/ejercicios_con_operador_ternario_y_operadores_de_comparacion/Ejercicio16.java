package ejercicios_con_operador_ternario_y_operadores_de_comparacion;

import java.util.Scanner;

public class Ejercicio16 {

	//Escribe un programa que lea por teclado dos variables enteras para representar la cantidad de
	//productos en dos almacenes diferentes. Muestra en pantalla un mensaje que indique cuál de los
	//dos almacenes tiene más productos.
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el número de tarjetas gráficas que hay en el almacén A");
		int n1 = scan.nextInt();
		System.out.println("Introduce el número de tarjetas gráficas que hay en el almacén B");
		int n2 = scan.nextInt();
		String print = n1 > n2?"El almacen A tiene mayor stock de tarjetas gráficas. Tiene " + n1 + " tarjetas gráficas":"El almacén B tiene mayor stock de tarjetas gráficas. Tiene " + n2 + " tarjetas gráficas";
		System.out.println(print);
		scan.close();

	}

}
