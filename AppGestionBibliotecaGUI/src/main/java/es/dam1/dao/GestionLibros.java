package es.dam1.dao;

import java.io.File;

import es.dam1.data.Inventario;
import es.dam1.data.PersistenciaDatos;
import es.dam1.model.Libro;

public class GestionLibros {
	private static File libros;

	public static boolean addLibro(int isbn, String nombre, String descripcion, String categoria, int stock) {
		boolean added = false;
		if (!Inventario.libros.containsKey(isbn)) {
			Inventario.libros.put(isbn, new Libro(isbn, nombre, descripcion, categoria, stock));
			added = true;
		}
		if (added) {
			PersistenciaDatos.guardarLibros(libros);
		}
		return added;
	}
	
	public static boolean eliminarLibro(int isbn) {
		boolean eliminado = false;
		if ((Inventario.libros.remove(isbn)) != null) {
			eliminado = true;
		}
		if (eliminado) {
			PersistenciaDatos.guardarLibros(libros);
		}
		return eliminado;
	}

}
