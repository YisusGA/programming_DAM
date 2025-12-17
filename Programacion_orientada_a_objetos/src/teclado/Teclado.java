package teclado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Con esta clase, hacemos métodos que nos van a permitir leer int, double y String por teclado sin el problema de que escaneemos una línea vacía al hacer
 * un scan.nextLine() tras haber hecho un scan.nextInt(). Como la clase es static, la podemos llamar directamente con el nombre de la clase.Metodo, sin
 * necesidad de hacer import.
 */

public class Teclado {
	public static int leerEntero() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			return Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public static double leerDecimal () { //Tiene que introducirse con punto, pues lo que hace es leer una cadena y convertirla a número double. Y java
                                          //necesita que el decimal esté puesto con punto
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			return Double.parseDouble(br.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static String leerCadena() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			return br.readLine();
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
