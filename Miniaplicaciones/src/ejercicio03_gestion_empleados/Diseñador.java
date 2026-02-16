package ejercicio03_gestion_empleados;

public class Diseñador extends Empleado {
	private String herramientaDiseño;
	private Double plusCreativo;

	public Diseñador(String nombre, Double salarioBase, String herramientaDiseño, double plusCreativo,
			TipoEmpleado tipo) {
		super(nombre, salarioBase, tipo);
		this.herramientaDiseño = herramientaDiseño;
		this.plusCreativo = plusCreativo;
	}

	public Diseñador(String nombre, Double salarioBase, TipoEmpleado tipo) {
		super(nombre, salarioBase, tipo);
	}

	public Diseñador() {

	}

	public String getHerramientaDiseño() {
		return herramientaDiseño;
	}

	public void setHerramientaDiseño(String herramientaDiseño) {
		this.herramientaDiseño = herramientaDiseño;
	}

	public Double getPlusCreativo() {
		return plusCreativo;
	}

	public void setPlusCreativo(Double plusCreativo) {
		this.plusCreativo = plusCreativo;
	}

	@Override
	public String toString() {
		return "Diseñador [nombre=" + nombre + ", salarioBase=" + salarioBase + ", tipo=" + tipo
				+ ", herramientaDiseño=" + herramientaDiseño + ", plusCreativo=" + plusCreativo + "]";
	}

	@Override
	public double calcularSalario() {
		return salarioBase + plusCreativo;
	}

}
