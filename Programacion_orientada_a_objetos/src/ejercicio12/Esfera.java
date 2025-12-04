package ejercicio12;

class Esfera {
	double radio; // radio de la esfera

	// Métodos

	// Calcular superficie
	double superficie() {
		double result = 4 * Math.PI * Math.pow(radio, 2);
		return result;
	}

	// Calcular volumen
	double volumen() {
		double result = 4.0 / 3.0 * Math.PI * Math.pow(radio, 3);
		return result;
	}
}
