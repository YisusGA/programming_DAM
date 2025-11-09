package condicionales;
import java.util.Scanner;

public class Ejemplo_asignación_condicional {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero");
		int num1 = scan.nextInt();
		System.out.println("Introduce otro número entero");
		int num2 = scan.nextInt();
		scan.close();
		int num3;
		if (num1 > num2) {
			num3 = num1;
			System.out.println("El número mayor es el primero y es el que se ha asignado a num3. num3= " + num3);
		} else {
			num3 = num2;
			System.out.println("El número mayor es el segundo y es el que se ha asignado a num3. num3= " + num3);
		}

	}

}
