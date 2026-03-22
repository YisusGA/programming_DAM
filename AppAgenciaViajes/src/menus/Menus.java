package menus;

import java.io.IOException;
import java.util.List;

import dao.DestinoDAO;
import modelo.Destino;
import teclado.TecladoOK;

public class Menus {
	
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
				Bienvenido a la Agencia de Viajes YisusTravels S.L.
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
	
	public static void gestionGeneral() {
		int opcion;

		do {
			opcion = mostrarMenuGeneral();

			switch (opcion) {
			case 1 -> {
				gestionDestinos();
			}
			case 2 -> {
//				gestionReservas();
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
					if (DestinoDAO.insert(new Destino(nombre, precio))) {
						System.out.println("Destino añadido");
					} else {
						System.err.println("El destino no pudo añadirse");
					}
				} catch (ClassNotFoundException | IOException e) {
					System.err.println("El destino no pudo añadirse");
					e.printStackTrace();
				}
			}
			case 2 -> {
				System.out.println("Introduce el nombre del destino");
				String nombre = TecladoOK.leerCadena();
				try {
					Destino d = DestinoDAO.get(nombre);
					if (d != null) {
						System.out.println("Datos del destino solicitado: " + d);
					} else {
						System.err.println("No se pudo recuperar el destino");
					}
				} catch (ClassNotFoundException | IOException e) {
					System.err.println("No se pudo recuperar el destino");
					e.printStackTrace();
				}
			}
			case 3 -> {
				System.out.println("Introduce el nombre del destino");
				String nombre = TecladoOK.leerCadena();
				try {
					if (DestinoDAO.delete(nombre)) {
						System.out.println("Destino eliminado correctamente");
					} else {
						System.err.println("No se pudo eliminar el destino");
					}
				} catch (ClassNotFoundException | IOException e) {
					System.err.println("No se pudo eliminar el destino");
					e.printStackTrace();
				}
			}
			case 4 -> {
				System.out.println("Introduce el nombre del destino a modificar");
				String nombreOld = TecladoOK.leerCadena();
				System.out.println("Introduce el nuevo nombre del destino");
				String nombreNew = TecladoOK.leerCadena();
				System.out.println("Introduce el nuevo precio del destino");
				double precio = TecladoOK.leerDecimal();
				try {
					if (DestinoDAO.update(nombreOld, new Destino(nombreNew, precio))) {
						System.out.println("Destino actualizado");
					} else {
						System.err.println("No se pudo actualizar el destino");
					}
				} catch (ClassNotFoundException | IOException e) {
					System.err.println("No se pudo actualizar el destino");
					e.printStackTrace();
				}
			}
			case 5 -> {
				try {
					List<Destino> destinos = DestinoDAO.listarDestinos();
					if(destinos != null) {
						for(Destino d : destinos) {
							System.out.println(d);
						}
					} else {
						System.err.println("No hay destinos añadidos");
					}
				} catch (ClassNotFoundException | IOException e) {
					System.err.println("No se pudieron recuperar los destinos");
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

}
