package estudio_examen1;

/*
 * Pedir el día, mes y año de una fecha e indicar si la fecha es correcta. Tener en cuenta el número de días variables de cada mes,
 * incluyendo si febrero es bisiesto o no
 */

import java.util.Scanner;

public class Ejercicio25_SentenciaDecision {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce una fecha en el formato dd/mm/aaaa");
		String date = scan.nextLine();
		scan.close();
		int longitudeDate = date.length();
		if (longitudeDate < 10) {
			System.out.println("El formato de fecha introducido no es correcto");
			System.exit(0);
		}
		String dayText = "" + date.charAt(0) + date.charAt(1);
		String monthText = "" + date.charAt(3) + date.charAt(4);
		String yearText = "" + date.charAt(6) + date.charAt(7) + date.charAt(8) + date.charAt(9);
		int day = Integer.parseInt(dayText);
		int month = Integer.parseInt(monthText);
		int year = Integer.parseInt(yearText);
		boolean monthCheck = true;
		boolean bisiesto = (year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0);
		if (month == 4 || month == 6 || month == 9 || month == 1) {
			monthCheck = day <= 30;
		} else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			monthCheck = day <= 31;
		} else {
			monthCheck = bisiesto == true ? day <= 29 : day <= 28;
		}
		if (year < 0 || month < 1 || month > 12 || day < 1 || !monthCheck) {
			System.out.println("La fecha introducida no es válida");
		} else {
			System.out.println("La fecha introducida es válida");
		}
	}

}
