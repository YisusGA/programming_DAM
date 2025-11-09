package ejercicios_con_operador_ternario_y_operadores_de_comparacion;

import java.util.Scanner;

public class Ejercicio13 {

	//Esta es una forma de resolver el ejercicio 13, pero no es usando un operador ternario, que es el que pide.
	//En el momento en el que hice este ejercicio, aún no habíamos visto los operadores ternarios.
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero");
		int n1 = scan.nextInt();
		System.out.println("Introduce otro número entero");
		int n2 = scan.nextInt();
		if (n1 > n2) {
			System.out.println("El número mayor es el primero: " + n1);
		} else {
			System.out.println("El número mayor es el segundo: " + n2);
		}
	}

}