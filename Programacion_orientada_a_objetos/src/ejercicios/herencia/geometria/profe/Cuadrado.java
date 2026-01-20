package ejercicios.herencia.geometria.profe;

public class Cuadrado extends FiguraGeometrica{
	
	private double lado;

	public Cuadrado(String nombre, double lado) {
		super(nombre);
		this.lado = lado;
	}

	public Cuadrado(String nombre, int numLados) {
		super(nombre);
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	@Override
	public String toString() {
		return "Cuadrado [lado=" + lado + ", nombre=" + nombre +  "]";
	}

	@Override
	public double calculaPerimetro() {
		
		return 4*lado;
	}

	@Override
	public double calculaArea() {
		
		return lado*lado;
	}
	
	

}
