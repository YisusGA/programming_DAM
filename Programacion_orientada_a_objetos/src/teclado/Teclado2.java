package teclado;

import java.util.Scanner;

/**
 * Con esta clase, hacemos métodos que nos van a permitir leer int, double y String por teclado sin el problema de que escaneemos una línea vacía al hacer
 * un scan.nextLine() tras haber hecho un scan.nextInt(). Como los métodos de la clase son static, los podemos llamar directamente con el nombre de la clase.Metodo, sin
 * necesidad de crear una instancia de la clase.
 */

public class Teclado2 {
	
	//Si yo pusiera aquí el Scanner de forma estática, siempre existiría el Scanner de forma estática, mientras que si lo llamo dentro de cada método,
	//se crea, hace su función y deja de existir.
	
	/**
	 * Este método me permite leer un número entero de un teclado
	 * @return El número entero que se ha leído
	 * CUIDADO: Si no se escribe una cadena de números válida, dará un error de excepción
	 */
	public static int leerEntero() {
		
		Scanner scan = new Scanner(System.in);
		return Integer.parseInt(scan.nextLine());
	}		
	
	public static double leerDecimal () { //Tiene que introducirse con punto, pues lo que hace es leer una cadena y convertirla a número double. Y java
                                          //necesita que el decimal esté puesto con punto
		Scanner scan = new Scanner(System.in);
		return Double.parseDouble(scan.nextLine());
	}
	
	public static String leerCadena() {
		
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}

}
