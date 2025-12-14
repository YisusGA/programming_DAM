package ejercicio14OK;

public class Punto {
	
	double x; //Coordenada x de un punto en el espacio
	double y; //Coordenada y de un punto en el espacio
	
	//Método constructor
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Calcular la distancia entre dos puntos
	 * @param Una instancia de la clase Punto
	 * @return La distancia entre el punto de la clase y el punto instanciado en este método
	 */
	public double distancia(Punto p) {
		return Math.sqrt(Math.pow (x - p.x, 2) + Math.pow(y - p.y, 2));
	}
	
	

}
