package es.dam1.data;

import java.util.Map;
import java.util.TreeMap;
import es.dam1.model.Libro;
import es.dam1.model.Movimiento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventario {

	// En esta app, trabajo tanto con un Map como con una ObservableList para probar
	// a trabajar con ambas cosas y así practicar. Lo ideal en una app final sería
	// unificar todo en un diseño común
	public static Map<Integer, Libro> libros = new TreeMap<>();
	public static ObservableList<Movimiento> movimientos = FXCollections.observableArrayList();

}
