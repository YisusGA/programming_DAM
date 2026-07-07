package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import model.Empleado;
import teclado.TecladoOK;

public class GestorEmpresa {

	private static List<Empleado> plantilla;

	private static Set<String> proyectos;

	private static Map<String, Set<Empleado>> asignaciones;

	public static void main(String[] args) {

		plantilla = new ArrayList<>();
		System.out.println("Datos del primer empleado");
		for (int i = 0; i < 5; i++) {
			System.out.println("¿Cuál es el nombre del empleado?");
			String nombre = TecladoOK.leerCadena();
			int nivel;
			do {
				System.out.println("¿Cuál es el nivel del empleado? Valores admitidos: 1 al 5");
				nivel = TecladoOK.leerEntero();
			} while (nivel < 1 || nivel > 5);

			double salario;
			do {
				System.out.println("¿Cuál es el salario del empleado? No se admiten valores negativos");
				salario = TecladoOK.leerDecimal();
			} while (salario < 0);

			if (plantilla.add(new Empleado(nombre, nivel, salario))) {
				System.out.println("Empleado añadido correctamente");
			} else {
				System.err.println("No se pudo añadir el empleado");
			}
			if (i < 4) {
				System.out.println("Datos del siguiente empleado");
			}
		}

		System.out.println("Tras añadir los empleados, hay un total de " + plantilla.size() + " empleados");
		double salarioMedio = plantilla.stream().mapToDouble(e -> e.getSalario()).average().orElse(0.0);
		System.out.printf("El salario medio de los empleados en plantilla es de %.2f\n", salarioMedio);

		proyectos = new TreeSet<>();

		int i = 0;
		while (i < 3) {
			System.out.println("Introduce código de proyecto");
			String codigo = TecladoOK.leerCadena();
			if (altaProyecto(proyectos, codigo)) {
				System.out.println("Proyecto creado correctamente");
				i++;
			} else {
				System.err
						.println("Ese código de proyecto ya existe, no se añadió el proyecto. Prueba con otro código");
			}
		}

		String codProy;
		do {
			System.out.println("¿Cuál es el código de proyecto al que quieres asignar un empleado? Debe existir");
			codProy = TecladoOK.leerCadena();
		} while (!proyectos.contains(codProy));
		System.out.println("¿Qué empleado quieres asignar al proyecto?");
		plantilla.stream().forEach(
				e -> System.out.println("Código de empleado: " + e.getId() + ", Nombre de empleado: " + e.getNombre()));
		Empleado emp;
		do {
			System.out.println("Introduce código de empleado");
			String codigo = TecladoOK.leerCadena();
			emp = buscarEmpleado(crearMapaEmpleados(plantilla), codigo);
			if (emp == null) {
				System.err.println("Código de empleado no válido, prueba de nuevo");
			}
		} while (emp == null);

		asignaciones = new HashMap<>();
		asignarEmpleadoAProyecto(asignaciones, codProy, emp);

	}

	public static boolean altaProyecto(Set<String> proyectos, String codigo) {
		boolean added = proyectos.add(codigo);
		return added;
	}

	public static Map<String, Empleado> crearMapaEmpleados(List<Empleado> empleados) {
		final Map<String, Empleado> mapaEmpleados = new TreeMap<>();
		if (empleados.size() > 0) {
			empleados.stream().forEach(e -> mapaEmpleados.put(e.getId(), e));
		}
		return mapaEmpleados;
	}

	public static Empleado buscarEmpleado(Map<String, Empleado> empleados, String codigo) {
		Empleado empleado = empleados.get(codigo);
		return empleado;
	}

	public static void asignarEmpleadoAProyecto(Map<String, Set<Empleado>> asignaciones, String codProy, Empleado e) {
		Set<Empleado> empleadosProyecto = asignaciones.get(codProy); // Devuelve un Set de empleados, o null si no
																		// existe el código de proyecto
		if (empleadosProyecto != null) {
			if (empleadosProyecto.add(e)) {
				asignaciones.replace(codProy, empleadosProyecto); // Sólo se reemplaza el Set si existe el código de //
																	// proyecto, si no, no hace nada
				System.out.println("Empleado asignado correctamente a proyecto");
			} else {
				System.out.println("Ese empleado ya estaba asignado a ese proyecto");
			}
		} else {
			empleadosProyecto = new HashSet<>();
			empleadosProyecto.add(e);
			asignaciones.put(codProy, empleadosProyecto);
			System.out.println("Empleado asignado correctamente a proyecto");
		}
	}

}
