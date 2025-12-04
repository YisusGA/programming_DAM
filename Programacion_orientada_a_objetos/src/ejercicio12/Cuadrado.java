package ejercicio12;

class Cuadrado {
	double lado; //lado del cuadrado

	// Métodos

	// Calcular perímetro
	double perimetro() {
		double result = 4 * lado;
		return result;
	}

	// Calcular área
	double area() {
		double result = Math.pow(lado, 2);
		return result;
	}
}
