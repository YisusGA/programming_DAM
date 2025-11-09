package ejercicios_sentencia_iterativa;

/**
 * Diseñar un programa que muestre el producto de los 10 primeros números impares. Usa bucle for
 */

public class Ejercicio10_for {

	public static void main(String[] args) {
		int result = 1; //La variable donde vamos a ir almacenando el resultado de los sucesivos productos
		int i = 0; //Contador de números impares añadidos al producto
		//n es el número que se va a ir incrementando para ir dando lugar a los diferentes números por los que se va a multiplicar
		for (int n = 1; i < 10 ; n++) {
			if (n % 2 != 0) {
				result *= n;
				i++;
			}
		}
		System.out.println("El resultado del producto de los primeros 10 números impares es: " + result);
	}

}
