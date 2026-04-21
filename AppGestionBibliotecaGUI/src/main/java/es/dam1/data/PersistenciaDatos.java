package es.dam1.data;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import es.dam1.data.Inventario;
import es.dam1.model.Libro;

public class PersistenciaDatos {

	public static int recuperarLibros(File file) {
		int librosRecuperados = 0;
		if (file.exists()) {
			boolean fin = false;
			while (!fin) {
				try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
					Libro l = (Libro) ois.readObject();
					Inventario.libros.put(l.getIsbn(), l);
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
			}
		}
		return librosRecuperados;
	}

	public static int guardarLibros(File file) {
		int librosGuardados = 0;
		if (file.exists() && Inventario.libros.size() > 0) {
			
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
				for (Map.Entry<Integer, Libro> i : Inventario.libros.entrySet()) {
					oos.writeObject(i.getValue());
				}
				librosGuardados++;
			} catch (FileNotFoundException e) {
				System.err.println("Error, no se encontró el fichero");
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println("Error en proceso IO");
				e.printStackTrace();
			}
		}
		return librosGuardados;
	}
	
	public static void recuperarPrestamos(File file) {
		//TODO
	}
	
	public static void guardarPrestamos(File file) {
		//TODO
	}

}
