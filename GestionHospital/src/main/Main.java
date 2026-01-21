package main;

import empleados.Administrativo;
import empleados.Empleado;
import empleados.Enfermero;
import empleados.Medico;
import hospital.Hospital;
import hospital.TipoEmpleado;
import hospital.Turnos;
import teclado.Teclado2;

public class Main {

	public static void main(String[] args) {
		Hospital hospital = new Hospital();
		
		int opcion;
		
		do {
			opcion = mostrarMenu();
			
			switch (opcion) {
			case 1 -> {
				Empleado empleado = null;
				TipoEmpleado tipo;
				do {
					System.out.println("¿Qué tipo de empleado quieres añadir?");
					tipo = TipoEmpleado.leerTeclado();
				} while (tipo == null);
				
				System.out.println("¿Cuál es el nombre del empleado?");
				String nombre = Teclado2.leerCadena();
				System.out.println("¿Cuál es el dni del empleado?");
				String dni = Teclado2.leerCadena();
				System.out.println("¿Cuál es el salario base del empleado?");
				double salario = Teclado2.leerDecimal();
				switch (tipo) {
				case ENFERMERO -> {
					Turnos turno;
					do {
						System.out.println("¿Qué turno tiene este enfermero?");
						turno = Turnos.leerTeclado();
					} while (turno == null);
					empleado = new Enfermero(nombre, dni, salario, turno);
				}
				case MEDICO -> {
					System.out.println("¿Cuál es la especialidad del médico?");
					String especialidad = Teclado2.leerCadena();
					System.out.println("¿Cuántas guardias hace este médico?");
					int numeroGuardias = Teclado2.leerEntero();
					empleado = new Medico(nombre, dni, salario, especialidad, numeroGuardias);
				}
				case ADMINISTRATIVO -> {
					System.out.println("¿Cuántas horas extra hace este administrativo?");
					double horasExtra = Teclado2.leerDecimal();
					empleado = new Administrativo(nombre, dni, salario, horasExtra);
				}
				}
				System.out.println(hospital.agregarEmpleado(empleado));
			}
			case 2 -> {
				if (hospital.hayEmpleados()) {
					hospital.mostrarEmpleados();
				} else {
					System.err.println("No se han añadido aún empleados");
				}
				
			}
			case 3 -> {
				if (hospital.hayEmpleados()) {
					System.out.println(hospital.calcularGastoTotal());
				} else {
					System.err.println("No se han añadido aún empleados");
				}
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
