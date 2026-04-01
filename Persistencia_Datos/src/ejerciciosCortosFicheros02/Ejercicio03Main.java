package ejerciciosCortosFicheros02;

import java.io.File;

import teclado.TecladoOK;

public class Ejercicio03Main {

	public static void main(String[] args) {
		System.out.println("Introduce el directorio");
		File inputDirectory = new File(TecladoOK.leerCadena());
		Ejercicio03ArbolArchivos.arbolArchivos(inputDirectory, 3);
		System.out.println("Finalizando programa...");
	}

}
