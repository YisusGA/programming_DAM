package empleados;

public class Administrativo extends Empleado {
	private double horasExtra;

	@Override
	public double calcularSalario() {
		double salario = 0;
		if (this.horasExtra > 0) {
			salario += this.horasExtra * 15;
		}
		return salario;
	}

	@Override
	public String mostrarDatos() {
		return "Empleado [nombre=" + nombre + ", dni=" + dni + ", salario=" + salario + ", horas extra" + horasExtra
				+ "]";
	}

}
