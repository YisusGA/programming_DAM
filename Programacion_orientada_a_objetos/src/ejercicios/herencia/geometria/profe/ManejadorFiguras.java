package ejercicios.herencia.geometria.profe;

public class ManejadorFiguras {
	
	protected FiguraGeometrica[] figuras 
		= new FiguraGeometrica[0];
	
	public FiguraGeometrica[] getFiguras() {
		return figuras;
	}



	public void setFiguras(FiguraGeometrica[] figuras) {
		this.figuras = figuras;
	}



	public double perimetroTotal() {
		
		double suma = 0;
		for(FiguraGeometrica fig : figuras)
			suma += fig.calculaPerimetro();
		return suma;
	}

}
