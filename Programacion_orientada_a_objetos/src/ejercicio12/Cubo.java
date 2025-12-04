package ejercicio12;

class Cubo {
	double lado; //lado del cubo

	// Métodos

	// Calcular superficie
	double superficie() {
		double result = 6 * Math.pow(lado, 2);
		return result;
	}

	// Calcular área
	double volumen() {
		double result = Math.pow(lado, 3);
		return result;
	}
}
