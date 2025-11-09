package ejercicios_sentencia_iterativa;

/**
 * Programa para calcular y mostrar todos los números perfectos hasta el límite de limit == Long.MAX_VALUE. Este variable limit se usará de la siguiente forma:
 *  para que un número sea perfecto, se tiene que cumplir que (2^n) - 1 sea un número primo. Si esto se cumple, entonces calculamos el número perfecto con la siguiente 
 *  fórmula:  numPerfecto = (2^(n - 1)) *  ((2^n) - 1). Lo que vamos a hacer es ir incrementando el valor de esa n desd 1 hasta el limit.
 */

public class Ejercicio22_numPerfectos {

	public static void main(String[] args) {
		long limit = Integer.MAX_VALUE;
		boolean primo = false;
		/*
		 * La variable n va a ser el número que vamos a ir incrementando desde 1 y usando para calcular si es primo el segundo factor (la variable que he llamado
		 * operacionPrimo) de la fórmula que se usa para calcular un número perfecto. Y será el que usemos para sustituir n en la propia fórmula, claro.
		 * divisor es una variable que usaremos partiendo del valor 1 hasta el valor de operacionPrimo. Iremos dividiendo operacionPrimo por los diferentes valores
		 * de divisor. divisorCount será la variable para ir almacenando el número de divisores que tiene operacionPrimo (que la división tenga resto == 0). Nótese que
		 * cuando terminamos el bucle for parental al completo, debemos resetear el valor de divisorCount a 0, pues si no, irá incrementando su valor por cada iteración
		 * del bucle parental. operacionPrimo sólo será primo si divisorCount == 2. Esta es la definición de número primo: si lo dividimos por todos los números menores
		 * o iguales a él mismo, sólo debe tener 2 divisores: el 1 y él mismo. Por tanto, si divisorCount == 2, primo = true y calculamos el número perfecto usando la
		 * fórmula y lo mostramos por consola. Debemos incluir el else aquí para hacer que primo = false, pues si no lo hiciéramos, en cuanto aparezca un número perfecto 
		 * (el 6, que es el primero), la variable boolean primo ya tendría el valor true para todas las futuras iteraciones del bucle.
		 */
		for (int n = 1; n < limit; n++) {
			double operacionPrimo = (Math.pow(2, n) - 1);
			int divisorCount = 0;
			for (int divisor = 1; divisor <= operacionPrimo; divisor++) {	
				if (operacionPrimo % divisor == 0) {
					divisorCount++;
				}
			}
			if (divisorCount == 2) {
				primo = true;				
			} else {
				primo = false;
			}
			if (primo) {
				double numPerfecto = (Math.pow(2, (n -1)) * (Math.pow(2, n) - 1));
				System.out.println("Número perfecto encontrado: " + numPerfecto);
			}
		}

	}

}
