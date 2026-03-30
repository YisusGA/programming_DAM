package ejerciciosCortosFicheros01;

import java.io.File;
import java.io.IOException;

import teclado.TecladoOK;

public class Ejercicio01Main {

	public static void main(String[] args) {
		System.out.println("¿De qué fichero quieres contar las palabras?");
		String pathToFile = TecladoOK.leerCadena();
		File inputFile = new File(pathToFile);
		int numPalabras = -1;
		try {
			numPalabras = Ejercicio01CuentaPalabras.cuentaPalabras(inputFile);
		} catch (IOException e) {
			System.err.println("Error en el acceso al fichero");
			e.printStackTrace();
		}
		if (numPalabras != -1) {
			System.out.println("El número de palabras es: " + numPalabras);
		} else {
			System.err.println("No se pudo leer el número de palabras");
		}
	}

}
