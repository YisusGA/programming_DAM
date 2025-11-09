package decimales_y_operadores_con_decimales;

import java.util.Scanner;

public class Decimales02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número decimal");
		double n1 = scan.nextDouble();
		System.out.println("Introduce otro número decimal");
		double n2 = scan.nextDouble();
		scan.close();
		/*
		 * En este caso, el resultado sí que es decimal, aunque nosotros introduzcamos números enteros mediante el teclado. Esto es así 
		 * porque ya le hemos dicho a la JVM que estamos operando con números con decimales (tipo Double), y si introducimos números enteros,
		 * los promociona a tipo Double añadiendo un .0 al final del número, y luego hace la operación que le hemos pedido, mostrando un resultado
		 * con cifras decimales (si aplica).
		 */
		double resultado = n1 / n2;
		System.out.println("Resultado: " + resultado);

	}

}
