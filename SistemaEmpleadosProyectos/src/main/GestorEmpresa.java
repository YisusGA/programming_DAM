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

	private static Map<String, Map<Empleado, Integer>> horasPorProyecto;

	private static int numIteraciones = 3;

	public static void main(String[] args) {

		
		// Añadir empleados
		
		System.out.println("Añadir empleados");
		System.out.println("----------------");
		
		plantilla = new ArrayList<>();
		System.out.println("Datos del primer empleado");
		for (int i = 0; i < numIteraciones; i++) {
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

		// Registrar proyectos
		
		System.out.println("Registrar proyectos");
		System.out.println("-------------------");
		
		proyectos = new TreeSet<>();

		for (int i = 0; i < numIteraciones; i++) {
			System.out.println("Introduce código de proyecto");
			String codigo = TecladoOK.leerCadena();
			if (altaProyecto(proyectos, codigo)) {
				System.out.println("Proyecto creado correctamente");
			} else {
				System.err
						.println("Ese código de proyecto ya existe, no se añadió el proyecto. Prueba con otro código");
				i--;
			}
		}

		// Asignar proyectos a empleados
		
		System.out.println("Asignar proyectos a empleados");
		System.out.println("-----------------------------");
		
		asignaciones = new HashMap<>();

		for (int i = 0; i < numIteraciones; i++) {
			String codProy;
			do {
				System.out.println("¿Cuál es el código de proyecto al que quieres asignar un empleado? Debe existir");
				codProy = TecladoOK.leerCadena();
			} while (!proyectos.contains(codProy));
			System.out.println("¿Qué empleado quieres asignar al proyecto?");
			plantilla.stream().forEach(e -> System.out
					.println("Código de empleado: " + e.getId() + ", Nombre de empleado: " + e.getNombre()));
			Empleado emp;
			do {
				System.out.println("Introduce código de empleado");
				String codigo = TecladoOK.leerCadena();
				emp = buscarEmpleado(crearMapaEmpleados(plantilla), codigo);
				if (emp == null) {
					System.err.println("Código de empleado no válido, prueba de nuevo");
				}
			} while (emp == null);

			asignarEmpleadoAProyecto(asignaciones, codProy, emp);
		}

		// Mostrar empleados sobrecargados
		
		System.out.println("Empleados sobrecargados");
		System.out.println("-----------------------");
		empleadosSobrecargados(asignaciones).forEach(e -> System.out.println(e));
		
		// Registrar horas de un empleado en un proyecto
		
		System.out.println("Registrar horas de un empleado en un proyecto");
		System.out.println("---------------------------------------------");
		
		String codProy;
		do {
			System.out.println("¿Cuál es el código de proyecto en el que quieres registrar horas? Debe existir");
			codProy = TecladoOK.leerCadena();
		} while (!proyectos.contains(codProy));
		
		System.out.println("¿Para qué empleado quieres registrar horas?");
		plantilla.stream().forEach(e -> System.out
				.println("Código de empleado: " + e.getId() + ", Nombre de empleado: " + e.getNombre()));
		Empleado emp;
		do {
			System.out.println("Introduce código de empleado");
			String codigo = TecladoOK.leerCadena();
			emp = buscarEmpleado(crearMapaEmpleados(plantilla), codigo);
			if (emp == null) {
				System.err.println("Código de empleado no válido, prueba de nuevo");
			}
		} while (emp == null);
		
		System.out.println("¿Cuántas horas quieres registrar? Debe ser un número entero mayor que 0");
		int horas;
		do {
			horas = TecladoOK.leerEntero();
			if (horas <= 0) {
				System.err.println("El valor introducido no es válido");
			}
		} while (horas <= 0);
		
		registrarHoras(horasPorProyecto, codProy, emp, horas);
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

	public static Set<Empleado> empleadosSobrecargados(Map<String, Set<Empleado>> asignaciones) {
		Map<Empleado, Integer> conteoProyectos = new HashMap<>();
		for (Set<Empleado> empleadosEnProyecto : asignaciones.values()) {
			for (Empleado emp : empleadosEnProyecto) {
				conteoProyectos.put(emp, conteoProyectos.getOrDefault(emp, 0) + 1);
			}
		}
		Set<Empleado> sobrecargados = new HashSet<>();
		for (Map.Entry<Empleado, Integer> entryMapEmpleados : conteoProyectos.entrySet()) {
			if (entryMapEmpleados.getValue() >= 2) {
				sobrecargados.add(entryMapEmpleados.getKey());
			}
		}
		return sobrecargados;
	}

	public static void registrarHoras(Map<String, Map<Empleado, Integer>> horasPorProyecto, String codProy,
			Empleado emp, int horas) {
		horasPorProyecto.putIfAbsent(codProy, new HashMap<>()); // Si no hay mapa asociado a ese código de proyecto,
																// crea un mapa y se lo asigna
		
		Map<Empleado, Integer> registroEmpleados = horasPorProyecto.get(codProy); // Esto devuelve una referencia en
																					// memoria al mapa que ya vive
																					// dentro de horasPorProyecto
		
		registroEmpleados.put(emp, registroEmpleados.getOrDefault(emp, 0) + horas); // Por lo tanto, al actualizar el
																					// valor del mapa registroEmpleados,
																					// ya se está actualizando dentro
																					// del mapa horasPorProyecto
		
//        horasPorProyecto.put(codProy, registroEmpleados); // Y hacer esto, aunque no diera error, sería completamente redundante
	}

}
