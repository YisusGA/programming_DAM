package ejerciciosCortosFicheros02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio01DividirFichero {

	public static int dividirFichero(File inputFile, int bytes) throws IOException {
		int partes = 0;
		if (inputFile.exists() && inputFile.isFile() && bytes > 0) {
			String generalPath = inputFile.getAbsolutePath();
			try (FileInputStream fis = new FileInputStream(inputFile)) { // Si ponemos esto así, no hace falta cerrar el
																			// flujo, se cierra solo al terminar. Se
																			// suele hacer así en la programación
																			// moderna en java
				byte[] array = new byte[bytes];
				int i = 0;
				int bytesLeidos;
				while ((bytesLeidos = fis.read(array)) != -1) {
					File outputFile = new File(generalPath + ".part" + i);
					try (FileOutputStream fos = new FileOutputStream(outputFile)) {
						fos.write(array, 0, bytesLeidos);
					}
					i++;
					partes++;
				}
			}
		}
		return partes;
	}

}
