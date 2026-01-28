package gestion;

import modelo.Habitacion;
import modelo.HabitacionFamiliar;
import modelo.TipoHabitacion;
import teclado.Teclado2;

public class GestorHotel {
	private static Habitacion[] habitaciones = new Habitacion[0];

	public void crearHabitacion() { 
		Habitacion habitacion;
		System.out.println("Introduce el número de habitación");
		int numeroHabitacion = Teclado2.leerEntero();
		System.out.println("Introduce el número de camas individuales");
		int numeroCamas = Teclado2.leerEntero();
		System.out.println("Introduce el precio");
		double precio = Teclado2.leerDecimal();
		TipoHabitacion tipo;
		do {
			System.out.println("Introduce un tipo de habitacion válido: HABITACION / HABITACIONFAMILIAR");
			tipo = TipoHabitacion.leerTeclado();
		} while (tipo != null);
		
		switch (tipo) {
		case HABITACION -> {
			habitacion = new Habitacion(numeroHabitacion, numeroCamas, precio, tipo);
		}
		case HABITACIONFAMILIAR -> {
			System.out.println("Introduce el número de camas dobles");
			int numeroCamasDobles = Teclado2.leerEntero();
			habitacion = new HabitacionFamiliar(numeroHabitacion, numeroCamas, precio, tipo, numeroCamasDobles);
		}
		}
		Habitacion[] aux = new Habitacion[habitaciones.length + 1];
		for (int i = 0; i < habitaciones.length; i++) {
			aux[i] = habitaciones[i];
		}
		habitaciones = aux;
	}
}
