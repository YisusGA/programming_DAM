package ejercicios.herencia.geometria.profe;

public class Triangulo extends FiguraGeometrica{

	private double lado1, lado2, lado3;
	
	public Triangulo(String nombre, double lado1, double lado2, double lado3) {
		super(nombre);
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
	}
	
	public Triangulo() {
		super();
	}

	public double getLado1() {
		return lado1;
	}

	public double getLado2() {
		return lado2;
	}

	public double getLado3() {
		return lado3;
	}

	public void setLado1(double lado1) {
		this.lado1 = lado1;
	}

	public void setLado2(double lado2) {
		this.lado2 = lado2;
	}

	public void setLado3(double lado3) {
		this.lado3 = lado3;
	}

	@Override
	public String toString() {
		return "Triangulo [lado1=" + lado1 + ", lado2=" + lado2 + ", lado3=" + lado3 + ", nombre=" + nombre
				+  "]";
	}

	@Override
	public double calculaPerimetro() {
		
		return lado1+lado2+lado3;
	}

	@Override
	public double calculaArea() {
		
		// Semiperímetro
        double s = (lado1 + lado2 + lado3) / 2.0;

        // Fórmula de Herón
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
        
	}
	
	
}
