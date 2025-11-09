package ejercicios_sentencia_iterativa;

/**
 * Pedir 10 números. Mostrar la media de los números positivos, la media de los números negativos y la cantidad
 * de ceros
 */

import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		int n; //El número que el usuario va a ir introduciendo desde dentro del bucle
		int counter = 0; //Contador que sirve para llevar la cuenta de cuántos números ha introducido el usuario
		double sumaPositivos = 0; //La variable donde vamos a ir almacenando la suma de números positivos
		double sumaNegativos = 0; //La variable donde vamos a ir almacenando la suma de números negativos
		int cuentaCeros = 0; //Contador que sirve para llevar la cuenta de cuántos ceros ha introducido el usuario
		int cuentaPositivos = 0; //Contador que sirve para llevar la cuenta de cuántos números positivos ha introducido el usuario
		int cuentaNegativos = 0; //Contador que sirve para llevar la cuenta de cuántos números negativos ha introducido el usuario
		while (counter < 10) {
			System.out.println("Introduce un número");
			n = scan.nextInt();
			counter++;
			if (n > 0) {
				sumaPositivos += n;
				cuentaPositivos++;
			}
			if (n < 0) {
				sumaNegativos += n; 
				cuentaNegativos++;
			}
			if (n == 0) {
				cuentaCeros++;
			}
		}
		if (cuentaPositivos == 0) {
			System.out.println("Se han introducido 0 números positivos");
		} else {
			sumaPositivos = sumaPositivos / cuentaPositivos;
			System.out.println("La media de los números positivos introducidos es " + sumaPositivos);
		}
		if (cuentaNegativos == 0) {
			System.out.println("Se han introducido 0 números negativos");
		} else {
			sumaNegativos = sumaNegativos / cuentaNegativos;
			System.out.println("La media de los números negativos introducidos es " + sumaNegativos);
		}
		System.out.println("Se han introducido " + cuentaCeros + " cero");

	}

}
