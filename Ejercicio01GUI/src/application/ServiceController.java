package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ServiceController {
	private static File folder = new File("data");
	private static File fichero = new File("data/formData.csv");
	
	public static void guardarDatos(String nombre, String apellidos, String provincia, String genero) {
		if (!folder.exists()) {
			folder.mkdir();
		}
		if (fichero.exists()) {
			try (FileWriter fw = new FileWriter(fichero, true)) {
				String textoEscribir = String.format("%s;%s;%s;%s\n", nombre, apellidos, provincia, genero);
				fw.write(textoEscribir);
			} catch (IOException e) {
				System.err.println("Error de escritura");
				e.printStackTrace();
			}
		} else {
			try (FileWriter fw = new FileWriter(fichero)) {
				String textoEscribir = String.format("Nombre;Apellidos;Provincia;Género;\n%s;%s;%s;%s\n", nombre, apellidos, provincia, genero);
				fw.write(textoEscribir);
			} catch (IOException e) {
				System.err.println("Error de escritura");
				e.printStackTrace();
			}
		}
	}

}
