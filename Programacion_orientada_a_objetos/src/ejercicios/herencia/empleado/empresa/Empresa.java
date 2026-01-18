package ejercicios.herencia.empleado.empresa;

import ejercicios.herencia.empleado.empleados.Empleado;

public class Empresa {
	String nombre;
	Departamento[] departamentos;

	public Empresa(String nombre) {
		this.nombre = nombre;
	}

	public Empresa() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String addDepartamento(Departamento d) {
		if (departamentos == null) {
			departamentos = new Departamento[1];
			departamentos[0] = d;
		} else {
			Departamento[] aux = new Departamento[departamentos.length + 1];
			for (int i = 0; i < departamentos.length; i++) {
				aux[i] = departamentos[i];
			}
			aux[aux.length - 1] = d;
			departamentos = aux;
		}
		return "Departamento añadido correctamente";
	}

	public String addEmpleadoADepartamento(Empleado e, String nombre) {
		if (departamentos == null) {
			return "Aún no existe ningún departamento";
		} else {
			boolean encontrado = false;
			for (int i = 0; !encontrado && i < departamentos.length; i++) {
				if (departamentos[i].getNombre().equals(nombre)) {
					encontrado = true;
					departamentos[i].addEmpleado(e);

				}
			}
			if (encontrado) {
				return "Empleado añadido correctamente al departamento";
			} else {
				return "No se ha encontrado el departamento";
			}
		}
	}

	public double getSalarioEmpresa() {
		double salario = 0;
		if (departamentos != null) {
			for (int i = 0; i < departamentos.length; i++) {
				salario += departamentos[i].getSalarioDepartamento();
			}
		}
		return salario;
	}

	public String departamentoMayorGasto() {
		double maximo = 0;
		String departamento = "";
		if (departamentos != null) {
			for (int i = 0; i < departamentos.length; i++) {
				if (departamentos[i].getSalarioDepartamento() > maximo) {
					maximo = departamentos[i].getSalarioDepartamento();
					departamento = departamentos[i].getNombre();
				}
			}
			return "El departamento con mayor gasto es " + departamento + ", con un gasto de " + maximo + " €";
		} else {
			return "No se han añadido aún empleados ni departamentos";
		}
	}

}
