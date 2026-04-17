package menus;

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
				6. Ver reserva más próxima a futuro
				7. Ver reservas asociadas a un cliente
				8. Eliminar reservas asociadas a un destino
				9. Aplicar descuento a un cliente
				0. Salir del menú
				""");
		return TecladoOK.leerEntero();
	}
}
