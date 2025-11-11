package ejercicios_sentencia_iterativa;

/**
 * Programa que, dado un número entero, muestre en líneas consecutivas cada una de sus cifras
 */

import java.util.Scanner;

public class Ejercicio20_array {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero");
		int n = scan.nextInt();
		int nSLength = ("" + n).length(); //Se concatena un número con una string vacía y se saca la longitud, que es un int
		int pos = 0; //Donde vamos a ir almacenando la posición dentro del número, comenzando por 0, la primera posición de un array
		int [] numeros; //Es necesario declarar la variable array fuera del bucle, para poder usarla fuera
		numeros = new int [nSLength]; //Generamos la instancia de la variable array
		while (n > 0) { //Cuando n /= 10 sea 0, ya no quedan más cifras que sacar del número, y ya no se entra en el bucle
			numeros [pos] = n % 10; //Se saca la última cifra del número
			n /= 10; //Se elimina la última cifra del número
			pos++; //Se incrementa el número de posición
		}
		//Comenzamos mostrando la última posición, que es nSLength - 1, y que coincide con la primera cifra (más a la izquierda) del 
		//número, pues es la última que se almacenó. Si no restáramos 1 a nSLength, nos daría error outOfBounds del array.
		for (int i = nSLength - 1; i >= 0; i--) {
			System.out.println(numeros [i]);
		}
	}

}
