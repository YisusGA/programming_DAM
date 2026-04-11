package logica;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Map;

import data.Inventario;
import model.Libro;
import model.Prestamo;

public class Metodos {

	public static void guardarPrestamos(File file) {
		try (FileWriter fw = new FileWriter(file)) {
			for (Map.Entry<Integer, Prestamo> e : Inventario.prestamos.entrySet()) {
				fw.write(e.getValue().getIdPrestamo() + "-" + e.getValue().getLibro().getNombre() + "-"
						+ e.getValue().getFecha() + "-" + e.getValue().getCantidad() + "-"
						+ (e.getValue().getTipoMovimiento() == 0 ? "PRÉSTAMO" : "DEVOLUCIÓN") + "/n");

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void recuperaPrestamos(File file) {
		if (!file.exists() || file.length() == 0) {
			return;
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] campos = linea.split("-");
				Prestamo p = new Prestamo();
				p.setIdPrestamo(Integer.parseInt(campos[0]));
				p.setCantidad(Integer.parseInt(campos[3]));
				LocalDate date = LocalDate.parse(campos[2]); // Comprobar
				p.setFecha(date);
				p.setTipoMovimiento((campos[4].equals("PRESTAMO")) ? 0 : 1);
				boolean encontrado = false;
				for (int i = 0; !encontrado && i < Inventario.libros.size(); i++) {
					if (Inventario.libros.get(i).getNombre().equals(campos[1])) {
						p.setLibro(Inventario.libros.get(i));
						encontrado = true;
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void guardarLibros(File file) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			//TODO
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void recuperaLibros(File file) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			boolean fin = false;
			while(!fin) {
				try {
					Libro l = (Libro) ois.readObject();
					Inventario.libros.add(l);
				} catch (EOFException e) {
					fin = true;
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
