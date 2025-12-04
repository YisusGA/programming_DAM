package ejercicio12;

class Circulo {
	double radio; //radio del cículo

	// Métodos

	// Calcular perímetro
	double perimetro() {
		double result = 2 * Math.PI * radio;
		return result;
	}

	// Calcular área
	double area() {
		double result = Math.PI * Math.pow(radio, 2);
		return result;
	}
}
