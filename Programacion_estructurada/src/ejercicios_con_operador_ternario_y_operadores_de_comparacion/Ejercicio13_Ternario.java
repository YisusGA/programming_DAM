package ejercicios_con_operador_ternario_y_operadores_de_comparacion;

import java.util.Scanner;

public class Ejercicio13_Ternario {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		System.out.println("Introduce un número entero");
		int n1 = scan.nextInt();
		System.out.println("Introduce otro número entero");
		int n2 = scan.nextInt();
		String mayor = n1 > n2?"El número mayor es n1 = " + n1:"El número mayor es n2 = " + n2;
		System.out.println(mayor);
		scan.close();

	}

}
