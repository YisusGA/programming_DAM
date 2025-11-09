package ejercicios_sentencia_de_decision;

/**
 * Ejemplo práctico de lo que sucede cuando se usa o no el System.exit en una secuencia de condicionales if
 */

public class Ejemplo_Representativo_SystemExit {

	public static void main(String[] args) {
		/*
		 * Inicializamos las 2 variables con las que vamos a trabajar, para que no nos de problemas la VM
		 */
		int n1 = 1;
		int n2 = 2;
		
		/*
		 * Cuando no usamos System.exit, el valor es el de la última asignación, pues evalúa la primera condición, que es verdadera en este caso, y realiza la asignación de 10 a n1.
		 * Luego evalúa la segunda condición, que también es verdadera, y le asigna el valor 4 a n1. El valor que se imprime por tanto al imprimir n1 es 4.
		 */
		if (10 % 2 == 0) {
			n1 = 10;
		}
		if (4 % 2 == 0) {
			n1 = 4;
		}
		System.out.println("Valor de n1: " + n1);
	
		/*
		 * Cuando usamos System.exit, el valor es el de la primera asignación, pues evalúa la primera condición, que es verdadera en este caso, y realiza la asignación de 10 a n1.
		 * No hay evaluación de la segunda condición, pues el programa finaliza al cumplirse la primera condición y llegar al System.exit que está contenido dentro de ese if. 
		 * Fijarse que si comentamos el primer System.out.println que hay bajo estas líneas, quedando activo el segundo System.out.println, nunca se va a imprimir en la consola el 
		 * valor de n2, pues el programa finaliza en cuanto se cumple la primera condición y llega al System.exit contenido dentro de ese if.
		 */
		if (10 % 2 == 0) {
		n2 = 10;
		System.out.println("Valor de n2: " + n2);
		System.exit(0);
		}
		if (4 % 2 == 0) {
		n2 = 4;
		System.exit(0);
		}
		System.out.println("Valor de n2: " + n2);
		
	}
}	
