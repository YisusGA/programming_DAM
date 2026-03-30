package ejerciciosCortosFicheros01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio01CuentaPalabras {
	
	/**
	 * Método para contar el número de palabras que contiene un fichero. El carácter de separación entre palabras es un espacio " "
	 * @param inputFile el archivo de entrada. Funciona con rutas absolutas y relativas
	 * @return el número de palabras contadas, o -1 si el archivo no existe
	 * @throws IOException
	 */
	public static int cuentaPalabras(File inputFile) throws IOException {
		int numPalabras = -1;
		if (inputFile.exists()) {
			numPalabras = 0;
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			String line;
			while ((line = br.readLine()) != null) {
				String[] palabras = line.split(" ");
				numPalabras += palabras.length;
			}
			br.close();
		}
		return numPalabras;
	}

}
