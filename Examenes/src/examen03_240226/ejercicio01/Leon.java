package examen03_240226.ejercicio01;

public class Leon extends Animal implements Depredador {

	public Leon(String nombre, int energia) {
		super(nombre, energia);
	}

	public Leon(String nombre) {
		super(nombre);
	}

	public Leon() {
	}

	@Override
	public boolean cazar(Animal presa) {
		boolean cazado = false;
		if (presa instanceof Presa && this.energia >= presa.energia) { // Lo ideal aquí es que energía de Animal sea
																		// protected, y llamarla como presa.energia en
																		// lugar de presa.getEnergia(). Ya en el main,
																		// sí que llamaríamos como animal.getEnergia()
			cazado = true;
			this.comer(presa.energia); // Si no ponemos el this, al no haber ambigüedad, se entiende que llama al
										// método comer de esta clase (Leon). Pero si lo ponemos, pues queda más claro
										// aún
		} else {
			this.energia = (this.energia /= 2) < 1 ? 1 : (this.energia /= 2); // La energía la pierde tanto si no ha
																				// logrado cazar a la presa, como si se
																				// ha enfrentado a un animal que no es
																				// Presa
			if (presa instanceof Presa) { // Importante, pues si no ha entrado en el primer if, no sabemos qué condición
											// ha sido la falsa, y tenemos que comprobar que esto sea cierto

				((Presa) presa).huir(); // Lo ideal es meter el método de huir() de Presa aquí. Aunque la JVM no
										// necesita el casting a Presa porque en tiempo de ejecución, va a mirar cómo
										// está instanciado el Animal (que deberá ser Presa porque lo restringimos en el
										// if), el compilador nos obliga a hacer el casting a Presa, pues Animal no
										// tiene un método huir()
			}
		}
		return cazado;
	}

	@Override
	public void comer(int cantidad) {
		if (this.energia + cantidad > 100) {
			this.energia = 100;
		} else {
			this.energia += cantidad;
		}

	}

}
