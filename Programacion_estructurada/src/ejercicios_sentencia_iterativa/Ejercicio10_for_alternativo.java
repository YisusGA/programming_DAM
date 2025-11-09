package ejercicios_sentencia_iterativa;

/**
 * Diseñar un programa que muestre el producto de los 10 primeros números impares. Usa bucle for
 */

public class Ejercicio10_for_alternativo {

	public static void main(String[] args) {
		int result = 1; //La variable donde vamos a ir almacenando el resultado de los sucesivos productos
		int i = 0; //Contador de números impares añadidos al producto
		/*
		 * n es el número que se va a ir incrementando para ir dando lugar a los diferentes números por los que se va a multiplicar.
		 * En este caso en específico, sólo sale el resultado esperado si se inicializa la variable n como 0, pues el primer resultado debe ser 1, que se corresponde con el contador i == 1. 
		 * Si inicializamos n con el valor de 1, la primera iteración del bucle (i == 1), ya da como resultado 3. Y por tanto, el resultado multiplicará 10 números impares sin contar el 1.  
		 */
		for (int n = 0; i < 10 ; n++) {
				result *= 2 * n + 1;
				i++;
			}
		System.out.println("El resultado del producto de los primeros 10 números impares es: " + result);
	}

}
