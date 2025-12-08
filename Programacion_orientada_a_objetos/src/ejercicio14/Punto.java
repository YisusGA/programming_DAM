package ejercicio14;

class Punto {
	double x1;
	double y1;
	
	/**
	 * 
	 * @param x2 La coordenada x de un segundo punto
	 * @param y2 La corrdenada y de un segundo punto
	 * @return La distancia entre el punto definido como parámetro de la clase Punto y el nuevo punto leído en el método
	 */
	double distancia(double x2, double y2) {
		double result = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
		x1 = x2; //Tras hacer el cálculo de la distancia, las nuevas coordenadas de partida serán las del segundo punto
		y1 = y2;
		return result;
	}
}
