package ejercicios.herencia.geometria.figuras;

public class Circulo extends FiguraGeometrica {
	private double radio;

	public Circulo(String nombre, double radio) {
		super(nombre, 0); // Número de lados es 0 en un círculo
		this.radio = radio;
	}

	public Circulo(double radio) {
		this.radio = radio;
	}

	public Circulo() {

	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	@Override
	public double getPerimetro() {
		return 2 * this.radio * Math.PI;
	}

	@Override
	public double getArea() {
		return Math.pow(radio, 2) * Math.PI;
	}

	@Override
	public String toString() {
		return "Circulo [radio=" + radio + ", getPerimetro()=" + getPerimetro() + ", getArea()=" + getArea() + "]";
	}

}
