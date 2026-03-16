package dataAccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Datos {

	public static void addGasto(String mes, int dia, double gasto) throws IOException { // Lanzamos la excepción para
																						// que se decida en la clase con
																						// el main qué hacer si aparece

		File file = new File("datos\\" + mes); // Hay que poner la doble barra. Estamos usando ruta relativa al proyecto
												// aquí
		if (!file.exists()) {
			FileWriter fw = new FileWriter(file);
			fw.write(dia + ";" + gasto + "\n");
			fw.close();
		} else {
			BufferedReader br = new BufferedReader(new FileReader(file)); // Abro un nuevo BufferedReader a partir del
																			// fichero que ya existe
			FileWriter fw = new FileWriter("datos\\temp");

			String linea;
			boolean existeDia = false;
			while ((linea = br.readLine()) != null) {
				if (linea.split(";")[0].equals(dia + "")) { // Split me va a dar un array con dos cosas, el dia y el
															// gasto. Me quedo con la posición 0, que es el día
					double nuevoGasto = Double.parseDouble(linea.split(";")[1] + gasto);
					fw.write(dia + ";" + nuevoGasto + "\n");
					existeDia = true;
				} else {
					fw.write(linea + "\n");
				}
			}

			if (!existeDia) {
				fw.write(dia + ";" + gasto + "\n");
			}

			// IMPORTANTE: hay que cerrar los flujos antes de borrar el fichero y renombrar,
			// o no funcionará
			br.close();
			fw.close();

			File temp = new File("datos\\temp");
			file.delete(); // Aquí se borra el fichero físico asociado al objeto file, pero el objeto file
							// sigue existiendo en memoria
			temp.renameTo(file);

		}
	}
	
	public static double gastosMes(String mes) {
		return 0;
	}
	
	public static int diaMayorGasto(String mes) {
		return 0;
	}

}
