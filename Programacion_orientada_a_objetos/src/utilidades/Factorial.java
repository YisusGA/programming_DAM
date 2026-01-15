package utilidades;

public class Factorial {
	
	/**
	 * Método recursivo para calcular el factorial de un número int 
	 * Se detiene cuando el número alcanza el valor de 1
	 * Hay que incluir en el método main donde se use un control del
	 * parámetro num de entrada para que siempre sea mayor o igual a 0.
	 * Hay que incluir en el método main donde se use un control del
	 * número que sale, pues si es mayor que Long.MAX_VALUE, devolverá
	 * un 0 o un número negativo, al desbordar la capacidad de un dato long
	 * @param Número int
	 * @return Resultado de aplicar el cálculo factorial sobre dicho número
	 */
	public static long factorial (int num) {
		if (num <= 1) {
			return 1;
		} else {
			return num * factorial(num - 1);
		}
	}

}
