package ejercicios_arrays;

/**
 * Queremos desarrollar una aplicación que nos ayude a gestionar las notas de un centro educativo. Cada grupo ( o clase) está compuesto por 5 alumnos. 
 * Se pide leer las notas del primer, segundo y tercer trimestre de un grupo. Debemos mostrar al final: la nota media del grupo en cada trimestre, y la 
 * media del alumno que se encuentra en la posición N (N se lee por teclado)
 */


import java.util.Scanner;

public class Ejercicio22 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int nNotas = 15; //Número total de notas: 5 alumnos * 3 trimestres
		double[] notas = new double[nNotas];
		int i = 0;
		while (i < 5) {
			double n;
			System.out.println("Introduce las 5 notas de los alumnos en el primer trimestre");
			while ((n = scan.nextDouble()) < 0 || n > 10) {
				System.err.println("La nota debe estar comprendida entre 0 y 10");
				System.out.println("Prueba de nuevo");
			}
			notas[i] = n;
			i++;
		}
		while (i < 10) {
			double n;
			System.out.println("Introduce las 5 notas de los alumnos en el segundo trimestre");
			while ((n = scan.nextDouble()) < 0 || n > 10) {
				System.err.println("La nota debe estar comprendida entre 0 y 10");
				System.out.println("Prueba de nuevo");
			}
			notas[i++] = n;
		}
		while (i < 15) {
			double n;
			System.out.println("Introduce las 5 notas de los alumnos en el tercer trimestre");
			while ((n = scan.nextDouble()) < 0 || n > 10) {
				System.err.println("La nota debe estar comprendida entre 0 y 10");
				System.out.println("Prueba de nuevo");
			}
			notas[i++] = n;
		}
		System.out.println("Notas introducidas en formato a1t1, a2t1, a3t1, a4t1, a5t1, a1t2, etc.: ");
		for (double j : notas) {
			System.out.print(j + ", ");
		}
		
		System.out.println();
		System.out.println("-----------------------------------------------------------------------");
		double sumaGrupoT1 = 0;
		double sumaGrupoT2 = 0;
		double sumaGrupoT3 = 0;
		for (int j = 0; j < 15; j++) {
			if (j < 5) {
				sumaGrupoT1 += notas[j];
			} else if (j < 10) {
				sumaGrupoT2 += notas[j];
			} else {
				sumaGrupoT3 += notas[j];
			}
		}
		System.out.println("Introduce la posición del alumno. Valores admitidos del 0 al 4");
		int alumno = scan.nextInt();
		while(alumno > 4) {
			System.err.println("Valor no admitido, prueba de nuevo");
			alumno = scan.nextInt();
		}
		double sumaNotasAlumno = 0;
		for (int j = alumno, k = 0; k < 2; k++) {
			sumaNotasAlumno += notas[j];
			j += 5;
		}
		System.out.printf("La media de notas del grupo en el trimestre 1 es: %.2f %n", (sumaGrupoT1 / 5.0));
		System.out.printf("La media de notas del grupo en el trimestre 2 es: %.2f %n",  (sumaGrupoT2 / 5.0));
		System.out.printf("La media de notas del grupo en el trimestre 3 es: %.2f %n", (sumaGrupoT3 / 5));
		System.out.printf("La media de notas del alumno solicitado a lo largo del curso es: %.2f %n", sumaNotasAlumno / 3.0);
		scan.close();
	}

}
