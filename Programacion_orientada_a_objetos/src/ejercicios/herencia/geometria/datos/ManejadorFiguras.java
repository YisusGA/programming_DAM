package ejercicios.herencia.geometria.datos;

import ejercicios.herencia.geometria.figuras.FiguraGeometrica;

public class ManejadorFiguras {
	protected FiguraGeometrica[] figuras = new FiguraGeometrica[0];

	public ManejadorFiguras(FiguraGeometrica[] figuras) {
		this.figuras = figuras;
	}

	public ManejadorFiguras() {

	}

	public FiguraGeometrica[] getFiguras() {
		return figuras;
	}

	public void setFiguras(FiguraGeometrica[] figuras) {
		this.figuras = figuras;
	}

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

	public String addFigura(FiguraGeometrica f) {
		FiguraGeometrica[] aux = new FiguraGeometrica[figuras.length + 1];
		for (int i = 0; i < figuras.length; i++) {
			aux[i] = figuras[i];
		}
		aux[aux.length - 1] = f;
		figuras = aux;
		return "Figura añadida correctamente";
	}

}
