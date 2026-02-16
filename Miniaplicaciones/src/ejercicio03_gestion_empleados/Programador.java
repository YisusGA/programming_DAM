package ejercicio03_gestion_empleados;

public class Programador extends Empleado {
	private String lenguajePrincipal; 
	private Double plusLenguaje;

	public Programador(String nombre, Double salarioBase, String lenguajePrincipal, double plusLenguaje) {
		super(nombre, salarioBase);
		this.lenguajePrincipal = lenguajePrincipal;
		this.plusLenguaje = plusLenguaje;
	}

	public Programador(String nombre, Double salarioBase) {
		super(nombre, salarioBase);
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
	public double calcularSalario() {
		return salarioBase + plusLenguaje;
	}

}
