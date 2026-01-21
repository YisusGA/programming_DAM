package hospital;

import empleados.Empleado;

public class Hospital {
	private Empleado[] empleados = new Empleado[0];

	public Hospital(Empleado[] empleados) {
		this.empleados = empleados;
	}

	public Hospital() {
	}

	public String agregarEmpleado(Empleado e) {
		Empleado[] aux = new Empleado[empleados.length + 1];
		for (int i = 0; i < empleados.length; i++) {
			aux[i] = empleados[i];
		}
		aux[aux.length - 1] = e;
		empleados = aux;
		return "Empleado agregado correctamente";
	}

	public boolean hayEmpleados() {
		if (empleados.length > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void mostrarEmpleados() {
		for (int i = 0; i < empleados.length; i++) {
			System.out.println(empleados[i].mostrarDatos());
		}
	}

	public String calcularGastoTotal() {
		double gasto = 0;
		for (int i = 0; i < empleados.length; i++) {
			gasto += empleados[i].calcularSalario();
		}
		return "EL gasto total de empleados en el hospital es: " + gasto;

	}

}
