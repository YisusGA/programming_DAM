package es.dam1.data;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import es.dam1.controller.ServiceController;
import es.dam1.model.Album;

public class PersistenciaDatos {
	private static File directorio = new File("data");
	private static File ficheroAlbumes = new File("data/ficheroAlbumes.dat");

	public static int recuperarAlbumes() {
		int albumesRecuperados = 0;
		if (ficheroAlbumes.exists()) {
			boolean fin = false;
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheroAlbumes))) {
				while (!fin) {
					Album p = (Album) ois.readObject();
					ServiceController.getListaAlbumes().add(p);
					albumesRecuperados++;
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
		return albumesRecuperados;
	}

	public static int guardarAlbumes() {
		int albumesGuardados = 0;
		List<Album> albumes = ServiceController.getListaAlbumes();
		if (albumes.size() > 0) {
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficheroAlbumes))) {
				for (Album i : albumes) {
					oos.writeObject(i);
					albumesGuardados++;
				}
			} catch (FileNotFoundException e) {
				System.err.println("Error, no se encontró el fichero");
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println("Error en proceso IO");
				e.printStackTrace();
			}
		}
		return albumesGuardados;
	}

}
