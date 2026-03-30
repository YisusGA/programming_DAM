package ejerciciosCortosFicheros01;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio04Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("¿Qué fichero quieres ordenar?");
		File inputFile = new File(scan.nextLine());
		try {
			if (Ejercicio04OrdenacionNumeros.ordenarFichero(inputFile)) {
				System.out.println("Fichero ordenado con éxito");
			} else {
				System.err.println("No se pudo ordenar el fichero");
			}
		} catch (IOException e) {
			System.err.println("Ocurrió un error durante la lectura de los ficheros");
			e.printStackTrace();
		}
		scan.close();
	}

}
