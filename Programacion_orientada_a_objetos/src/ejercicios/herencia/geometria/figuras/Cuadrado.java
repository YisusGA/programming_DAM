package ejercicios.herencia.geometria.figuras;

public class Cuadrado extends FiguraGeometrica {
	private double lado;

	public Cuadrado(String nombre, int numeroLados, double lado) {
		super(nombre, numeroLados);
		this.lado = lado;
	}

	public Cuadrado() {

	}

	@Override
	public double getPerimetro() {
		return lado * 4;
	}
	
	@Override
	public double getArea() {
		return lado * lado;
	}
}
