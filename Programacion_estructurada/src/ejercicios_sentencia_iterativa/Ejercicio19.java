package ejercicios_sentencia_iterativa;

/*
 * Usando una sola variable, escribe un programa que imprima en pantalla los números de 1 a 10 y los números de 10 a 1 al lado
 */

public class Ejercicio19 {

	public static void main(String[] args) {
		System.out.println("Columna 1 " + "  Columna 2");
		System.out.println("---------   ---------");
		for (int n = 1; n <= 10; n++) {
			System.out.printf("%5d     |  %5d%n", n, (11 - n)); //Es super importante saber que se puede hacer una operación dentro del método print, porque nos permite mostrar el resultado de una expresión sin tener que declarar e inicializar una variable
		}

	}

}
