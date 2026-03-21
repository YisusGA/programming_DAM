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
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, true));
		if (!existeDestino(d)) {
			oos.writeObject(d);
			inserted = true;
		}
		oos.close();
		return inserted;
	}

	public static boolean delete(String nombre) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean deleted = false;
		if (file.exists() && existeDestino(nombre)) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datos//temp"));
			while (!deleted) {
				try {
					Destino d = (Destino) ois.readObject();
					if (!d.getNombre().equalsIgnoreCase(nombre)) {
						oos.writeObject(d);
					}
				} catch (EOFException e) {
					deleted = true;
				}
			}

			ois.close();
			oos.close();

			File temp = new File("datos//temp");
			file.delete();
			temp.renameTo(file);
		}
		return deleted;
	}

	public static boolean update(String nombre, Destino destino) throws FileNotFoundException, ClassNotFoundException, IOException {
		boolean updated = false;
		if (file.exists() && existeDestino(nombre)) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datos//temp"));
			boolean fin = false;
			while (!fin && !updated) {
				try {
					Destino d = (Destino) ois.readObject();
					if (d.getNombre().equalsIgnoreCase(nombre)) {
						oos.writeObject(destino);
						updated = true;
					}
				} catch (EOFException e) {
					fin = true;
				}
			}

			ois.close();
			oos.close();

			File temp = new File("datos//temp");
			file.delete();
			temp.renameTo(file);
		}
		return updated;
	}

	public static Destino get(String nombre) throws FileNotFoundException, IOException, ClassNotFoundException {
		Destino d = null;
		if (file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			boolean encontrado = false;
			boolean fin = false;
			while (!fin && !encontrado) {
				try {
					Destino temp = (Destino) ois.readObject();
					if (temp.getNombre().equalsIgnoreCase(nombre)) {
						d = temp;
						encontrado = true;
					}
				} catch (EOFException e) {
					fin = true;
				}
			}
		}
		return d;
	}

	public static boolean existeDestino(Destino d) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean existe = false;
		if (file.exists()) {
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream(file));
			boolean fin = false;
			while (!fin && !existe) {
				try {
					if (((Destino) oos.readObject()).equals(d)) {
						existe = true;
					}
				} catch (EOFException e) {
					fin = true;
				}
			}
			oos.close();
		}
		return existe;
	}

	public static boolean existeDestino(String nombre)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean existe = false;
		if (file.exists()) {
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream(file));
			boolean fin = false;
			while (!fin && !existe) {
				try {
					if (((Destino) oos.readObject()).getNombre().equalsIgnoreCase(nombre)) {
						existe = true;
					}
				} catch (EOFException e) {
					fin = true;
				}
			}
			oos.close();
		}
		return existe;
	}

}
