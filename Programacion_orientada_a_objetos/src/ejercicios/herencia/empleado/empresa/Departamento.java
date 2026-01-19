package ejercicios.herencia.empleado.empresa;

import ejercicios.herencia.empleado.empleados.Empleado;

public class Departamento {
	private String nombre;
	private Empleado[] empleados;

	// ¿Por qué no se puede hacer esto?
	// Porque es una sentencia de código, y una sentencia de código no puede estar
	// fuera de un método.
	// empleados = new Empleado[1];

	// Pero sí que puede hacerse esto, porque es una incialización de una propiedad
	// private Empleado[] empleados = new Empleado[1];

	public Departamento(String nombre) {
		this.nombre = nombre;
	}

	public Departamento() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void addEmpleado(Empleado e) {
		if (empleados == null) {
			empleados = new Empleado[1];
			empleados[0] = e;
		} else {
			Empleado[] aux = new Empleado[empleados.length + 1];
			for (int i = 0; i < empleados.length; i++) {
				aux[i] = empleados[i];
			}
			aux[aux.length - 1] = e;
			empleados = aux;
		}
	}

	public double getSalarioDepartamento() {
		double salario = 0;
		if (empleados != null) {
			for (int i = 0; i < empleados.length; i++) {
				salario += empleados[i].getSalario();
			}
		}
		return salario;
	}

}
