package es.dam1.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GestionPaises {
	private static Map<String, Long> paises;

	// Esta es la forma en la que yo he hecho la lógica, rellenando el Map con los
	// datos del fichero a través del constructor de la clase
	public GestionPaises() {
		paises = new TreeMap<>();
		File file = new File("src/main/resources/datosPaises.dat");
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				String[] splitLine = line.split(";");
				paises.put(splitLine[0], Long.parseLong((splitLine)[1]));
			}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error en la operación de recuperación del fichero");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.err.println("Formato de número no válido, se ignoró la entrada");
			e.printStackTrace();
		}
	}

	public Map<String, Long> getPaises() {
		return paises;
	}

	public void setPaises(Map<String, Long> input) {
		paises = input;
	}

	// Este es el método que hizo la profe, en lugar de lo que yo hice a través del
	// constructor
	public static void cargaDatos() throws IOException {

		Path path = Paths.get("src/main/resources/datosPaises.txt");
		List<String> lineas = Files.readAllLines(path);

		for (String linea : lineas) {
			String[] campos = linea.split(";");
			try {
				paises.put(campos[0], Long.parseLong(campos[1]));
			} catch (NumberFormatException e) {
				System.err.println("Formato de número no válido, ignorando dato");
				e.printStackTrace();
			}
		}

	}

}
