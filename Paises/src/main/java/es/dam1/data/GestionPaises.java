package es.dam1.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class GestionPaises {
	private Map<String, Long> paises;

	public GestionPaises() {
		paises = new TreeMap<>();
		File file = new File("src/main/resouces/datosPaises.dat");
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

	public void setPaises(Map<String, Long> paises) {
		this.paises = paises;
	}

}
