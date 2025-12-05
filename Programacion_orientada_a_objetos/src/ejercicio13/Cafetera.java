package ejercicio13;

import java.util.Scanner;

class Cafetera {
	int capacidadMaxima; //Capacidad máxima de la cafetera, en ml
	int cantidadActual; //La cantidad de café que tiene la cafetera en cada momento, medida en ml
	
	//MÉTODO CONSTRUCTOR: es un método que se ejecuta una única vez, cuando se instancia el objeto
	//Debe llamarse obligatoriamente igual que la clase (mayúsculas y minúsculas incluidas)
	//Nunca devuelve nada. Así que ni siquiera hay que poner el void (de hecho, si ponemos void, está mal)
	Cafetera() {
		Scanner scan = new Scanner(System.in);
		System.out.println("¿Cuál es la capacidad de la cafetera?");
		while ((capacidadMaxima = scan.nextInt()) <= 0) {
			System.out.println("El valor introducido debe ser mayor que 0");
		}
		System.out.println("¿Qué cantidad de café tiene actualmente la cafetera?");
		while ((cantidadActual = scan.nextInt()) < 0) {
			System.out.println("El valor introducido debe ser mayor que 0");
		}
	}
	//Otra versión de hacer un constructor
//	Cafetera(int capacidadMaxima, int cantidadActual) {
//		
//	}
	
	//Métodos
	
	/**
	 * Llenar la cafetera al máximo
	 * @return La cantidad de café que tiene la cafetera después de llenarla al máximo
	 */
	int llenarCafetera() {
		if (cantidadActual == capacidadMaxima) {
			System.out.println("La cafetera ya está llena");
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
		if (cantidadActual < capacidadTaza) {
			System.out.println("No hay suficiente café para llenar la taza, te sirvo lo que hay");
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
			System.out.println("La cafetera ya está vacía");
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
		cantidadActual += cantidadAgregada;
		return cantidadActual;
	}
}
