package ejercicios.herencia.empleado.empresa;

import ejercicios.herencia.empleado.empleados.Empleado;

public class Departamento {
	private String nombre;
	private Empleado[] empleados;

	// ¿Por qué no se puede hacer esto?
	// empleados = new Empleado[1];

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

	public String addEmpleado(Empleado e) {
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
		return "Empleado añadido correctamente";
	}

	public double getSalarioDepartamento() {
		double salario = 0;
		if (empleados == null) {
			return salario;
		} else {
			for (int i = 0; i < empleados.length; i++) {
				salario += empleados[i].getSalario();
			}
		}
		return salario;
	}

}
