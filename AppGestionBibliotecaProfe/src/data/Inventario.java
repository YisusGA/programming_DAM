package data;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import model.Libro;
import model.Prestamo;

public class Inventario {
	
	public static Map<Integer,Prestamo> prestamos = new TreeMap<>();
	public static List<Libro> libros = new LinkedList<>();

}
