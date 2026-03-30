package ejerciciosCortosFicheros01;

import java.io.File;
import java.io.IOException;

import teclado.TecladoOK;

public class Ejercicio02Main {

	public static void main(String[] args) {
		System.out.println("Fichero a censurar");
		File inputFile = new File(TecladoOK.leerCadena());
		System.out.println("Fichero de censura");
		File censuraFile = new File(TecladoOK.leerCadena());
		try {
			int numLineasCambiadas = Ejercicio02Censura.aplicaCensura(inputFile, censuraFile);
			if (numLineasCambiadas != -1) {
			System.out.println("Se modificaron " + numLineasCambiadas + " líneas");
			} else {
				System.err.println("Alguno de los ficheros no existe o el fichero de censura no tiene un formato de escritura válido. No se realizó ningún reemplazo");
			}
		} catch (IOException e) {
			System.err.println("Ocurrió un error inesperado durante el procesamiento del fichero");
			e.printStackTrace();
		}

	}

}
