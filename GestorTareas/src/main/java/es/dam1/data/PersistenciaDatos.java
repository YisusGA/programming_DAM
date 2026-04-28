package es.dam1.data;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import es.dam1.model.Tarea;


public class PersistenciaDatos {

	private static File directorio = new File("data");
	private static File ficheroTareas = new File("data/ficheroTareas.dat");

	public static int recuperarTareas() {
		int tareasRecuperadas = 0;
		if (ficheroTareas.exists()) {
			boolean fin = false;
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheroTareas))) {
				while (!fin) {
					Tarea t = (Tarea) ois.readObject();
					Data.tareas.add(t);
					tareasRecuperadas++;
				}
			} catch (EOFException e) {
				fin = true;
			} catch (FileNotFoundException e) {
				System.err.println("Error, no se encontró el fichero");
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println("Error en proceso IO");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.err.println("No se pudo leer el libro, se ignoró");
				e.printStackTrace();
			}
		} else if (!directorio.exists()) {
			directorio.mkdir();
		}
		return tareasRecuperadas;
	}
	
	public static int guardarTareas() {
		int tareasGuardadas = 0;
		if (Data.tareas.size() > 0) {
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficheroTareas))) {
				for (Tarea t : Data.tareas) {
					oos.writeObject(t);
					tareasGuardadas++;
				}
			} catch (FileNotFoundException e) {
				System.err.println("Error, no se encontró el fichero");
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println("Error en proceso IO");
				e.printStackTrace();
			}
		}
		return tareasGuardadas;
	}

}
