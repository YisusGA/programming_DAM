package ejercicios.herencia.empleado.empleados;

public class Empleado {

	protected String nombre;
	protected double salario;
	protected String fecha;

	public Empleado(String nombre, double salario, String fecha) {
		this.nombre = nombre;
		this.salario = salario;
		this.fecha = fecha;
	}

	public Empleado() {
	}
}
