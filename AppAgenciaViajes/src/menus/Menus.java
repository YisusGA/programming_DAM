package menus;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import dao.DestinoDAO;
import dao.ReservaDAO;
import modelo.Destino;
import modelo.Reserva;
import teclado.TecladoOK;

public class Menus {
	// Cada vez que se instancie ReservaDAO en el método gestionReservas() de esta
	// clase, miramos cuál es el código de reserva más alto de las reservas que se
	// han recuperado del fichero, y generamos a partir de ahí. Si no hiciéramos
	// esto y partiéramos de 0, nunca se podría añadir una nueva reserva si paramos
	// y arrancamos de nuevo la aplicación, pues partiría siempre del código 0, y ya
	// existiría una reserva con ese código
	private static int generadorCodigoReserva;

	public static int mostrarMenuGeneral() {
		System.out.println("""
				Bienvenido a la Agencia de Viajes YisusTravels S.L.

				Escoge una opción

				1. Gestionar destinos
				2. Gestionar reservas
				0. Salir del programa
				""");
		return TecladoOK.leerEntero();
	}

	public static int mostrarMenuDestinos() {
		System.out.println("""
				GESTIÓN DE DESTINOS

				Escoge una opción

				1. Insertar destino
				2. Recuperar destino
				3. Eliminar destino
				4. Modificar destino
				5. Listar destinos disponibles
				0. Salir del menú
				""");
		return TecladoOK.leerEntero();
	}

	public static int mostrarMenuReservas() {
		System.out.println("""
				GESTIÓN DE RESERVAS

				Escoge una opción

				1. Insertar reserva
				2. Recuperar reserva
				3. Eliminar reserva
				4. Modificar reserva
				5. Listar reservas disponibles
				0. Salir del menú
				""");
		return TecladoOK.leerEntero();
	}

	public static void gestionGeneral() {
		int opcion;

		do {
			opcion = mostrarMenuGeneral();

			switch (opcion) {
			case 1 -> {
				gestionDestinos();
			}
			case 2 -> {
				gestionReservas();
			}
			case 0 -> {
				System.out.println("Saliendo del programa...");
			}
			default -> {
				System.err.println("La opción introducida no es válida");
			}
			}
		} while (opcion != 0);

	}

	public static void gestionDestinos() {
		DestinoDAO destinodao = new DestinoDAO(new File("datos//destinos.dat"));
		int opcion;

		do {
			opcion = mostrarMenuDestinos();

			switch (opcion) {
			case 1 -> {
				System.out.println("Introduce el nombre del destino");
				String nombre = TecladoOK.leerCadena();
				System.out.println("Introduce el precio del destino");
				double precio = TecladoOK.leerDecimal();
				try {
					if (destinodao.insert(new Destino(nombre, precio))) {
						System.out.println("Destino añadido");
					} else {
						System.err.println("El destino no pudo añadirse");
					}
				} catch (ClassNotFoundException | IOException e) {
					System.err.println("Error en la operación");
					e.printStackTrace();
				}
			}
			case 2 -> {
				System.out.println("Introduce el nombre del destino");
				String nombre = TecladoOK.leerCadena();
				try {
					Destino d = destinodao.get(nombre);
					if (d != null) {
						System.out.println("Datos del destino solicitado: " + d);
					} else {
						System.err.println("No se pudo recuperar el destino");
					}
				} catch (ClassNotFoundException | IOException e) {
					System.err.println("Error en la operación");
					e.printStackTrace();
				}
			}
			case 3 -> {
				System.out.println("Introduce el nombre del destino");
				String nombre = TecladoOK.leerCadena();
				try {
					if (destinodao.delete(nombre)) {
						System.out.println("Destino eliminado correctamente");
					} else {
						System.err.println("No se pudo eliminar el destino");
					}
				} catch (ClassNotFoundException | IOException e) {
					System.err.println("Error en la operación");
					e.printStackTrace();
				}
			}
			case 4 -> {
				System.out.println("Introduce el nombre del destino a modificar");
				String nombre = TecladoOK.leerCadena();
				System.out.println("Introduce el nuevo precio del destino");
				double precio = TecladoOK.leerDecimal();
				try {
					if (destinodao.update(new Destino(nombre, precio))) {
						System.out.println("Destino actualizado");
					} else {
						System.err.println("No se pudo actualizar el destino");
					}
				} catch (ClassNotFoundException | IOException e) {
					System.err.println("Error en la operación");
					e.printStackTrace();
				}
			}
			case 5 -> {
				try {
					List<Destino> destinos = destinodao.findAll();
					if (destinos != null) {
						for (Destino d : destinos) {
							System.out.println(d);
						}
					} else {
						System.err.println("No hay destinos añadidos");
					}
				} catch (ClassNotFoundException | IOException e) {
					System.err.println("Error en la operación");
					e.printStackTrace();
				}
			}

			case 0 -> {
				System.out.println("Saliendo del menú de destinos...");
			}
			default -> {
				System.err.println("La opción introducida no es válida");
			}
			}
		} while (opcion != 0);
	}

	public static void gestionReservas() {
		ReservaDAO reservadao = null;
		try {
			reservadao = new ReservaDAO(new File("datos//reservas.dat"));
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			System.err.println("Error en la lectura del fichero");
			return;
		}
		// Cada vez que se instancie ReservaDAO, miramos cuál es el código de reserva
		// más alto de las que se recuperan del fichero, y generamos a partir de ahí. Si
		// no hiciéramos esto y partiéramos de 0, nunca se podría añadir una nueva
		// reserva si paramos y arrancamos de nuevo la aplicación, pues partiría siempre
		// del código 0, y ya existiría una reserva con ese código
		generadorCodigoReserva = reservadao.getMayorCodigoReserva() + 1;
		int opcion;

		do {
			opcion = mostrarMenuReservas();

			switch (opcion) {
			case 1 -> {
				Reserva r = new Reserva();
				System.out.println("Introduce el nombre del cliente");
				String nombreCliente = TecladoOK.leerCadena();
				LocalDate fecha = null;
				boolean fechaValida = false;
				while (!fechaValida) {
					try {
						System.out.println("Introduce la fecha en el formato aaaa-mm-dd");
						fecha = LocalDate.parse(TecladoOK.leerCadena());
						fechaValida = true;
					} catch (DateTimeParseException e) {
						System.err.println("Formato de fecha no válido, prueba de neuvo");
					}
				}
				DestinoDAO destinodao = new DestinoDAO(new File("datos//destinos.dat"));
				System.out.println("Introduce el nombre del destino");
				String nombreDestino = TecladoOK.leerCadena();
				Destino d = null;
				try {
					if ((d = destinodao.get(nombreDestino)) == null) {
						System.err.println("No se pudo recuperar el destino");
					}
				} catch (ClassNotFoundException | IOException e) {
					System.err.println("Error en la operación de recuperación de destino");
					e.printStackTrace();
				}
				if (d != null) {
					r.setCliente(nombreCliente);
					r.setFecha(fecha);
					r.setDestino(d);
					r.setCodigo(generadorCodigoReserva++);
					try {
						reservadao.insert(r);
						System.out.println("Reserva añadida con éxito");
					} catch (IOException e) {
						System.err.println("Error en la operación de añadir reserva");
						e.printStackTrace();
					}
				} else {
					System.err.println("No se pudo completar la reserva porque el destino no es válido");
				}

			}
			case 2 -> {
				System.out.println("Introduce código de reserva");
				int codReserva = TecladoOK.leerEntero();
				Reserva r = null;
				if ((r = reservadao.get(codReserva)) != null) {
					System.out.println("Datos de la reserva: " + r);
				} else {
					System.err.println("No se pudo recuperar la reserva");
				}
			}
			case 3 -> {
				System.out.println("Introduce código de reserva");
				int codReserva = TecladoOK.leerEntero();
				boolean deleted = false;
				try {
					if (deleted = reservadao.delete(codReserva)) {
						System.out.println("Reserva eliminada con éxito");
					} else {
						System.err.println("No se encontró la reserva a eliminar");
					}
				} catch (IOException e) {
					System.err.println("Error en la operación");
					e.printStackTrace();
				}
			}
			case 4 -> {
				Reserva r = new Reserva();
				System.out.println("Introduce el código de la reserva");
				int codReserva = TecladoOK.leerEntero();
				if (reservadao.existeReserva(codReserva)) {
					System.out.println("Introduce el nombre del cliente");
					String nombreCliente = TecladoOK.leerCadena();
					LocalDate fecha = null;
					boolean fechaValida = false;
					while (!fechaValida) {
						try {
							System.out.println("Introduce la fecha en el formato aaaa-mm-dd");
							fecha = LocalDate.parse(TecladoOK.leerCadena());
							fechaValida = true;
						} catch (DateTimeParseException e) {
							System.err.println("Formato de fecha no válido, prueba de neuvo");
						}
					}
					DestinoDAO destinodao = new DestinoDAO(new File("datos//destinos.dat"));
					System.out.println("Introduce el nombre del destino");
					String nombreDestino = TecladoOK.leerCadena();
					Destino d = null;
					try {
						if ((d = destinodao.get(nombreDestino)) == null) {
							System.err.println("No se pudo recuperar el destino");
						}
					} catch (ClassNotFoundException | IOException e) {
						System.err.println("Error en la operación de recuperación de destino");
						e.printStackTrace();
					}
					if (d != null) {
						r.setCliente(nombreCliente);
						r.setFecha(fecha);
						r.setDestino(d);
						r.setCodigo(codReserva);
						try {
							reservadao.update(r);
							System.out.println("Reserva modificada con éxito");
						} catch (IOException e) {
							System.err.println("Error en la operación de modificar reserva");
							e.printStackTrace();
						}
					} else {
						System.err.println("No se pudo completar la reserva porque el destino no es válido");
					}
				} else {
					System.err.println("No se encontró la reserva");
				}
			}
			case 5 -> {
				List<Reserva> listReservas = reservadao.findAll();
				if (listReservas != null) {
					for (Reserva r : listReservas) {
						System.out.println(r);
					}
				} else {
					System.err.println("No hay reservas para consultar");
				}
			}
			case 0 -> {
				System.out.println("Saliendo del menú de destinos...");
			}
			default -> {
				System.err.println("La opción introducida no es válida");
			}
			}
		} while (opcion != 0);
	}
}
