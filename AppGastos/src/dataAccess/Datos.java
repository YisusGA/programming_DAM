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

		// Esto genera un objeto file de la clase File, con la ruta pasada por
		// parámetro, pero no genera un fichero físico
		File file = new File("datos\\" + mes + ".csv"); // Hay que poner la doble barra, para indicarle que \ es un
														// caracter de ruta, y no otra cosa. Estamos usando ruta
														// relativa al proyecto aquí

		// Y aquí comprueba si ese objeto file, con esa ruta, tiene asociado un fichero
		// físico que existe
		if (!file.exists()) {
			FileWriter fw = new FileWriter(file); // Si no existe físicamente el fichero, FileWriter lo crea y le asigna
													// la ruta del objeto file

			fw.write(dia + ";" + gasto + "\n"); // Y lo rellena con datos
			fw.close();
		} else {
			// Si el objeto file se asocia a un fichero físico (existe ese fichero
			// físicamente, abrimos un BufferedReader para poder leerlo línea a línea
			BufferedReader br = new BufferedReader(new FileReader(file)); // Abro un nuevo BufferedReader a partir del
																			// fichero que ya existe
			// Y creamos un fichero físico temporal
			FileWriter fw = new FileWriter("datos\\temp");

			String linea;
			boolean existeDia = false;
			while ((linea = br.readLine()) != null) {
				if (linea.split(";")[0].equals(dia + "")) { // Split me va a dar un array con dos cosas, el dia y el
															// gasto. Me quedo con la posición 0, que es el día
					double nuevoGasto = Double.parseDouble(linea.split(";")[1]) + gasto;
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

			File temp = new File("datos\\temp"); // Se crea un objeto File llamado temp, y se asocia con el fichero
													// físico datos\\temp que creamos y rellenamos antes
			
			file.delete(); // Aquí se borra el fichero físico asociado al objeto file, pero el objeto file
							// sigue existiendo en memoria
			temp.renameTo(file); // Y se renombra el fichero datos\\temp con el nombre que está almacenado en el objeto file, que es "datos\\mes.csv"

		}
	}

	public static double gastosMes(String mes) throws IOException {
		double gastos = 0;
		File file = new File("datos\\" + mes + ".csv");
		if (file.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while((line = br.readLine()) != null) {
				gastos += Double.parseDouble(line.split(";")[1]);
			}
			br.close();
		}
		return gastos;
	}

	public static int diaMayorGasto(String mes) throws IOException {
		int dia = 0;
		File file = new File("datos\\" + mes + ".csv");
		if(file.exists()) {
			double mayorGasto = 0;
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while((line = br.readLine()) != null) {
				if(Double.parseDouble(line.split(";")[1]) > mayorGasto) {
					mayorGasto = Double.parseDouble(line.split(";")[1]); 
					dia = Integer.parseInt(line.split(";")[0]);
				}
			}
			br.close();
		}
		return dia;
	}

}
