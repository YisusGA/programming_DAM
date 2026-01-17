package ejercicios.herencia.empleado.empleados;

public class Empleado {

	protected String nombre;
	protected double salario;
	protected String fechaInicioContrato;

	public Empleado(String nombre, double salario, String fecha) {
		this.nombre = nombre;
		this.salario = salario;
		this.fechaInicioContrato = fecha;
	}

	public Empleado() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getFecha() {
		return fechaInicioContrato;
	}

	public void setFecha(String fecha) {
		this.fechaInicioContrato = fecha;
	}

}
