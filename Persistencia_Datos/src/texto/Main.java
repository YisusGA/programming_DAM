package texto;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<String> nombres = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		try {
			leerNombres();
		} catch (IOException e) {
			System.err.println("No se ha podido leer el archivo");
			e.printStackTrace();
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("Introduce nombre: ");
			nombres.add(scan.nextLine());
		}

		// Procesamos los nombres o lo que sea que quiero hacer con ellos

		try {
			guardarNombres();
		} catch (IOException e) {
			System.err.println("No se pudo acceder al fichero");
			e.printStackTrace();
		}
		scan.close();
	}

	private static void guardarNombres() throws IOException {
		Scanner scan = new Scanner(System.in);
		// 1. Abrimos el fichero para escritura

		// FileOutputStream: escribe bytes
		// FileWriter: escribe caracteres

		System.out.println("¿En qué fichero quieres guardar?");
		String nomFich = scan.nextLine();

		// Le pasamos al constructor como parámetro el fichero en el que vamos a
		// escribir. Si no ponemos ninguna ruta, guarda el fichero en la carpeta
		// del proyecto donde se encuentra esta clase. Es muy desaconsejable usar rutas
		// absolutas, pues dejarán de funcionar cuando mueva la aplicación de sitio. Hay
		// que usar rutas relativas al proyecto
		// FileWriter puede lanzar una IOException, que hereda de Exception y no de
		// RuntimeException. O sea que tenemos que gestionarla en tiempo de escritura de
		// código. Podemos capturarla o propagarla. La mejor opción en este caso es
		// capturarla, pero vamos a hacer un throws
		// El segundo parámetro del constructor indica si quiero añadir o borrar. True
		// lo que hace es añadir el nuevo contenido al que ya tuviera el fichero, y
		// false borra el contenido previo del fichero y añade el nuevo. Si no pongo
		// nada, por defecto es false
		FileWriter fw = new FileWriter(nomFich, true);

		// 2. Escribimos

		for (String n : nombres) {
			fw.write(n + "\n"); // La "\n" para meter salto de línea entre cada String
		}

		// 3. Cerramos

		fw.close(); // Cerramos el flujo, muy importante
		scan.close();
		System.out.println("Programa finalizado");
	}

	private static void leerNombres() throws IOException { // El compilador elimina la FileNotFoundException de read al
															// lanzar la IOException, pues FileNotFoundException hereda
															// de IOException. Podríamos poner las 2, pero es
															// redundante. Si quisiéramos poner las 2, se pondrían
															// separadas por coma
		Scanner scan = new Scanner(System.in);

		System.out.println("¿De qué fichero quieres leer los datos?");
		String nomFich = scan.nextLine();

		// Gestionamos la posibilidad de que el fichero introducido no exista. Si no
		// existe, hacemos un return vacío y terminamos el método
		File file = new File(nomFich);
		if (!file.exists()) {
			System.err.println("El fichero no existe");
			return;
		}

		// 1. Abrir fichero para leer caracteres

		// Puede lanzar una FileNotFoundException. Como sabemos que nunca va a lanzarla
		// porque ya lo hemos gestionado arriba, nos es más cómo hacer un throws que un
		// try-catch
		FileReader fr = new FileReader(file);

		// 2. Hacer lecturas

		String s = "";

		int c;
		while ((c = fr.read()) != -1) { // el método read() devuelve un -1 cuando alcanza el final del fichero
			// Hacemos con c lo que queramos
			s += (char)c;
		}

		for(String n : s.split("\n")) {
			nombres.add(n);
		}

		// 3. Cerrar fichero
		fr.close();
	}

}
