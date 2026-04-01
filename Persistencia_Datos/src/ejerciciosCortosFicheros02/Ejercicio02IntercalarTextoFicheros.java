package ejerciciosCortosFicheros02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio02IntercalarTextoFicheros {

	public static int intercalarLineas(File inputFile01, File inputFile02) throws IOException {
		int lineas = 0;
		if (inputFile01.exists() && inputFile02.exists() && inputFile01.isFile() && inputFile02.isFile()) {
			BufferedReader br01 = new BufferedReader(new FileReader(inputFile01));
			BufferedReader br02 = new BufferedReader(new FileReader(inputFile02));
			File datos = new File("datos");
			if (!datos.exists()) {
				datos.mkdir();
			}
			FileWriter fw = new FileWriter(new File("datos//combined.txt"), false);
			String line01 = "";
			String line02 = "";
			while ((line01 = br01.readLine()) != null && (line02 = br02.readLine()) != null) {
				fw.write(line01 + "\n");
				fw.write(line02 + "\n");
				lineas += 2;
			}
			while ((line01 = br01.readLine()) != null) {
				fw.write(line01 + "\n");
				lineas++;
			}
			while ((line02 = br02.readLine()) != null) {
				fw.write(line02 + "\n");
				lineas++;
			}
			br01.close();
			br02.close();
			fw.close();
		}
		return lineas;
	}

}
