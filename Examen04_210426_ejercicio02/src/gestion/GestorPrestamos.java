package gestion;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import model.Prestamo;

public class GestorPrestamos {
	public static Map<Integer, Prestamo> prestamos = new TreeMap<>();
	public static File file = new File("data/prestamosActivos.dat");

	public void cargaPrestamos() {
		boolean fin = false;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			while (!fin) {
				Prestamo p = (Prestamo) ois.readObject();
				prestamos.put(p.getIdPrestamo(), p);
			}
			
		} catch (EOFException e) {
			fin = true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void presta(String dni, String isbn) {
		Set<Integer> ids = prestamos.keySet();
		Integer maxId = -1;
		for (Integer i : ids) {
			if (i > maxId) {
				maxId = i;
			}
		}
		Prestamo p = new Prestamo(maxId + 1, dni, isbn, false);
		prestamos.put(maxId + 1, p);
		
	}

	public void devuelve(int idPrestamo) {
		prestamos.get(idPrestamo).setDevuelto(true);
		
	}

	public void listaPrestamosNoDevueltos() {
		Collection<Prestamo> prestamosAux = prestamos.values();
		for (Prestamo p : prestamosAux) {
			if (!p.isDevuelto()) {
				System.out.println(p);
			}
		}
		
	}

	public void guardaPrestamos() {
		Collection<Prestamo> prestamosAux = prestamos.values();
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream (file))) {
			for (Prestamo p : prestamosAux) {
				oos.writeObject(p);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
