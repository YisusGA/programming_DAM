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
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import modelo.Reserva;

public class ReservaDAO {
	private File datos; // Mejor no definir el fichero físico aquí, así la aplicación puede trabajar con
						// cualquier fichero que le pase el usuario. Se pedirá el fichero en el main
	private Map<Integer, Reserva> reservas;

	public ReservaDAO(File datos) throws IOException, ClassNotFoundException {
		this.datos = datos;
		// Volcamos el fichero en el Map. Usaremos un TreeMap, que ordena las claves
		// (según el compareTo de Integer en este caso), aunque en este ejemplo nos
		// daría igual un HashMap que un TreeMap (normalmente es mejor un HashMap, pero
		// así practicamos con TreeMap)
		reservas = new TreeMap<>();
		if (datos.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datos));
			boolean fin = false;
			while (!fin) {
				try {
					Reserva r = (Reserva) ois.readObject();
					reservas.put(r.getCodigo(), r);
				} catch (EOFException e) {
//					e.printStackTrace();
					fin = true;
				}

			}
			// Si no se entra en el if porque no existe el fichero, habríamos instanciado un
			// TreeMap vacío para trabajar con él luego
			ois.close();
		}
	}

	public boolean insert(Reserva reserva) throws FileNotFoundException, IOException {
		boolean inserted = false;
		if (!reservas.containsKey(reserva.getCodigo())) {
			reservas.put(reserva.getCodigo(), reserva);
			persiste();
			inserted = true;
		}
		return inserted;
	}

	public boolean delete(int codReserva) throws FileNotFoundException, IOException {
		boolean deleted = false;
		if (reservas.remove(codReserva) != null) {
			deleted = true;
			persiste();
		}
		return deleted;
	}

	public Reserva get(int codReserva) {
		Reserva r = reservas.get(codReserva);
		return r;
	}

	public boolean update(Reserva reserva) throws IOException {
		boolean updated = false;
		if (reservas.replace(reserva.getCodigo(), reserva) != null) {
			updated = true;
			persiste();
		}
		return updated;
	}

	public List<Reserva> findAll() {
		Collection<Reserva> collectionReservas = reservas.values();
		List<Reserva> listReservas = new ArrayList<>();
		if (!listReservas.addAll(collectionReservas)) {
			listReservas = null;
		}
		return listReservas;
	}

	private void persiste() throws FileNotFoundException, IOException {
		// Este método se encarga de pasar todo el contenido del Map al fichero. Lo
		// usaremos al final de cada uno de los otros métodos. Tenemos 2 opciones:
		// Opción 1: iterar en el Map y guardamos las reservas una a una
		// Opción 2: guardar el objeto Map en el fichero.
		// La opción 2 es la más cómoda, pero vamos a hacer la primera.

		Collection<Reserva> aux = reservas.values();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(datos));
		for (Reserva r : aux) {
			oos.writeObject(r);
		}
		oos.close();
	}

	public boolean existeReserva(int codReserva) {
		boolean existe = false;
		if (reservas.containsKey(codReserva)) {
			existe = true;
		}
		return existe;
	}

	public int getMayorCodigoReserva() {
		int max = -1;
		Set<Integer> claves = reservas.keySet();
		for (Integer i : claves) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}

}
