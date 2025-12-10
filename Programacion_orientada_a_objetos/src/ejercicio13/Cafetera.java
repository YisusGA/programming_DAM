package ejercicio13;

import java.util.Scanner;

class Cafetera {
	int capacidadMaxima; //Capacidad máxima de la cafetera, en ml
	int cantidadActual; //La cantidad de café que tiene la cafetera en cada momento, medida en ml
	
	//MÉTODO CONSTRUCTOR: es un método que se ejecuta una única vez, cuando se instancia el objeto
	//Debe llamarse obligatoriamente igual que la clase (mayúsculas y minúsculas incluidas).
	//Nunca devuelve nada. Así que ni siquiera hay que poner el void (de hecho, si ponemos void, está mal)
	Cafetera(int capacidadMaxima, int cantidadActual) {
		this.capacidadMaxima = capacidadMaxima; //Acordarse de que el this. hace que se refiere a la variable que hemos declarado al principio de esta clase.
	                                            //No poner this. hace que se refiera a la variable local del método (la que va entre paréntesis).
		this.cantidadActual = cantidadActual;
	}
	
	//Métodos
	
	/*
	 * Para actualizar el valor de una variable, no hace falta que el método haga un return del valor de esa variable. Al hacer una asignación (con una operación aritmética, por ejemplo),
	 * el valor de la variable ya va a quedar actualizado. Por lo tanto, si en un método sólo actualizamos el valor de una variable y no queremos que saque ningún dato al exterior, podemos
	 * hacer que el método sea void. En este caso, como lo que quiero hacer es mostrar un mensaje de la operación que se ha realizado, hago que el método devuelva un mensaje (String). La buena
	 * práctica es devolver un String, y no hacer un método void con prints desde el propio método. Porque así yo luego puedo decidir cómo mostrar ese String en el método main (por consola, por interfaz gráfica, etc.).
	 * En definitiva, hace que mi clase sea más universal y válida en muchos más contextos diferentes.
	 * Además, hay que considerar que si hago que mi método devuelva algo (un String en este caso), si hay ramas condicionales dentro del método, TODAS ELLAS deben devolver un String; de lo contrario,
	 * la JVM mostrará un error de compilación avisando de que es posible que la variable que devuelve el método podría no haberse inicializado.
	 */
	
	/**
	 * Llenar la cafetera al máximo. Se actualiza la cantidad de café en la cafetera
	 * @return Un mensaje sobre la operación que se ha realizado en función de la cantidad de café que tenía la cafetera
	 */
	String llenarCafetera() { //Es importante mencionar que para poder usar el valor actualizado de una propiedad (como cantidadActual) no es necesario hacer que el método haga un return de esa variable. Por lo tanto, si tan sólo
		                      //queremos actualizar el valor de una variable mediante una asignación con operadores, podemos hacer que el método sea void. En este caso concreto, queremos que muestre un mensaje con la operación que
		                      //se ha realizado, así que hacemos que el método devuelva un String. Aquí hay que destacar 2 cosas: lo primero, devolver un String en lugar de hacer un print por consola es una buena práctica, dado que nos permite
		                      //luego decidir cómo vamos a mostrar ese String en la clase main, sin necesidad de venir a modificar la clase; lo segundo, si queremos que el método devuelva un String, todas las ramas condicionales dentro del 
		                      //método deben devolver obligatoriamente un String, de lo contrario, la JVM nos mostrará error de compilación
		String mensaje;
		if (cantidadActual == capacidadMaxima) {
			mensaje = "La cafetera ya estaba llena, no se hará nada";
		} else {
			cantidadActual = capacidadMaxima;
			mensaje = "La cafetera se ha llenado";
		}
		return mensaje;
	}
	
	/**
	 * Servir un café llenando la taza. Se actualiza la cantidad de café en la cafetera
	 * @param La cantidad de café que servimos para llenar la taza
	 * @return Un mensaje sobre la operación que se ha realizado en función de la cantidad de café que tenía la cafetera 
	 */
	String servirTaza(int capacidadTaza) {
		String mensaje;
		if (cantidadActual == 0) {
			mensaje = "La cafetera está vacía, agregue café primero";
		} else if (cantidadActual < capacidadTaza) {
			mensaje = "No hay suficiente café para llenar la taza, te sirvo lo que hay";
			cantidadActual = 0;
		} else {
			cantidadActual -= capacidadTaza;
			mensaje = "La taza se ha servido satisfactoriamente";
		}
		return mensaje;
	}
	/**
	 * Vaciar la cafetera completamente. Se actualiza la cantidad de café en la cafetera
	 * @return Un mensaje sobre la operación que se ha realizado en función del estado de la cafetera
	 */
	String vaciarCafetera () {
		String mensaje;
		if (cantidadActual == 0) {
			mensaje = "La cafetera ya estaba vacía";
		} else {
			cantidadActual = 0;
			mensaje = "La cafetera se ha vaciado correctamente";
		}
		return mensaje;
	}
	
	/**
	 * Agregar una cantidad de café a la cafetera. Se actualiza la cantidad de café en la cafetera
	 * @param La cantidad de café que vamos a añadir a la cafetera
	 * @return Un mensaje sobre la operación que se ha realizado en función del estado de la cafetera
	 */
	String agregarCafe(int cantidadAgregada) {
		String mensaje;
		if ((cantidadActual + cantidadAgregada) <= capacidadMaxima) {
			cantidadActual += cantidadAgregada;
			mensaje = "Se ha agregado la cantidad de café solicitada";
		} else {
			mensaje = "La cantidad de café a agregar excede la capacidad máxima. Se rellenará hasta la capacidad máxima";
			cantidadActual = capacidadMaxima;
		}
		return mensaje;
	}
}
