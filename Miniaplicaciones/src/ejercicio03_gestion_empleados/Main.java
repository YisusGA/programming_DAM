package ejercicio03_gestion_empleados;

import java.util.ArrayList;
import java.util.List;

import teclado.TecladoOK;

public class Main {
	public static void main(String[] args) {
		int opcion;

		do {
			opcion = mostrarMenu();

			switch (opcion) {
			case 1 -> {
				System.out.println("Introduce el nombre del empleado");
				String nombre = TecladoOK.leerCadena();
				System.out.println("Introduce el salario base del emplelado");
				double salarioBase = TecladoOK.leerDecimal();
				TipoEmpleado tipo;
				do {
					System.out.println("Introduce un tipo de empleado válido: PROGRAMADOR o DISEÑADOR");
					tipo = TipoEmpleado.leerTeclado(TecladoOK.leerCadena());
				} while (tipo == null);
				System.out.println(
						"Introduce el lenguaje principal (si es programador) o la herramienta de diseño (si es diseñador)");
				String distintivo = TecladoOK.leerCadena();
				System.out.println("Introduce el plus que cobra el empleado");
				double plus = TecladoOK.leerDecimal();
				GestorEmpleados.addEmpleado(nombre, salarioBase, distintivo, plus, tipo);
			}
			case 2 -> {
				List<Empleado> lista = new ArrayList<>();
				if ((lista = GestorEmpleados.mostrarEmpleados()) != null) {
					System.out.println(lista);
				} else {
					System.err.println("No hay empleados registrados");
				}
			}
			case 3 -> {
				System.out.println(GestorEmpleados.calcularSalarios());
			}
			case 4 -> {
				System.out.println("Introduce el nombre del empleado a eliminar");
				if (GestorEmpleados.eliminarEmpleado(TecladoOK.leerCadena())) {
					System.out.println("Empleado eliminado correctamente");
				} else {
					System.err.println("El empleado no existe");
				}
			}
			case 0 -> {
				System.out.println("Saliendo del menú...");
			}
			default -> {
				System.err.println("La opción introducida no es válida");
			}
			}
		} while (opcion != 0);
	}

	public static int mostrarMenu() {
		System.out.println("""
				Bienvenido
				Escoge una opción
				1. Añadir empleado
				2. Mostrar empleados
				3. Calcular salarios
				4. Eliminar empleado
				0. Salir del menú
				""");
		return TecladoOK.leerEntero();
	}

}
