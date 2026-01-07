package ejercicios_arrays;

import java.util.Scanner;

//Transforma un array de forma que cada elemento pase a ser la suma de los elementos de su derecha. Ejemplo: [3, 2, 1] → [3+2+1, 2+1, 1] = [6, 3, 1].

public class Ejercicio32 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arraySize = 5;
		int[] array = new int[arraySize];
		
		for (int i = 0; i < array.length; i++) {
			System.out.println("Introduce un número entero");
			array[i] = scan.nextInt();
		}
		
		for (int i = 0; i < array.length; i++) {
			int suma = 0;
			for (int j = i; j < array.length; j++) {
				suma += array[j];
			}
			array[i] =  suma;
		}
		
		System.out.print("El array final es: ");
		for (int i : array) {
			System.out.print(i + ", ");
		}
		scan.close();
	}

}
