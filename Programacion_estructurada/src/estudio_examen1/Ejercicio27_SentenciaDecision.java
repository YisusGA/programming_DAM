package estudio_examen1;

/*
 * Pedir el día, mes y año de una fecha y mostrar el día siguiente. Tener en cuenta los días que tiene
 * cada mes y los días que tiene febrero si es año bisiesto o no. Si el día introducido es 31/12/xxxx,
 * tener en cuenta el cambio de año
 */

import java.util.Scanner;

public class Ejercicio27_SentenciaDecision {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce una fecha en el formato dd/mm/aaaa");
		String date = scan.nextLine();
		scan.close();
		int longitudeDate = date.length();
		if (!(longitudeDate == 10)) {
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
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			monthCheck = day <= 30;
			if (day == 30) {
				day = 1;
				++month;	
			} else {
				++day;
			}
		} else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			monthCheck = day <= 31;
			if (day == 31 && month == 12) {
				day = 1;
				month = 1;
				++year;
			} else if (day == 31) {
				day = 1;
				++month;	
			} else {
				++day;
			}
		} else {
			monthCheck = bisiesto ? day <= 29 : day <= 28;
			if (bisiesto && day == 29) {
				day = 1;
				++month;
			} else if (bisiesto) {	
				++day;
			} else if (day == 28){
				day = 1;
				++month;
			} else {
				++day;
			}
		}
		if (year < 0 || month < 1 || month > 12 || day < 1 || !monthCheck) {
			System.out.println("La fecha introducida no es válida");
		} else {
			System.out.println("La fecha introducida es válida y el día siguiente es: " + day + "/" + month + "/" + year);
		}
	}

}
