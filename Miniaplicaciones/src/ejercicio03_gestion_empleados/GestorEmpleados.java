package ejercicio03_gestion_empleados;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GestorEmpleados {
	static List<Empleado> empleados = new ArrayList<>();

	public static String addEmpleado(String nombre, double salarioBase, String distintivo, double plus,
			TipoEmpleado tipo) {
		Empleado empleado = null;
		switch (tipo) {
		case PROGRAMADOR -> {
			empleado = new Programador(nombre, salarioBase, distintivo, plus, tipo);
		}
		case DISEÑADOR -> {
			empleado = new Diseñador(nombre, salarioBase, distintivo, plus, tipo);
		}
		}
		empleados.add(empleado);
		return "Empleado añadido correctamente";
	}

	public static List<Empleado> mostrarEmpleados() {
		if (empleados != null && empleados.size() > 0) {
			return empleados;
		}
		return null;
	}

	public static Empleado devolverEmpleado(String nombre) {
		boolean encontrado = false;
		if (empleados != null && empleados.size() > 0) {
			Iterator<Empleado> iterador = empleados.iterator();
			while (!encontrado && iterador.hasNext()) {
				Empleado e = iterador.next();
				if (e.getNombre().equalsIgnoreCase(nombre)) {
					return e;
				}
			}
		}
		return null;

	}

	public static double calcularSalarios() {
		double salarios = 0;
		if (empleados != null && empleados.size() > 0) {
			for (Empleado i : empleados) {
				salarios += i.calcularSalario();
			}
		}
		return salarios;
	}

	public static boolean eliminarEmpleado(String nombre) {
		boolean eliminado = false;
		if (empleados != null && empleados.size() > 0) {
			Iterator<Empleado> iterador = empleados.iterator();
			while (!eliminado && iterador.hasNext()) {
				Empleado e = iterador.next();
				if (e.getNombre().equalsIgnoreCase(nombre)) {
					iterador.remove();
					eliminado = true;
				}
			}
		}
		return eliminado;
	}

}
