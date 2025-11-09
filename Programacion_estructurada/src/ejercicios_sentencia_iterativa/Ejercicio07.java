package ejercicios_sentencia_iterativa;

/**
 * Programa que sume el número 5 y sus múltiplos desde el 1 hasta el 100 y muestre el resultado por pantalla
 */

public class Ejercicio07 {

	public static void main(String[] args) {
		int n = 5; //El número en el que vamos a ir almacenando la suma. Su valor inicial ha de ser 5 o 0
		int multiplos = 5; //Aquí vamos a ir almacenando los múltiplos de 5, comenzando por el 5
		while (multiplos < 100) {
			multiplos += 5;
			n += multiplos;
		}
		System.out.println("El resultado final es: " + n);

	}

}
