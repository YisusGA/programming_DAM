package es.dam1.data;

import java.util.Map;
import java.util.TreeMap;

import es.dam1.model.Libro;
import es.dam1.model.Prestamo;

public class Inventario {
	
	public static Map<Integer, Libro> libros = new TreeMap<>();
	public static Map<Integer, Prestamo> prestamos = new TreeMap<>();

}
