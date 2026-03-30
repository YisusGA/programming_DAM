package ejerciciosCortosFicheros01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio02Censura {
	
	public static int aplicaCensura(File inputFile, File censuraFile) throws IOException {
		int numLineasReemplazadas = -1;
		if (inputFile.exists() && censuraFile.exists()) {
			List<String> palabrasProhibidas = new ArrayList<>();
			List<String> palabrasSustitutas = new ArrayList<>();
			BufferedReader brCensura = new BufferedReader(new FileReader(censuraFile));
			boolean arraysValidos = true;
			String line1;
			while ((line1 = brCensura.readLine()) != null) {
				String[] array = line1.split(" ");
				if (!validarArray(array)) {
					arraysValidos = false;
				} else {
					palabrasProhibidas.add(array[0]);
					palabrasSustitutas.add(array[1]);
				}
			}
			brCensura.close();
			if (arraysValidos) {
				numLineasReemplazadas = 0;
				BufferedReader brInputFile = new BufferedReader(new FileReader(inputFile));
				File datos = new File("datos");
				if (!datos.exists()) {
					datos.mkdir();
				}
				File temp = new File("datos//temp");
				FileWriter fw = new FileWriter(temp, false);
				while ((line1 = brInputFile.readLine()) != null) {
					String line2 = line1;
					for (int i = 0; i < palabrasProhibidas.size(); i++) {
						line2 = line2.replaceAll(palabrasProhibidas.get(i), palabrasSustitutas.get(i));
					}
					if (!line1.equals(line2)) {
						numLineasReemplazadas++;
					}
					fw.write(line2 + "\n");
				}
				brInputFile.close();
				fw.close();
				inputFile.delete();
				temp.renameTo(inputFile);
			}
		}
		return numLineasReemplazadas;
	}
	
	public static boolean validarArray(String[] array) {
		boolean valido = true;
		if (array.length != 2) {
			valido = false;
		}
		return valido;
	}

}
