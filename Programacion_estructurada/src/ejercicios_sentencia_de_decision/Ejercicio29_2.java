package ejercicios_sentencia_de_decision;

/**
 * Pedir dos fechas y mostrar el número de días que hay de diferencia. Considerar los días correctos que tiene cada mes. No considerar años bisiestos. Febrero siempre tendrá 28 días
 * Este ejercicio parece casi imposible de hacer con las herramientas que tenemos hasta ahora.
 */

import java.util.Scanner;

public class Ejercicio29_2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Fecha 1: Introduce un año");
		int year1 = scan.nextInt();
		System.out.println("Fecha 1: Introduce un número de mes");
		int month1 = scan.nextInt();
		System.out.println("Fecha 1: Introduce el día del mes");
		int day1 = scan.nextInt();
		System.out.println("Fecha 2: Introduce un año");
		int year2 = scan.nextInt();
		System.out.println("Fecha 2: Introduce un número de mes");
		int month2 = scan.nextInt();
		System.out.println("Fecha 2: Introduce el día del mes");
		int day2 = scan.nextInt();
		scan.close();
		int difference = 1;
		if (year1 < 0 || month1 < 1 || day1 < 1 || year2 < 0 || month2 < 1 || day2 < 1) {
			System.err.print("ERROR: no se pueden introducir números negativos ni días menores a 1 ni meses menores a 1 ni meses mayores a 12");
			return;
		} else if ((month1 == 1 && day1 > 31) || (month1 == 3 && day1 > 31) || (month1 == 5 && day1 > 31) || (month1 == 7 && day1 > 31) || (month1 == 8 && day1 > 31) || (month1 == 10 && day1 > 31) || (month1 == 12 && day1 > 31) || (month2 == 1 && day2 > 31) || (month2 == 3 && day2 > 31) || (month2 == 5 && day2 > 31) || (month2 == 7 && day2 > 31) || (month2 == 8 && day2 > 31) || (month2 == 10 && day2 > 31) || (month2 == 12 && day2 > 31) || (month1 == 4 && day1 > 30) || (month1 == 6 && day1 > 30) || (month1 == 9 && day1 > 30) || (month1 == 11 && day1 > 30) || (month2 == 4 && day2 > 30) || (month2 == 6 && day2 > 30) || (month2 == 9 && day2 > 30) || (month2 == 11 && day2 > 30) || (month1 == 2 && day1 > 28) || (month1 == 2 && day2 > 28)) {
				System.out.println("Al menos uno de los meses introducidos no puede contener el número de días introducido");
		}	

	}

}
