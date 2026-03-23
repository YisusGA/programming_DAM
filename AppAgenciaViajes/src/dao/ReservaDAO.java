package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import modelo.Reserva;

public class ReservaDAO {
	private static File datos; // Mejor no definir el fichero físico aquí, así la aplicación puede trabajar con
								// cualquier fichero que le pase el usuario. Se pedirá el fichero en el main
	// Tiene más sentido usar un HashMap en lugar de un TreeMap en este caso, porque
	// (completar)
	private Map<Long, Reserva> reservas;

	public ReservaDAO(File datos) throws FileNotFoundException, IOException {
		this.datos = datos;
		// Volcamos el fichero en el Map:
		reservas = new TreeMap<>();
		if (datos.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datos));
			boolean fin = false;
			while (!fin) {
				try {
					Reserva r = (Reserva) ois.readObject();
					reservas.put(r.getCodigo(), r);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public boolean insert(Reserva reserva) {
		boolean inserted = false;
		if (reservas.containsKey(reserva.getCodigo())) {
			reservas.put(reserva.getCodigo(), reserva);
			persiste();
		}
		return inserted;
	}

	public boolean delete(long codReserva) {
		boolean deleted = false;
		
		persiste();
		return deleted;
	}

	public Reserva get(long codReserva) {
		return null;
	}

	public boolean update(Reserva reserva) {
		// TODO
		persiste();
		return false;
	}

	public List<Reserva> findAll() {
		return null;
	}

	private void persiste() throws FileNotFoundException, IOException {
		// Este método se encarga de pasar todo el contenido del Map al fichero. Lo
		// usaremos al final de cada uno de los otros métodos. Tenemos 2 opciones:
		// Opción 1: iterar en el Map y guardamos las reservas una a una
		// Opción 2: guardar el objeto Map en el fichero.
		// La opción 2 es la más cómoda, pero vamos a hacer la primera.
		
		ObjectOutputStreamADD oos = new ObjectOutputStreamADD(new FileOutputStream(datos));
		Collection<Reserva> aux = reservas.values();
		for(Reserva r : aux) {
			oos.writeObject(r);
		}
		oos.close();
	}

}
