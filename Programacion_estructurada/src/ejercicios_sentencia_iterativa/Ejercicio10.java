package ejercicios_sentencia_iterativa;

/**
 * Diseñar un programa que muestre el producto de los 10 primeros números impares
 */

public class Ejercicio10 {

	public static void main(String[] args) {
		int n = 1; //El número que se va a ir incrementando para ir dando lugar a los diferentes números por los que se va a multiplicar
		int result = 1; //La variable donde vamos a ir almacenando el resultado de los sucesivos productos
		int i = 0; //Contador de números impares añadidos al producto
		while (i < 10) {
			if (n % 2 != 0) {
				result *= n;
				i++;
			}
			n++;
		}
		System.out.println("El resultado del producto de los primeros 10 números impares es: " + result);
	}

}
