package ejercicios.herencia.empleado.empleados;

public class EmpleadoTemporal extends Empleado {
	private String fechaFinContrato;

	public EmpleadoTemporal(String nombre, double salario, String fecha, String fechaFinContrato) {
		super(nombre, salario, fecha);
		this.fechaFinContrato = fechaFinContrato;
	}

	public EmpleadoTemporal(String nombre, double salario, String fecha) {
		super(nombre, salario, fecha);
	}

	public EmpleadoTemporal() {
	}

	public String getFechaFinContrato() {
		return fechaFinContrato;
	}

	public void setFechaFinContrato(String fechaFinContrato) {
		this.fechaFinContrato = fechaFinContrato;
	}

}
