package variables_booleanas;
import java.util.Scanner;

public class Ejemplo_boolean_decimales_enteros {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número decimal con coma");
		double n = scan.nextDouble();
		boolean b = n > 3;
		System.out.println("La condición es: " + b);
		scan.close();
		

	}

}
