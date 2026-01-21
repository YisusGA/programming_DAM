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

	public void mostrarEmpleados() {
		for (int i = 0; i < empleados.length; i++) {
			System.out.println(empleados[i].mostrarDatos());
		}
	}

	public double calcularGastoTotal() {
		double gasto = 0;
		for (int i = 0; i < empleados.length; i++) {
			gasto += empleados[i].getSalario();
		}
		return gasto;

	}

}
