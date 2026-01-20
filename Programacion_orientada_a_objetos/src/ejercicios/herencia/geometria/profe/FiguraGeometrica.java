package ejercicios.herencia.geometria.profe;

public abstract class FiguraGeometrica {

	protected String nombre;
	
	
	public FiguraGeometrica(String nombre) {
		this.nombre = nombre;
		
	}
	
	public FiguraGeometrica() {
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	@Override
	public String toString() {
		return "FiguraGeometrica [nombre=" + nombre + "]";
	}
	
	public abstract double calculaPerimetro();
	
	public abstract double calculaArea();
	
	
}
