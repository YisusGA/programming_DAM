package gestion;

import modelo.Habitacion;
import modelo.HabitacionFamiliar;
import modelo.TipoHabitacion;
import teclado.Teclado;
import teclado.Teclado2;

public class GestorHotel {
	private static Habitacion[] habitaciones = new Habitacion[0];

	public static void crearHabitacion() {
		Habitacion habitacion;
		int numeroHabitacion;
		System.out.println(habitacionesExistentes());
		do {
			System.out.println("Introduce el número de habitación. No debe ser un número de habitación que ya exista");
			numeroHabitacion = Teclado.leerEntero();
		} while (numeroHabitacion < 0 && comprobarSiExisteHabitacion(numeroHabitacion));
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
		default -> {
			habitacion = null;
		}
		}
		Habitacion[] aux = new Habitacion[habitaciones.length + 1];
		for (int i = 0; i < habitaciones.length; i++) {
			aux[i] = habitaciones[i];
		}
		aux[aux.length - 1] = habitacion;
		habitaciones = aux;
	}

	public static boolean comprobarSiExisteHabitacion(int numeroHabitacion) {
		for (int i = 0; i < habitaciones.length; i++) {
			if (habitaciones[i].getNumeroHabitacion() == numeroHabitacion) {
				return true;
			}
		}
		return false;
	}

	public static String habitacionesExistentes() {
		String habitacionesExistentes = "Las habitaciones que ya existen son: ";
		for (Habitacion habitacion : habitaciones) {
			habitacionesExistentes += habitacion.getNumeroHabitacion() + ", ";
		}
		return habitacionesExistentes;
	}

	public static Habitacion devolverHabitacion(int numeroHabitacion) {
		for (int i = 0; i < habitaciones.length; i++) {
			if (habitaciones[i].getNumeroHabitacion() == numeroHabitacion) {
				return habitaciones[i];
			}
		}
		return null;
	}

	public String eliminarHabitacion(int numeroHabitacion) {
		if (comprobarSiExisteHabitacion(numeroHabitacion)) {
			Habitacion[] aux = new Habitacion[habitaciones.length - 1];
			for (int i = 0; i < habitaciones.length; i++) {
				aux[i] = habitaciones[i];
			}
			habitaciones = aux;
			return "Habitación eliminada correctamente";
		}
		return "No se ha encontrado la habitación con ese número";
	}

	public String actualizarDatosHabitacion(int numeroHabitacion) {
		if (comprobarSiExisteHabitacion(numeroHabitacion)) {
			Habitacion habitacion = devolverHabitacion(numeroHabitacion);
			System.out.println(habitacion);
			TipoHabitacion tipo = habitacion.getTipo();
			System.out.println("¿Qué dato(s) quieres actualizar?");
			System.out.println("Datos habitación:" + habitacion);
			int opcion;
			do {
				System.out.println("""
						1. Número de camas individuales
						2. Número de camas dobles
						3. Precio
						0. Salir
						""");
				opcion = Teclado2.leerEntero();
				switch (opcion) {
				case 1 -> {
					int num;
					do {
						System.out.println("Introduce el número de camas individuales. Debe ser >= 0");
						num = Teclado2.leerEntero();
					} while (num < 0);
					habitacion.setNumeroCamas(num);
				}
				case 2 -> {
					if (habitacion instanceof HabitacionFamiliar) {
						int num;
						do {
							System.out.println("Introduce el número de camas dobles. Debe ser >= 0");
							num = Teclado2.leerEntero();
						} while (num < 0);
						((HabitacionFamiliar) habitacion).setNumeroCamasDobles(num);
					} else {
						System.err.println("No se pueden añadir camas dobles en una habitación estándar");
					}
				}
				case 3 -> {
					double precio;
					do {
						System.out.println("Introduce el nuevo precio. Debe ser > 0");
						precio = Teclado2.leerDecimal();
					} while (precio <= 0);
					habitacion.setPrecio(precio);

				}
				case 0 -> {
					System.out.println("Saliendo de funcionalidad de actualización de datos...");
				}
				default -> {
					System.err.println("La opción introducida no es válida");
				}
				}
			} while (opcion != 0);

		}
		return "No se ha encontrado la habitación con ese número";
	}
}
