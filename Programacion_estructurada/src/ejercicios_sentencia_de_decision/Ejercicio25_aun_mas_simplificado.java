package ejercicios_sentencia_de_decision;

import java.util.Scanner;

public class Ejercicio25_aun_mas_simplificado {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un año");
		int year = scan.nextInt();
		System.out.println("Introduce un número de mes");
		int month = scan.nextInt();
		System.out.println("Introduce el día del mes");
		int day = scan.nextInt();
		scan.close();
		boolean monthCheck = true;
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			monthCheck = day <= 30;
		} else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			monthCheck = day <= 31;
		} else {
			boolean bisiesto = (year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0);
			if (bisiesto == true) {
				monthCheck = day <= 29;
			} else {
				monthCheck = day <= 28;
			}
		}
		//Aquí recogemos todos los casos en los que la fecha no es válida, e imprimimos eso mismo
		if (year < 0 || month < 1 || month > 12 || day < 1 || day > 31 || !monthCheck) {
			System.out.print("La fecha introducida no es válida");
		//La alternativa obviamente es que la fecha sea válida, y es lo que imprimimos	
		} else {
			System.out.println("La fecha introducida es válida");
		}
	}

}
