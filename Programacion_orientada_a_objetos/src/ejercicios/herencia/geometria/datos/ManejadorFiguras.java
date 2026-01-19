package ejercicios.herencia.geometria.datos;

import ejercicios.herencia.geometria.figuras.FiguraGeometrica;

public class ManejadorFiguras {
	FiguraGeometrica[] figuras = new FiguraGeometrica[0];

	public double getPerimetroTotalFiguras() {
		double perimetro = 0;
		for (int i = 0; i < figuras.length; i++) {
			perimetro += figuras[i].getPerimetro();
		}
		return perimetro;
	}
	
	public double getAreaTotalFiguras() {
		double area = 0;
		for (int i = 0; i < figuras.length; i++) {
			area += figuras[i].getArea();
		}
		return area;
	}

}
