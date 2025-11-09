package estudio_examen1;

/**
 * Pedir dos fechas y mostrar el número de días que hay de diferencia. Suponiendo todos los meses de 30 días.
 */

import java.util.Scanner;

public class Ejercicio29_SentenciaDecision {

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
		if (day1 < 1 || day1 > 30 || day2 < 1 || day2 > 30 || month1 < 1 || month1 > 30 || month2 < 1 || month2 > 30 || year1 < 0 || year2 < 0) {
			System.out.println("La fecha introducida no es válida");
		} else {
			difference = Math.abs((year2 - year1) * 30 *12 + (month2 - month1) * 30 + day2 - day1);
			System.out.println("La diferencia de días entre ambas fechas es: " + difference);
		}

	}

}
