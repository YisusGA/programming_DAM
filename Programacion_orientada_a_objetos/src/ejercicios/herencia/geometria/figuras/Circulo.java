package ejercicios.herencia.geometria.figuras;

public class Circulo extends FiguraGeometrica {
	private double radio;

	public Circulo(String nombre, int numeroLados, double radio) {
		super(nombre, numeroLados);
		this.radio = radio;
	}

	public Circulo() {

	}

	@Override
	public double getPerimetro() {
		return 2 * this.radio * Math.PI;
	}
	
	@Override
	public double getArea() {
		return Math.pow(radio, 2) * Math.PI;
	}

}
