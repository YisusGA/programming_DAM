package ejercicios_sentencia_de_decision;

/**
 * Pedir dos fechas y mostrar el número de días que hay de diferencia. Suponiendo todos los meses de 30 días.
 */

import java.util.Scanner;

public class Ejercicio29 {

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
		if (year1 < 0 || month1 < 0 || day1 < 0 || year2 < 0 || month2 < 0 || day2 < 0) {
			System.err.print("ERROR: no se pueden introducir números negativos");
		} else {
			if (month1 < 1 || month1 > 12 || month2 < 1 || month2 > 12) {
				System.out.println("Al menos uno de los meses introducidos no es válido, debe estar comprendido entre 1 y 12");
			} else if (day1 < 1 || day1 > 30 || day2 < 1 || day2 > 30) {
				System.out.println("Un mes no puede contener menos de 1 día ni más de 30");
			} else {
				difference = Math.abs((year2 - year1) * 30 * 12 + (month2 - month1) * 30 + day2 - day1);
				System.out.println("La diferencia de días es de: " + difference + " días");
				
				//Esta forma de debajo es cómo lo hizo Alberto
//				int total1 = (year1 * 12 * 30) + (month1 * 30) + day1;
//				int total2 = (year2 * 12 * 30) + (month2 * 30) + day2;
//				int diferencia = Math.abs(total1 - total2);
//				System.out.println("La diferencia de días es de: " + diferencia + " días");
			}					
		}	
	}

}
