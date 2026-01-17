package ejercicios.herencia.empleado.empleados;

public class Gerente extends Empleado {

	private double bonus;

	

	public Gerente(String nombre, double salario, String fecha, double bonus) {
		super(nombre, salario, fecha);
		this.bonus = bonus;
	}

	public Gerente(String nombre, double salario, String fecha) {
		super(nombre, salario, fecha);
	}

	public Gerente() {
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

}
