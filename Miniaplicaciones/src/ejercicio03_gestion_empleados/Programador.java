package ejercicio03_gestion_empleados;

public class Programador extends Empleado {
	private String lenguajePrincipal;
	private Double plusLenguaje;

	public Programador(String nombre, Double salarioBase, String lenguajePrincipal, double plusLenguaje,
			TipoEmpleado tipo) {
		super(nombre, salarioBase, tipo);
		this.lenguajePrincipal = lenguajePrincipal;
		this.plusLenguaje = plusLenguaje;
	}

	public Programador(String nombre, Double salarioBase, TipoEmpleado tipo) {
		super(nombre, salarioBase, tipo);
	}

	public Programador() {

	}

	public String getLenguajePrincipal() {
		return lenguajePrincipal;
	}

	public void setLenguajePrincipal(String lenguajePrincipal) {
		this.lenguajePrincipal = lenguajePrincipal;
	}

	public Double getPlusLenguaje() {
		return plusLenguaje;
	}

	public void setPlusLenguaje(double plusLenguaje) {
		this.plusLenguaje = plusLenguaje;
	}

	@Override
	public String toString() {
		return "Programador [nombre=" + nombre + ", salarioBase=" + salarioBase + ", tipo=" + tipo
				+ ", lenguajePrincipal=" + lenguajePrincipal + ", plusLenguaje=" + plusLenguaje + "]";
	}

	@Override
	public double calcularSalario() {
		return salarioBase + plusLenguaje;
	}

}
