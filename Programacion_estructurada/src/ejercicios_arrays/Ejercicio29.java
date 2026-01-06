package ejercicios_arrays;

import java.util.Scanner;

public class Ejercicio29 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arraySize = 10;
		int[] arrayNumeros = new int[arraySize];
		int[] frecuencias = new int[arrayNumeros.length];
		
		for (int i = 0; i < arrayNumeros.length; i++) {
			System.out.println("Introduce un número entero");
			arrayNumeros[i] = scan.nextInt();
		}
		 System.out.print("El array introducido es: ");
		 for (int i : arrayNumeros) {
			 System.out.print(i + ", ");
		 }
		 
		 for (int i = 0, contadorArrayFrecuencias = 0; i < arrayNumeros.length; i++) {
			 int contador = 1;
			 for (int j = i + 1; j < arrayNumeros.length; j++) {
				 if (arrayNumeros[i] == arrayNumeros[j]) {
					 contador++;
				 }
			 }
			 
			 frecuencias[contadorArrayFrecuencias++] = contador;
			 
			 if (contador > 1) {
				 int contadorAux = 0;
//				 int numRepetido = arrayNumeros[i];
				 int[] aux = new int[arrayNumeros.length - contador];
				 aux[contadorAux++] = arrayNumeros[i];
				 for (int k = 0; k < arrayNumeros.length; k++) {
					 if (arrayNumeros[k] != arrayNumeros[i]) {
						 aux[contadorAux++] = arrayNumeros[k];
					 }
				 }
				 arrayNumeros = aux;
			 }
		 }
		scan.close();

	}

}
