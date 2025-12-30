package others;

import java.util.Scanner;

public class NumeroMayor {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el primer número");
		int a = scan.nextInt();
		System.out.println("Introduce el segundo número");
		int b = scan.nextInt();
		int max = (a + b + Math.abs(a - b)) / 2;
		System.out.printf("El número mayor es: %d", max);
		scan.close();
	}

}
