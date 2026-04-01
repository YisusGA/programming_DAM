package ejerciciosCortosFicheros02;

import java.io.File;
import java.io.IOException;

import teclado.TecladoOK;

public class Ejercicio02Main {

	public static void main(String[] args) {
		System.out.println("Introduce la ruta del primer fichero");
		File inputFile01 = new File(TecladoOK.leerCadena());
		System.out.println("Introduce la ruta del segundo fichero");
		File inputFile02 = new File(TecladoOK.leerCadena());
		
		int lineas = 0;
		try {
			if ((lineas = (Ejercicio02IntercalarTextoFicheros.intercalarLineas(inputFile01, inputFile02))) != 0) {
				System.out.println("Se leyeron y escribieron " + lineas + " líneas");
				File outputPath = new File("datos//combined.txt");
				System.out.println("Puedes encontrar tu fichero en: " + outputPath.getAbsolutePath());
			} else {
				System.err.println("Error. Los ficheros no existen o alguno de los 2 no tiene texto o su contenido es vacío");
			}
		} catch (IOException e) {
			System.err.println("Error inesperado en la operación");
			e.printStackTrace();
		}
	}

}
