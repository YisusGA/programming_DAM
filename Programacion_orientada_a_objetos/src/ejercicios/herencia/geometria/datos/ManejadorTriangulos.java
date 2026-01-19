package ejercicios.herencia.geometria.datos;

import ejercicios.herencia.geometria.figuras.FiguraGeometrica;
import ejercicios.herencia.geometria.figuras.Triangulo;

public class ManejadorTriangulos extends ManejadorFiguras {

	public ManejadorTriangulos(FiguraGeometrica[] figuras) {
		super(figuras);
	}

	public ManejadorTriangulos() {

	}

	@Override
	public double getAreaTotalFiguras() {
		double area = 0;
		for (int i = 0; i < figuras.length; i++) {
			if (figuras[i] instanceof Triangulo) {
				area += figuras[i].getArea();
			}

		}
		return area;
	}

}
