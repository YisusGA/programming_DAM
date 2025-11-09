package estudio_examen1;


/**
 * Dime tu nota del examen y nota del examen recuperación (-1 si no te presentaste a alguno de los exámenes). 
 * Estás aprobado si aprobaste el primer examen o si la media de tu primer examen y recuperación es mayor o igual a 5. 
 * Si tenías que recuperar y no lo hiciste, te aviso.
 */

import java.util.Scanner;

public class NotaExamen_EjercicioClase2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce la nota de tu primer examen. Introduce -1 si no te presentaste");
		double notaEx = scan.nextDouble();
		System.out.println("Introduce la nota del examen de recuperación. Introduce -1 si no te presentaste");
		double notaRec = scan.nextDouble();
		scan.close();
		String aprobado;
		double notaFinal = (notaEx + notaRec) / 2; 
		if (notaEx >= 5) {
			System.out.println("Estás aprobado. Tu nota final es: " + notaEx);
		} else if (notaEx == -1 && notaRec == -1) {
			System.out.println("No te has presentado a ningún examen, ya te vale...");
		} else if (notaRec == -1) {
			System.out.println("Estás suspenso, y no te presentaste a la recuperación. Tu nota final es: " + notaEx);
		} else {
			aprobado = notaFinal >= 5 ? "Estás aprobado, tu nota final es: " + notaFinal : "Estas suspenso, tu nota final es : " + notaFinal;
			System.out.println(aprobado);
		}

	}

}
