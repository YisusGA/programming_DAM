package ejercicio03_gestion_empleados;

import java.util.ArrayList;
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
		// ToDo
		if (empleados != null && empleados.size() > 0) {
			for (int i = 0; i < empleados.size(); i++) {
				if (empleados[i].getNombre.equals(nombre)) {
					return empleados.get(i);
				}
			}
			return null;
		}

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

	public static boolean eliminarEmpleado(Empleado empleado) {
		boolean eliminado = false;
		if (empleados != null && empleados.size() > 0) {
			eliminado = empleados.remove(empleado);
		}
		return eliminado;
	}

}
