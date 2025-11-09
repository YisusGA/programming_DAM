package ejercicios_sentencia_de_decision;

/*
 * Pedir el día, mes y año de una fecha e indicar si la fecha es correcta. Tener en cuenta el número de días variables de cada mes,
 * incluyendo si febrero es bisiesto o no
 */

import java.util.Scanner;

public class Ejercicio25 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un año");
		int year = scan.nextInt();
		System.out.println("Introduce un número de mes");
		int month = scan.nextInt();
		System.out.println("Introduce el día del mes");
		int day = scan.nextInt();
		scan.close();
		if (year < 0 || month < 0 || day < 0) {
			System.err.print("ERROR: no se pueden introducir números negativos");
			return;
		} else {
			if (month < 1 || month > 12) {
				System.out.println("El mes introducido no es válido, debe estar comprendido entre 1 y 12");
			} else if (day < 1 || day > 31) {
				System.out.println("Un mes no puede contener menos de 1 día ni más de 31");
			} else if (month == 4 || month == 6 || month == 9 || month == 11) {
				String month30 = day <= 30 ? "La fecha introducida es válida" : "La fecha introducida no es válida, el mes introducido debe tener 30 días";
				System.out.println(month30);
			} else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				String month31 = day <= 31 ? "La fecha introducida es válida" : "La fecha introducida no es válida, el mes introducido debe tener 31 días";
				System.out.println(month31);
			} else {
				boolean bisiesto = (year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0);
				if (bisiesto == true) {
					String febrBisiesto = day <= 29 ? "La fecha introducida es válida" : "La fecha introducida no es válida, el mes introducido debe tener 29 días cuando el año es bisiesto";
					System.out.println(febrBisiesto);
				} else {
					String febrNoBisiesto = day <= 28 ? "La fecha introducida es válida" : "La fecha introducida no es válida, el mes introducido debe tener 28 días cuando el año no es bisiesto";
					System.out.println(febrNoBisiesto);
				}
			}
		}

	}

}
