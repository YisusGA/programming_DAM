package ejerciciosCortosFicheros01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio04OrdenacionNumeros {

	public static List<Double> leeNumeros(File inputFile) throws IOException {
		List<Double> numeros = null;
		if (inputFile.exists()) {
			numeros = new ArrayList<>();
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			String line;
			while ((line = br.readLine()) != null) {
				try {
					numeros.add(Double.parseDouble(line));
				} catch (NumberFormatException e) {
					System.err.println("Número no válido, se omitió");
//					e.printStackTrace();
				}
			}
			br.close();
		}
		return numeros;
	}

	public static List<Double> ordenaNumeros(List<Double> numeros) {
		if (numeros != null) {
			numeros.sort(null);
		}
		return numeros;
	}

	public static boolean ordenarFichero(File inputFile) throws IOException {
		boolean ordenados = false;
		List<Double> numerosOrdenados = ordenaNumeros(leeNumeros(inputFile));
		if (inputFile.exists() && numerosOrdenados != null) {
			ordenados = true;
			String temp = "";
			FileWriter fw = new FileWriter(inputFile, false);
			for (Double d : numerosOrdenados) {
				temp = d + "\n";
				fw.write(temp);
			}
			fw.close();
		}
		return ordenados;
	}

}
