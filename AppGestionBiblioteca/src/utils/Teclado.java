package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Teclado {
	
	public static int leerEntero() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 0;
		boolean lecturaValida = false;
		while (!lecturaValida) {
			try {
				result = Integer.parseInt(br.readLine());
				lecturaValida = true;
			} catch (NumberFormatException | IOException e) {
				System.err.println("Entrada no válida, prueba de nuevo");
				//e.printStackTrace();
			}
		}
		return result;
	}
	
	public static double leerDouble() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double result = 0;
		boolean lecturaValida = false;
		while (!lecturaValida) {
			try {
				result = Double.parseDouble(br.readLine());
				lecturaValida = true;
			} catch (NumberFormatException | IOException e) {
				System.err.println("Entrada no válida, prueba de nuevo");
				//e.printStackTrace();
			}
		}
		return result;
	}
	
	public static String leerCadena() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String result = null;
		boolean lecturaValida = false;
		while (!lecturaValida) {
			try {
				result = br.readLine();
				lecturaValida = true;
			} catch (IOException e) {
				System.err.println("Entrada no válida, prueba de nuevo");
				//e.printStackTrace();
			}
		}
		return result;
	}

}
