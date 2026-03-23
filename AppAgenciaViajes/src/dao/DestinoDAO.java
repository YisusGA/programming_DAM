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
	private File datos; // Mejor no inicializar el archivo de datos aquí, si no en el Main (o en la
						// clase Menus en mi caso), para así no condenar a la clase DestinoDAO a
						// funcionar con un sólo fichero de datos, haciendo que el DAO sea más general
	
	// Aquí meteríamos lo que se puede hacer con los datos, el CRUD: insertar,
	// borrar, consultar y modificar

	public DestinoDAO(File datos) {
		this.datos = datos;
	}

	public boolean insert(Destino destino) throws ClassNotFoundException, IOException {
		boolean inserted = false;
		// Si el fichero existe, lo abrimos con nuestra versión del OOS, que no escribe
		// cabecera
		if (datos.exists() && !existeDestino(destino)) {
			// Super importante poner aquí el true, porque queremos añadir el nuevo objeto
			// al fichero ya existente, y no vamos a escribir cabecera. Si no ponemos el
			// true, como por defecto es false, lo que va a suceder es que se va a cargar el
			// contenido del fichero y va a empezar a escribir de nuevo, pero sin cabecera,
			// y luego el OIS dará excepción de StreamCorruptedException
			ObjectOutputStreamADD oos = new ObjectOutputStreamADD(new FileOutputStream(datos, true));
			oos.writeObject(destino);
			inserted = true;
//			ois.close();
			oos.close();
			// Si el fichero no existe, lo abrimos con la versión de java.io de OOS
		} else if (!datos.exists()) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(datos));
			oos.writeObject(destino);
			inserted = true;
			oos.close();
		}
		return inserted;
	}

	public boolean insertOLD(Destino destino) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean inserted = false;
		if (datos.exists() && !existeDestino(destino)) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datos));
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datos//temp"));
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
			datos.delete();
			temp.renameTo(datos);
		} else if (!datos.exists()) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(datos));
			oos.writeObject(destino);
			inserted = true;
			oos.close();
		}
		return inserted;
	}

	public boolean delete(String nombre) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean deleted = false;
		if (datos.exists() && existeDestino(nombre)) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datos));
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
			datos.delete();
			temp.renameTo(datos);
		}
		return deleted;
	}

	public boolean update(String nombre, Destino destino)
			throws FileNotFoundException, ClassNotFoundException, IOException {
		boolean updated = false;
		if (datos.exists() && existeDestino(nombre)) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datos));
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
			datos.delete();
			temp.renameTo(datos);
		}
		return updated;
	}

	public Destino get(String nombre) throws FileNotFoundException, IOException, ClassNotFoundException {
		Destino d = null;
		if (datos.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datos));
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

	public List<Destino> findAll() throws FileNotFoundException, IOException, ClassNotFoundException {
		List<Destino> destinos = null;
		List<Destino> aux = null;
		if (datos.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datos));
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

	public boolean existeDestino(Destino destino) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean existe = false;
		if (datos.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datos));
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

	public boolean existeDestino(String nombre) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean existe = false;
		if (datos.exists()) {
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream(datos));
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
