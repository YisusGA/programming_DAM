package ejercicios.herencia.geometria.datos;

import ejercicios.herencia.geometria.figuras.Circulo;
import ejercicios.herencia.geometria.figuras.FiguraGeometrica;

public class ManejadorCirculos extends ManejadorFiguras {

	public ManejadorCirculos(FiguraGeometrica[] figuras) {
		super(figuras);
	}

	public ManejadorCirculos() {

	}

	@Override
	public double getAreaTotalFiguras() {
		double area = 0;
		for (int i = 0; i < figuras.length; i++) {
			if (figuras[i] instanceof Circulo) {
				area += figuras[i].getArea();
			}

		}
		return area;
	}

}
