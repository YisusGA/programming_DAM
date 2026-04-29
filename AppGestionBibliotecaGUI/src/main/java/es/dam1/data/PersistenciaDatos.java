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
import es.dam1.model.Movimiento;

public class PersistenciaDatos {
	private static File directorio = new File("data");
	private static File ficheroLibros = new File("data/ficheroLibros.dat");
	private static File ficheroPrestamos = new File("data/ficheroPrestamos.dat");

	public static int recuperarLibros() {
		int librosRecuperados = 0;
		if (ficheroLibros.exists()) {
			boolean fin = false;
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheroLibros))) {
				while (!fin) {
					Libro l = (Libro) ois.readObject();
					Inventario.libros.put(l.getIsbn(), l);
					librosRecuperados++;
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
		return librosRecuperados;
	}

	public static int guardarLibros() {
		int librosGuardados = 0;
		if (Inventario.libros.size() > 0) {
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficheroLibros))) {
				for (Map.Entry<Integer, Libro> i : Inventario.libros.entrySet()) {
					oos.writeObject(i.getValue());
					librosGuardados++;
				}
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
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheroPrestamos))) {
				while (!fin) {
					Movimiento p = (Movimiento) ois.readObject();
					Inventario.movimientos.add(p);
					prestamosRecuperados++;
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
				System.err.println("No se pudo leer el préstamo, se ignoró");
				e.printStackTrace();
			}
		} else if (!directorio.exists()) {
			directorio.mkdir();
		}
		return prestamosRecuperados;
	}

	public static int guardarPrestamos() {
		int prestamosGuardados = 0;
		if (Inventario.movimientos.size() > 0) {
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficheroPrestamos))) {
				for (Movimiento i : Inventario.movimientos) {
					oos.writeObject(i);
					prestamosGuardados++;
				}
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
