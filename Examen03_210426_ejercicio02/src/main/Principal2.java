package main;

import gestion.GestorPrestamos;
import model.Prestamo;

public class Principal2 {

	public static void main(String[] args) {
		GestorPrestamos gp = new GestorPrestamos();
		
		GestorPrestamos.prestamos.put(1, new Prestamo(1, "1d", "123d", false));
		GestorPrestamos.prestamos.put(2, new Prestamo(2, "2d", "456d", false));
		
		gp.guardaPrestamos();

	}

}
