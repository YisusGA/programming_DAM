package objetos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static Set<Alumno> alumnos = new HashSet<>();
	public static String fichero = "datos\\alumnos.dat";

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// Lo primero que debería hacer mi app al abrirse es recuperar los alumnos que
		// ya existieran
		// En una aplicación que trabaje con muchos alumnos, lo ideal no sería volcar
		// todo el contenido del fichero en una lista, porque haríamos que la ejecución
		// del programa fuera muy pesada
		try {
			recuperarAlumnos();
		} catch (ClassNotFoundException | IOException e) {
			System.err.println("Error al recuperar alumno");
			e.printStackTrace();
		}

		int numAlumnosToAdd = 0;
		boolean validQuantity = false;
		while (!validQuantity) {
			try {
				System.out.println("¿Cuántos alumnos quieres añadir?");
				numAlumnosToAdd = Integer.parseInt(scan.nextLine());
				validQuantity = true;
			} catch (NumberFormatException e) {
				System.err.println("Número no válido, prueba de nuevo");
			}
		}

		for (int i = 0; i < numAlumnosToAdd; i++) {
			if (addAlumno()) {
				System.out.println("Alumno añadido");
			} else {
				System.err.println("No se pudo añadir el alumno");
			}
		}

		for (Alumno a : alumnos) {
			a.matricularAlumno();
			System.out.println("Alumno matriculado");
		}

		for (Alumno a : alumnos) {
			System.out.println(a);
		}

		try {
			guardarDatos();
			System.out.println("Alumnos serializados");
		} catch (IOException e) {
			System.err.println("No se pudieron serializar los alumnos");
			e.printStackTrace();
		}
		System.out.println("Finalizando programa...");

	}

	private static boolean addAlumno() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el nif");
		String nif = scan.nextLine();
		System.out.println("Introduce el nombre");
		String nombre = scan.nextLine();
		return alumnos.add(new Alumno(nif, nombre)); // Como hemos implementado un hashCode y equals por nif en Alumno,
														// sólo se
		// insertará en el HashSet si no existe el nif. Y add devolverá true si
		// se ha podido añadir o false si no
	}

	private static void guardarDatos() throws IOException {
		// Hay que pasarle en el constructor un flujo básico de de bytes asociado al
		// archivo. Se hace con la clase FileOutputStream
		// Igual que sucedía con FileOutputReader, se le puede pasar como segundo
		// parámetro un true o un false para decidir si añade a lo que ya tuviera el
		// fichero o elimina lo previo y añade lo nuevo, respectivamente. Por defecto si
		// no se pone nada es false
		FileOutputStream fos = new FileOutputStream(fichero); // Le pasamos el objeto que contiene la información del
																// fichero. Ese objeto lo hemos puesto como propiedad
																// estática de esta clase
		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero)); // Esto se podría hacer así directamente

		for (Alumno a : alumnos) { // Para que un objeto de Alumno sea serializable, tenemos que hacer que pueda
									// ser serializable. Ver clase Alumno. También tenemos que implementar
									// Serializable en la clase Matricula, pues los Alumnos tienen un objeto
									// Matricula como propiedad
			oos.writeObject(a);
		}

		// Cerramos recursos
		oos.close();
		fos.close();
	}

	private static void recuperarAlumnos() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File(fichero);
		if (!file.exists()) {
			return;
		}

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));

		boolean fin = false; // En el proceso de deserialización, la única forma de saber que hemos terminado
								// de leer el fichero es mediante la aparición de una excepción. Por lo tanto,
								// podemos capturarla y aprovechar para cambiar el valor de un boolean que haga
								// que se salga del bucle
		while (!fin) {
			try {
				alumnos.add((Alumno) ois.readObject()); // Si no hacemos el casting, nos da error
			} catch (EOFException e) {
				fin = true;
			}

		}
		ois.close();

	}

}
