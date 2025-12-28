package others;

import java.util.Scanner;

public class Numero_capicua {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero");
		int num = scan.nextInt();
		int reverse = 0;
		for (int temp = num; temp > 0; temp /= 10) {
			reverse = reverse * 10 + temp % 10;
		}
		
		if (reverse == num) {
			System.out.println("El número es capicúa");
		} else {
			System.out.println("El número no es capicúa");
		}
		scan.close();

	}

}
