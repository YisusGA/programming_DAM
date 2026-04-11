package ejerciciosCortosFicheros02;

import java.io.File;

public class Ejercicio03ArbolArchivos {

	public static void arbolArchivos(File directorio, int nivel) { // nivel sólo tiene la función de introducir
																	// tabulación para representar visualmente los
																	// distintos niveles jerárquicos
		if (!directorio.isDirectory()) {
			System.err.println("El fichero pasado no es un directorio");
			return;
		}
		File[] contenido = directorio.listFiles();
		if (contenido != null) {
			for (File archivo : contenido) {
				for (int i = 0; i < nivel; i++) {
					System.out.print("   ");
				}
				if (archivo.isDirectory()) {
					System.out.println("[Directorio] " + archivo.getName());
					arbolArchivos(archivo, nivel + 1);
				} else {
					System.out.println("[Archivo] " + archivo.getName());
				}
			}
		}
	}

}
