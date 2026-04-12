package data;

import java.util.Map;
import java.util.TreeMap;

import model.Libro;
import model.Prestamo;

public class Inventario {
	
	public static Map<Integer, Libro> libros = new TreeMap<>();
	public static Map<Integer, Prestamo> prestamos = new TreeMap<>();

}
