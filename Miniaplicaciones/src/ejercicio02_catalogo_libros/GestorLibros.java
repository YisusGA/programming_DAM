package ejercicio02_catalogo_libros;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GestorLibros {
	static Set<Libro> libros = new HashSet<>();
	
	public static String addLibro(Libro libro) {
		if (!libros.contains(libro)) {
			libros.add(libro);
		}
		return "El libro que se intenta añadir ya existe";
	}
	
	public static List<Libro> mostrarCatalogo() {
		if (libros != null && libros.size() > 0) {
			List<Libro> aux = new ArrayList<>();
			aux.addAll(libros);
			aux.sort(new CriterioOrdenAlfabetico());
			return aux;
		}
		return null;
	}

}
