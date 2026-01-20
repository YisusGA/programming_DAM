package ejercicios.herencia.geometria.figuras;

public class Triangulo extends FiguraGeometrica {
	private double lado1;
	private double lado2;
	private double lado3;

	public Triangulo(String nombre, int numeroLados, double lado1, double lado2, double lado3) {
		super(nombre, numeroLados);
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
	}

	public Triangulo(double lado1, double lado2, double lado3) {
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
	}

	public Triangulo() {
	}

	public double getLado1() {
		return lado1;
	}

	public void setLado1(double lado1) {
		this.lado1 = lado1;
	}

	public double getLado2() {
		return lado2;
	}

	public void setLado2(double lado2) {
		this.lado2 = lado2;
	}

	public double getLado3() {
		return lado3;
	}

	public void setLado3(double lado3) {
		this.lado3 = lado3;
	}

	public boolean esTriangulo() {
		if ((this.lado1 + this.lado2) > this.lado3 || (this.lado1 + this.lado3) > this.lado2
				|| (this.lado2 + this.lado3) > this.lado1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public double getPerimetro() {
		return lado1 + lado2 + lado3;
	}

	@Override
	public double getArea() {
		double semip = (this.lado1 + this.lado2 + this.lado3) / 2;
		double area = Math.sqrt(semip * (semip - lado1) * (semip - lado2) * (semip - lado3));
		return area;
	}

	@Override
	public String toString() {
		return "Triangulo [lado1=" + lado1 + ", lado2=" + lado2 + ", lado3=" + lado3 + ", getPerimetro()="
				+ getPerimetro() + ", getArea()=" + getArea() + "]";
	}

}
