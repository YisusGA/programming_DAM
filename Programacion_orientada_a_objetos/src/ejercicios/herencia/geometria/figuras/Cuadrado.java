package ejercicios.herencia.geometria.figuras;

public class Cuadrado extends FiguraGeometrica {
	private double lado;

	public Cuadrado(String nombre, int numeroLados, double lado) {
		super(nombre, numeroLados);
		this.lado = lado;
	}

	public Cuadrado(double lado) {
		this.lado = lado;
	}

	public Cuadrado() {

	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
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
