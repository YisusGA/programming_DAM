package ejercicios.herencia.geometria.profe;

public class ManejadorCuadrados extends ManejadorFiguras{

	public double areaTotal() {
		
		double suma = 0;
		for(FiguraGeometrica fig : figuras)
			suma += fig.calculaArea();
		return suma;
	}
}
