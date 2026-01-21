package main;

import hospital.Hospital;
import hospital.TipoEmpleado;
import teclado.Teclado2;

public class Main {

	public static void main(String[] args) {
		Hospital hospital = new Hospital();
		
		int opcion;
		
		do {
			opcion = mostrarMenu();
			
			switch (opcion) {
			case 1 -> {
				
			}
			case 2 -> {
				hospital.mostrarEmpleados();
			}
			case 3 -> {
				hospital.calcularGastoTotal();
			}
			case 0 -> {
				System.out.println("Finalizando programa...");
			}
			default -> {
				System.err.println("Opción no válida");
			}
			}
		} while (opcion != 0);

	}
	
	public static int mostrarMenu() {
		System.out.println("""
				Bienvenido  Yisus Hospital
				¿Qué quieres hacer?
				1. Añadir empleado
				2. Mostrar datos de todos los empleados
				3. Calcular gasto total del hospital
				0. Salir del programa
				""");
		return Teclado2.leerEntero();
	}

}
