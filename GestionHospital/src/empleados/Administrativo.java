package empleados;

public class Administrativo extends Empleado {
	private double horasExtra;

	public Administrativo(String nombre, String dni, double salario, double horasExtra) {
		super(nombre, dni, salario);
		this.horasExtra = horasExtra;
	}

	public Administrativo() {

	}

	@Override
	public double calcularSalario() {
		double salario = this.salario;
		if (this.horasExtra > 0) {
			salario += this.horasExtra * 15;
		}
		return salario;
	}

	@Override
	public String mostrarDatos() {
		return "Empleado [nombre=" + nombre + ", dni=" + dni + ", salario base=" + salario + ", horas extra=" + horasExtra
				+ "]";
	}

}
