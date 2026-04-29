package es.dam1.dao;

import java.time.LocalDate;
import es.dam1.data.Inventario;
import es.dam1.model.Libro;
import es.dam1.model.Movimiento;
import es.dam1.other.TipoMovimiento;

public class GestorMovimientos {
	private static int idMovimientoGenerado = 0;

	public static boolean registrarMovimiento(int isbn, int numeroCopias, LocalDate fecha, TipoMovimiento tipoMovimiento) {
		boolean registrado = false;
		Libro l = Inventario.libros.get(isbn);
		if (l != null) {
			if (tipoMovimiento != null) {
				int nuevoStock;
				Movimiento p;
				if (tipoMovimiento == TipoMovimiento.DEVOLUCION) {
					nuevoStock = l.getStock() + numeroCopias;
				} else {
					nuevoStock = l.getStock() - numeroCopias;
					if (nuevoStock < 0) {
						numeroCopias = l.getStock();
						nuevoStock = 0;
					}
				}
				p = new Movimiento(idMovimientoGenerado++, l, numeroCopias, fecha, tipoMovimiento);
				l.setStock(nuevoStock);
				Inventario.libros.replace(l.getIsbn(), l);
				Inventario.movimientos.add(p);
				registrado = true;
			}
		}
		return registrado;
	}

}
