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
import es.dam1.model.Libro;
import es.dam1.model.Prestamo;

public class PersistenciaDatos {
	private static File directorio = new File("data");
	private static File ficheroLibros = new File("data/ficheroLibros.dat");
	private static File ficheroPrestamos = new File("data/ficheroPrestamos.dat");

	public static int recuperarLibros() {
		int librosRecuperados = 0;
		if (ficheroLibros.exists()) {
			boolean fin = false;
			while (!fin) {
				try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheroLibros))) {
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
		} else if (!directorio.exists()) {
			directorio.mkdir();
		}
		return librosRecuperados;
	}

	public static int guardarLibros() {
		int librosGuardados = 0;
		if (ficheroLibros.exists() && Inventario.libros.size() > 0) {
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficheroLibros))) {
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
	
	public static int recuperarPrestamos() {
		int prestamosRecuperados = 0;
		if (ficheroPrestamos.exists()) {
			boolean fin = false;
			while (!fin) {
				try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheroPrestamos))) {
					Prestamo p = (Prestamo) ois.readObject();
					Inventario.prestamos.put(p.getIdPrestamo(), p);
				} catch (EOFException e) {
					fin = true;
				} catch (FileNotFoundException e) {
					System.err.println("Error, no se encontró el fichero");
					e.printStackTrace();
				} catch (IOException e) {
					System.err.println("Error en proceso IO");
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					System.err.println("No se pudo leer el préstamo, se ignoró");
					e.printStackTrace();
				}
			}
		} else if (!directorio.exists()) {
			directorio.mkdir();
		}
		return prestamosRecuperados;
	}
	
	public static int guardarPrestamos() {
		int prestamosGuardados = 0;
		if (ficheroLibros.exists() && Inventario.libros.size() > 0) {
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficheroPrestamos))) {
				for (Map.Entry<Integer, Prestamo> i : Inventario.prestamos.entrySet()) {
					oos.writeObject(i.getValue());
				}
				prestamosGuardados++;
			} catch (FileNotFoundException e) {
				System.err.println("Error, no se encontró el fichero");
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println("Error en proceso IO");
				e.printStackTrace();
			}
		}
		return prestamosGuardados;
	}

}
