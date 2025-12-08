package ejercicio13;

import java.util.Scanner;

class Cafetera {
	int capacidadMaxima; //Capacidad máxima de la cafetera, en ml
	int cantidadActual; //La cantidad de café que tiene la cafetera en cada momento, medida en ml
	
	//MÉTODO CONSTRUCTOR: es un método que se ejecuta una única vez, cuando se instancia el objeto
	//Debe llamarse obligatoriamente igual que la clase (mayúsculas y minúsculas incluidas).
	//Nunca devuelve nada. Así que ni siquiera hay que poner el void (de hecho, si ponemos void, está mal)
	Cafetera(Scanner scan) { //Lo ideal es instanciar la clase Scanner en el método main, y cerrarla al terminar el método main. El método constructor va a funcionar si ponemos como parámetro
							//Scanner scan entre los paréntesis, pues usará la clase Scanner que instanciemos en la clase main. Esto hace que cuando se instancie la clase Cafetera en el método main,
							//tengamos que poner scan (o el nombre de la instancia que creemos para la clase Scanner) entre los paréntesis (ver línea 9 de la clase Principal de este package) 
		System.out.println("¿Cuál es la capacidad de la cafetera?");
		while ((capacidadMaxima = scan.nextInt()) <= 0) {
			System.err.println("El valor introducido debe ser mayor que 0");
			System.out.println("Prueba de nuevo");
		}
		System.out.println("¿Qué cantidad de café tiene actualmente la cafetera?");
		while ((cantidadActual = scan.nextInt()) < 0) {
			System.err.println("El valor introducido debe ser mayor o igual que 0");
			System.out.println("Prueba de nuevo");
		}
	}
	//Otra versión de hacer un constructor
//	Cafetera(int capacidadMaxima, int cantidadActual) {
//		this.capacidadMaxima = capacidadMaxima; //Acordarse de que el this. hace que se refiere a la variable que hemos declarado al principio de esta clase.
//	                                            //No poner this. hace que se refiera a la variable local del método (la que va entre paréntesis).
//		this.cantidadActual = cantidadActual;
//	}
	
	//Métodos
	
	/**
	 * Llenar la cafetera al máximo
	 * @return La cantidad de café que tiene la cafetera después de llenarla al máximo
	 */
	int llenarCafetera() {
		if (cantidadActual == capacidadMaxima) {
			System.err.println("La cafetera ya está llena");
		} else {
		cantidadActual = capacidadMaxima;
		}
		return cantidadActual;
	}
	
	/**
	 * Servir un café llenando la taza
	 * @param La cantidad de café que servimos para llenar la taza
	 * @return La cantidad de café que queda en la cafetera
	 */
	int servirTaza(int capacidadTaza) {
		if (cantidadActual == 0) {
			System.err.println("La cafetera está vacía, agregue café primero");
		} else if (cantidadActual < capacidadTaza) {
			System.err.println("No hay suficiente café para llenar la taza, te sirvo lo que hay");
			cantidadActual = 0;
		} else {
			cantidadActual -= capacidadTaza;
		}
		return cantidadActual;
	}
	/**
	 * Vaciar la cafetera completamente
	 * @return La cantidad de café de la cafetera se queda en 0 (vacía)
	 */
	int vaciarCafetera () {
		if (cantidadActual == 0) {
			System.err.println("La cafetera ya está vacía");
		} else {
			cantidadActual = 0;
		}
		return cantidadActual;
	}
	
	/**
	 * Agregar una cantidad de café a la cafetera
	 * @param La cantidad de café que vamos a añadir a la cafetera
	 * @return La cantidad de café en la cafetera después de añadir café
	 */
	int agregarCafe(int cantidadAgregada) {
		if ((cantidadActual + cantidadAgregada) <= capacidadMaxima) {
			cantidadActual += cantidadAgregada;
		} else {
			System.err.println("La cantidad de café a agregar excede la capacidad máxima. Se rellenará hasta la capacidad máxima");
			cantidadActual = capacidadMaxima;
		}
		return cantidadActual;
	}
}
