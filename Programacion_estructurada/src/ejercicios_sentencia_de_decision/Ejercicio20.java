package ejercicios_sentencia_de_decision;

import java.util.Scanner;

public class Ejercicio20 {

	/**
	 * Recibe 3 números, op, num1 y num2.
	 * Si op es 1, escribe num1+num2, 
     * si op es 2, escribe num1-num2,
	 * en todos los otros casos escribe “Operación no valida” 
	 */
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Elige entre el número 1 y el 2 e introduce uno");
		int op = scan.nextInt();
		System.out.println("Introduce un número entero");
		int num1 = scan.nextInt();
		System.out.println("Introduce otro número entero");
		int num2 = scan.nextInt();
		scan.close();
		int operacion;
		if (op != 1 && op != 2) {
			System.out.println("El primer número que has introducido no es válido, debe ser 1 o 2");
		} else if (op == 1) {
			operacion = num1 + num2;
			System.out.println("El resultado es: " + operacion);
		}
		else {
			operacion = num1 - num2;
			System.out.println("El resultado es: " + operacion);
		}
		
		
		
	}

}
