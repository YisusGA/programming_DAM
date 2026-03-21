package dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import modelo.Destino;

public class DestinoDAO {
	private static File file = new File("datos//destinos.dat");
	// Aquí meteríamos lo que se puede hacer con los datos, el CRUD: insertar,
	// borrar, consultar y modificar

	public static boolean insert(Destino d) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean inserted = false;
		if (file.exists() && validarDestino(d)) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, true));
			oos.writeObject(d);
			inserted = true;
			oos.close();
		}
		return inserted;
	}

	public static boolean delete(String nombre) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean deleted = false;
		if (file.exists() && !validarDestino(nombre)) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datos//temp"));
			boolean fin = false;
			while (!deleted && !fin) {
				try {
					Destino d = (Destino)ois.readObject();
					if (!d.getNombre().equalsIgnoreCase(nombre)) {
						oos.writeObject(d);
					}
				} catch (EOFException e) {
					fin = true;
				} finally {
					ois.close();
					oos.close();
					deleted = true;
				}
			}
		}
		return deleted;
	}

	public static boolean update(Destino destino) {
		return false;
	}

	public static Destino get(String nombre) {
		return null;
	}

	public static boolean validarDestino(Destino d) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean valido = true;
		if (file.exists()) {
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream(file));
			boolean fin = false;
			while (!fin) {
				try {
					if (((Destino) oos.readObject()).getNombre().equalsIgnoreCase(d.getNombre())) {
						valido = false;
					}
				} catch (EOFException e) {
					fin = true;
				}
			}
			oos.close();
		}
		return valido;
	}
	
	public static boolean validarDestino(String nombre) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean valido = true;
		if (file.exists()) {
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream(file));
			boolean fin = false;
			while (!fin) {
				try {
					if (((Destino) oos.readObject()).getNombre().equalsIgnoreCase(nombre)) {
						valido = false;
					}
				} catch (EOFException e) {
					fin = true;
				}
			}
			oos.close();
		}
		return valido;
	}

}
