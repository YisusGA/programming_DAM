package es.dam1.dao;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import es.dam1.data.Inventario;
import es.dam1.model.Libro;

public class GestionLibros {

	public static boolean addLibro(int isbn, String nombre, String descripcion, String categoria, int stock) {
		boolean added = false;
		if (!Inventario.libros.containsKey(isbn)) {
			Inventario.libros.put(isbn, new Libro(isbn, nombre, descripcion, categoria, stock));
			added = true;
		}
		return added;
	}
	
	public static boolean eliminarLibro(String nombre) {
		boolean eliminado = false;
		Set<Map.Entry<Integer, Libro>> vistaLibros = Inventario.libros.entrySet();
		Iterator<Map.Entry<Integer, Libro>> it = vistaLibros.iterator();
		while (it.hasNext()) {
			Libro l = it.next().getValue();
			if (l.getNombre().equalsIgnoreCase(nombre)) {
				it.remove();
				eliminado = true;
			}
		}
		return eliminado;
	}
	
	public static Set<Libro> buscarPorNombre(String nombre) {
		Set<Libro> librosNombre = null;
		Collection<Libro> librosAux = Inventario.libros.values();
		if (librosAux.size() > 0) {
			librosNombre = new TreeSet<>();
			for (Libro l : librosAux) {
				if(l.getNombre().equalsIgnoreCase(nombre)) {
					librosNombre.add(l);
				}
			}
			if(librosNombre.size() == 0) {
				librosNombre = null;
			}
		}
		return librosNombre;
	}
	
	public static Set<Libro> buscarPorCategoria(String categoria) {
		Set<Libro> librosCategoria = null;
		Collection<Libro> librosAux = Inventario.libros.values();
		if (librosAux.size() > 0) {
			librosCategoria = new TreeSet<>();
			for (Libro l : librosAux) {
				if(l.getCategoria().equalsIgnoreCase(categoria)) {
					librosCategoria.add(l);
				}
			}
			if(librosCategoria.size() == 0) {
				librosCategoria = null;
			}
		}
		return librosCategoria;
	}
	
	public static Set<Libro> listadoLibros() {
		Set<Libro> setLibros = null;
		Collection<Libro> librosAux = Inventario.libros.values();
		if (librosAux.size() > 0) {
			setLibros = new TreeSet<>();
			setLibros.addAll(librosAux);
		}
		return setLibros;
	}

}