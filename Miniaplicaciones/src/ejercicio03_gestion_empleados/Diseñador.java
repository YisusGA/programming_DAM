package ejercicio03_gestion_empleados;

public class Diseñador extends Empleado {
	private String herramientaDiseño;
	private Double plusCreativo;

	public Diseñador(String nombre, Double salarioBase, String herramientaDiseño, Double plusCreativo) {
		super(nombre, salarioBase);
		this.herramientaDiseño = herramientaDiseño;
		this.plusCreativo = plusCreativo;
	}

	public Diseñador(String nombre, Double salarioBase) {
		super(nombre, salarioBase);
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
	public double calcularSalario() {
		return salarioBase + plusCreativo;
	}

}
