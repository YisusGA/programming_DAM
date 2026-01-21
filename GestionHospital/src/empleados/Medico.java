package empleados;

public class Medico extends Empleado {
	private String especialidad;
	private int numeroGuardias;

	public Medico(String nombre, String dni, double salario, String especialidad, int numeroGuardias) {
		super(nombre, dni, salario);
		this.especialidad = especialidad;
		this.numeroGuardias = numeroGuardias;
	}

	public Medico() {
	}

	@Override
	public double calcularSalario() {
		return this.salario + (this.numeroGuardias * 50);
	}

	@Override
	public String mostrarDatos() {
		return "Empleado [nombre=" + nombre + ", dni=" + dni + ", salario=" + salario + ", especialidad" + especialidad
				+ "número de guardias" + numeroGuardias + "]";
	}

}
