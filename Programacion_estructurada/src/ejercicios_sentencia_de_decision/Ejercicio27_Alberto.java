package ejercicios_sentencia_de_decision;

import java.util.Scanner;

/*
 * Pedir el día, mes y año de una fecha correcta y mostrar la fecha del día siguiente. 
 * Suponer que todos los meses tienen 30 días.
 */

public class Ejercicio27_Alberto {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Introduce el día: ");
		int dia = scan.nextInt();
		
		System.out.print("Introduce el mes: ");
		int mes = scan.nextInt();
		
		System.out.print("Introduce el año: ");
		int anyo = scan.nextInt();
		
		scan.close();
		
		
		// Check if the date is valid
		boolean esCorrecta = true;
		
		if (dia < 1 || dia > 30) esCorrecta = false;
		if (mes < 1 || mes > 12) esCorrecta = false;
		if (anyo < 0) esCorrecta = false;
		
		if (!esCorrecta) {System.err.print("Error: Fecha no válida"); return;}
		
		// New year's eve
		if (dia == 30 && mes == 12) {
			dia = 1;
			mes = 1;
			anyo++;
			
		// Next month
		} else if (dia == 30) {
			dia = 1;
			mes++;
			
		// Next day
		} else {
			dia++;
		}
		
		
		// Print
		System.out.printf("%nEl día SIGUIENTE sería el %02d-%02d-%d", dia, mes, anyo);
	}
}
