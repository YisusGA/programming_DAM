package ejercicios.herencia.empleado.empresa;

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

	public double getSalarioEmpresa() {
		double salario = 0;
		if (departamentos == null) {
			return salario;
		} else {
			for (int i = 0; i < departamentos.length; i++) {
				salario += departamentos[i].getSalarioDepartamento();
			}
		}
		return salario;
	}

}
