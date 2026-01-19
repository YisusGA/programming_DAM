package ejercicios.herencia.geometria.figuras;

public class FiguraGeometrica {
	protected String nombre;
	protected int numeroLados;

	public FiguraGeometrica(String nombre, int numeroLados) {
		this.nombre = nombre;
		this.numeroLados = numeroLados;
	}

	public FiguraGeometrica() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroLados() {
		return numeroLados;
	}

	public void setNumeroLados(int numeroLados) {
		this.numeroLados = numeroLados;
	}
	
	public double getPerimetro() {
		return 0;
	}
	
	public double getArea () {
		return 0;
	}

}
