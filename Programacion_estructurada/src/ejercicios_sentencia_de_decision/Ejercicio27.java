package ejercicios_sentencia_de_decision;

/*
 * Pedir el día, mes y año de una fecha y mostrar el día siguiente. Tener en cuenta los días que tiene
 * cada mes y los días que tiene febrero si es año bisiesto o no. Si el día introducido es 31/12/xxxx,
 * tener en cuenta el cambio de año
 */

import java.util.Scanner;

public class Ejercicio27 {

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
				if (day < 30) {
					++day;
					System.out.println("La fecha del día siguiente es: " + day + "/" + month + "/" + year);
				} else if (day == 30) {	
					day = 1;
					++month;
					System.out.println("La fecha del día siguiente es: " + day + "/" + month + "/" + year);
				} else {
					System.out.println("La fecha introducida no es válida, el mes introducido debe tener 30 días");
				}
			} else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				if (day < 31) {
					++day;
					System.out.println("La fecha del día siguiente es: " + day + "/" + month + "/" + year);
				} else if (day == 31 && month == 12) {	
					day = 1;
					month = 1;
					++year;
					System.out.println("La fecha del día siguiente es: " + day + "/" + month + "/" + year);	
				} else if (day == 31) {	
					day = 1;
					++month;
					System.out.println("La fecha del día siguiente es: " + day + "/" + month + "/" + year);
				} else {
					System.out.println("La fecha introducida no es válida, el mes introducido debe tener 31 días");
				}
			} else {
				boolean bisiesto = (year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0);
				if (bisiesto == true) {
					if (day < 29) {
						++day;
						System.out.println("La fecha del día siguiente es: " + day + "/" + month + "/" + year);
					} else if (day == 29) {	
						day = 1;
						++month;
						System.out.println("La fecha del día siguiente es: " + day + "/" + month + "/" + year);
					} else {
						System.out.println("La fecha introducida no es válida, el mes introducido debe tener 29 días cuando el año es bisiesto");
					}
				} else {
					if (day < 28) {
						++day;
						System.out.println("La fecha del día siguiente es: " + day + "/" + month + "/" + year);
					} else if (day == 28) {	
						day = 1;
						++month;
						System.out.println("La fecha del día siguiente es: " + day + "/" + month + "/" + year);
					} else {
						System.out.println("La fecha introducida no es válida, el mes introducido debe tener 28 días cuando el año es bisiesto");
					}
				}
			}
		}

	}

}

