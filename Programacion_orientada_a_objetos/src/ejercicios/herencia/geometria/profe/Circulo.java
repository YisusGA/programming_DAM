package ejercicios.herencia.geometria.profe;

public class Circulo extends FiguraGeometrica{

	private double radio;
	
	public Circulo(String nombre, double radio) {
		super(nombre);
		this.radio = radio;
	}
	
	public Circulo() {
		super();
		
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	@Override
	public String toString() {
		return "Circulo [radio=" + radio + ", nombre=" + nombre + "]";
	}

	@Override
	public double calculaPerimetro() {
		
		return 2*Math.PI*radio;
	}

	@Override
	public double calculaArea() {
		
		return Math.PI*radio*radio;
	}

	
	
	
	

}
