package dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import modelo.Destino;

public class DestinoDAO {
	private static File file = new File("datos//destinos.dat");
	// Aquí meteríamos lo que se puede hacer con los datos, el CRUD: insertar,
	// borrar, consultar y modificar

	public static boolean insert(Destino destino) throws FileNotFoundException, ClassNotFoundException, IOException {
		boolean inserted = false;
		// Si el fichero existe, lo abrimos con nuestra versión del OOS, que no escribe
		// cabecera
		if (file.exists() && !existeDestino(destino)) {
			// Super importante poner aquí el true, porque queremos añadir el nuevo objeto
			// al fichero ya existente, y no vamos a escribir cabecera. Si no ponemos el
			// true, como por defecto es false, lo que va a suceder es que se va a cargar el
			// contenido del fichero y va a empezar a escribir de nuevo, pero sin cabecera,
			// y luego el OIS dará excepción de StreamCorruptedException
			ObjectOutputStreamADD oos = new ObjectOutputStreamADD(new FileOutputStream(file, true));
			oos.writeObject(destino);
			inserted = true;
//			ois.close();
			oos.close();
			// Si el fichero no existe, lo abrimos con la versión de java.io de OOS
		} else if (!file.exists()) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(destino);
			inserted = true;
			oos.close();
		}
		return inserted;
	}

	public static boolean insertOLD(Destino destino) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean inserted = false;
		if (file.exists() && !existeDestino(destino)) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datos/temp"));
			while (!inserted) {
				try {
					Destino d = (Destino) ois.readObject();
					oos.writeObject(d);
				} catch (EOFException e) {
					oos.writeObject(destino);
					inserted = true;
				}
			}
			ois.close();
			oos.close();

			File temp = new File("datos//temp");
			file.delete();
			temp.renameTo(file);
		} else if (!file.exists()) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(destino);
			inserted = true;
			oos.close();
		}
		return inserted;
	}

	public static boolean delete(String nombre) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean deleted = false;
		if (file.exists() && existeDestino(nombre)) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datos//temp"));
			while (!deleted) { // Como para entrar aquí ha tenido que salir true en existeDestino(nombre),
								// puedo permitirme usar el propio boolean deleted para salir del bucle, pues sí
								// o sí lo va a borrar, pues existe
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

	public static boolean update(String nombre, Destino destino)
			throws FileNotFoundException, ClassNotFoundException, IOException {
		boolean updated = false;
		if (file.exists() && existeDestino(nombre)) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datos//temp"));
			boolean fin = false;
			while (!fin) {
				try {
					Destino d = (Destino) ois.readObject();
					if (d.getNombre().equalsIgnoreCase(nombre)) {
						oos.writeObject(destino);
						updated = true;
					} else {
						oos.writeObject(d);
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
			ois.close();
		}
		return d;
	}

	public static List<Destino> listarDestinos() throws FileNotFoundException, IOException, ClassNotFoundException {
		List<Destino> destinos = null;
		List<Destino> aux = null;
		if (file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			aux = new ArrayList<>();
			boolean fin = false;
			while (!fin) {
				try {
					aux.add((Destino) ois.readObject());
				} catch (EOFException e) {
					fin = true;
				}
			}
			ois.close();
			if (aux.size() > 0) {
				destinos = aux;
			}
		}
		return destinos;
	}

	public static boolean existeDestino(Destino destino)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean existe = false;
		if (file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			boolean fin = false;
			while (!fin && !existe) {
				try {
					if (((Destino) ois.readObject()).equals(destino)) {
						existe = true;
					}
				} catch (EOFException e) {
					fin = true;
				}
			}
			ois.close();
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
