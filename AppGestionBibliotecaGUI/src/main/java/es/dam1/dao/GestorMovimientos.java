package es.dam1.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import es.dam1.data.Inventario;
import es.dam1.model.Libro;
import es.dam1.model.Movimiento;
import es.dam1.other.TipoMovimiento;

public class GestorMovimientos {
	private static int idMovimientoGenerado = 0;

	public static boolean registrarMovimiento(int isbn, int numeroCopias, LocalDate fecha, String tipoMovimiento) {
		boolean registrado = false;
		Libro l = Inventario.libros.get(isbn);
		if (l != null) {
			TipoMovimiento tipo = TipoMovimiento.leerTipo(tipoMovimiento);
			if (tipo != null) {
				int nuevoStock;
				if (tipo == TipoMovimiento.DEVOLUCION) {
					nuevoStock = l.getStock() + numeroCopias;
					Movimiento p = new Movimiento(idMovimientoGenerado, l, numeroCopias, fecha, TipoMovimiento.DEVOLUCION);
				} else {
					nuevoStock = l.getStock() - numeroCopias;
					Movimiento p = new Movimiento(idMovimientoGenerado, l, numeroCopias, fecha, TipoMovimiento.PRESTAMO);
				}
				l.setStock(nuevoStock);
				Inventario.libros.replace(l.getIsbn(), l);
				Inventario.movimientos.put(idMovimientoGenerado++, p);
				
			}
		}
		return registrado;
	}

	public static List<Movimiento> consultarHistorialMovimientos() {
		List<Movimiento> movimientos = null;
		if (Inventario.movimientos.size() > 0) {
			movimientos = new ArrayList<>();
			movimientos.addAll(Inventario.movimientos.values());
		}
		return movimientos;
	}

}
