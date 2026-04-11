package texto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static List<String> nombres = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		try {
			leerNombres();
			System.out.println();
			System.out.println("Lectura de datos correcta");
			System.out.println();
		} catch (IOException e) {
			System.err.println("No se ha podido leer el archivo");
			e.printStackTrace();
		}

		System.out.println("Nueva lectura de datos");
		System.out.println();
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
		System.out.println("Programa finalizado");
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
		// que usar rutas relativas al proyecto.
		// FileWriter puede lanzar una IOException, que hereda de Exception y no de
		// RuntimeException. O sea que tenemos que gestionarla en tiempo de escritura de
		// código. Podemos capturarla o propagarla.
		// El segundo parámetro del constructor indica si quiero añadir o borrar. True
		// lo que hace es añadir el nuevo contenido al que ya tuviera el fichero, y
		// false borra el contenido previo del fichero y añade el nuevo. Si no pongo
		// nada, por defecto es false. Si el fichero no existe, directamente lo crea y
		// escribe en él, dando igual si el segundo parámetro es true o false
		FileWriter fw = new FileWriter(nomFich, true);

		// 2. Escribimos

		for (String n : nombres) {
			fw.write(n + "\n"); // La "\n" es el caracter para meter salto de línea entre cada String, y se
								// convertiría en este caso en el separador entre cada una de las String
		}

		// 3. Cerramos

		fw.close(); // Cerramos el flujo, muy importante
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
		File file = new File(nomFich); // Esto crea un objeto de la clase File, no un fichero físico
		if (!file.exists()) { // Y tiene un método que comprueba si en la ruta que se pasó por parámetros al
								// crear el objeto file (que en este caso, al ser simplemente un String con el
								// nombre, es la ruta raíz del proyecto) existe un fichero físico con esa misma
								// ruta y nombre
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

		int c; // Declaramos una variable de tipo int, pues el método read() de FileReader lee
				// caracter a caracter y devuelve el int que se corresponde a cada caracter
		while ((c = fr.read()) != -1) { // el método read() lee caracter a caracter y devuelve el int que se corresponde
										// al caracter. Y devuelve un -1 cuando alcanza el final del fichero
			// Hacemos con c lo que queramos
			s += (char) c; // Si queremos que el caracter, que se ha leído y almacenado como int, se
							// almacene como caracter ASCII, tenemos que hacer el casting a char antes de
							// concatenarlo con el String
		}

		// Lo que sale de aquí es una mega String cuyo separador entre nombres es \n.
		// Por ejemplo, "Adrian\nYisus\nIsma". Por lo tanto, no podemos hacer
		// simplemente un nombres.add(s) para añadirlo al ArrayList, sino que tenemos
		// que hacer un split por el caracter separador, \n. Si tuviéramos otro caracter
		// separador, como una coma o punto y coma, pondríamos eso como parámetro del
		// split

		for (String n : s.split("\n")) {
			nombres.add(n);
		}

		// 3. Cerrar fichero
		fr.close();
	}

	private static void leerNombresv2() throws IOException {
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

//		 FileReader fr = new FileReader(file); // Se puede instanciar directamente en el BufferedReader
		BufferedReader buffer = new BufferedReader(new FileReader(file));

		String linea;

		while ((linea = buffer.readLine()) != null) { // Cada vez que llamamos al método readLine(), lee una línea
														// completa, entendiendo por línea completa una sucesión de
														// caracteres (espacios incluidos) hasta que se encuentre un
														// caracter de salto de línea (\n). Devuelve un null cuando se
														// alcanza el final del fichero y ya no hay más líneas que leer
			// Hacer lo que sea con la línea
			nombres.add(linea);
		}
		// 3. Cerrar recursos
		buffer.close();
//		fr.close();
	}

}
