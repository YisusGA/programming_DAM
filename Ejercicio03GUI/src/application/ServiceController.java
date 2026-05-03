package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ServiceController {
	private static File fichero;

	public static String cargarDesdeFichero(String ruta) {
		String texto = null;
		fichero = new File(ruta);
		texto = "";
		String linea = "";
		try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
			while ((linea = br.readLine()) != null) {
				texto += linea;
			}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
			texto = null;
			e.printStackTrace();
		} catch (IOException e1) {
			System.err.println("Error de lectura");
			texto = null;
			e1.printStackTrace();
		}

		return texto;
	}

	public static String guardarEnFichero(String ruta, String input) {
		String output = null;
		boolean escrito = false;
		boolean existia = false;
		fichero = new File(ruta);
		if (fichero.exists()) {
			existia = true;
		}
		try (FileWriter fw = new FileWriter(fichero)) {
			fw.write(input);
			escrito = true;
		} catch (IOException e) {
			System.err.println("Error de escritura");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (escrito && existia) {
			output = "Fichero existente sobreescrito con el nuevo contenido";
		} else if (escrito && !existia) {
			output = "Contenido guardado con éxito en el fichero";
		}
		return output;
	}

}
