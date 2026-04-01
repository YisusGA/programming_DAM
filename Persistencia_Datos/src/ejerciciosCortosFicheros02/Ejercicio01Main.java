package ejerciciosCortosFicheros02;

import java.io.File;
import java.io.IOException;

import teclado.TecladoOK;

public class Ejercicio01Main {

	public static void main(String[] args) {
		System.out.println("¿Qué fichero quieres dividir?");
		File inputFile = new File(TecladoOK.leerCadena());
		System.out.println("Introduce un número entero para determinar el tamaño en bytes de cada parte. Debe ser diferente de 0");
		int chunkSize = TecladoOK.leerEntero();
		int partes = 0;
		try {
			if ((partes = Ejercicio01DividirFichero.dividirFichero(inputFile, chunkSize)) != 0) {
				System.out.println("Fichero dividido con éxito en " + partes + " partes");
			} else {
				System.err.println("El fichero no existe, la dirección introducida no se corresponde a un fichero, el fichero tiene tamaño 0 o el tamaño en bytes introducido para cada parte fue 0");
			}
		} catch (IOException e) {
			System.err.println("Error en la operación");
			e.printStackTrace();
		}
	}

}
