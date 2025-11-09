package ejercicios_sentencia_de_decision;

import java.util.Scanner;

public class Ejercicio19 {
	
	/** 
	 * Recibe tres letras minúsculas y un número entero. Sustituye cada char 
	 * con el char en minúscula del alfabeto que se encuentra n posiciones 
	 * después(si acaba el alfabeto, empieza desde el principio)
	 */
	
	public static void main(String[] args) {
		//Declaramos y leemos los valores de las variables de entrada
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce una letra minúscula");
		char c1 = scan.nextLine().charAt(0);
		System.out.println("Introduce otra letra minúscula");
		char c2 = scan.nextLine().charAt(0);
		System.out.println("Introduce una tercera letra minúscula");
		char c3 = scan.nextLine().charAt(0);
		int n = 1;
		System.out.println("Introduce un número entero positivo");
		//Compruebo que n sea un número int válido, y limito su tamaño, para que no se salga del rango de un int y así no se convierta en negativo al operar con él
		if (scan.hasNextInt()) {
			n = scan.nextInt();
		    if (n > Integer.MAX_VALUE - 122) {
		        System.err.println("ERROR: El número es demasiado grande (máx permitido: " + (Integer.MAX_VALUE - 122) + ")");
		        return;
		    }
		} else {
			System.err.println("ERROR: El número introducido no es un número válido o es demasiado grande (máx permitido: " + (Integer.MAX_VALUE - 122) + ")");
			return;
		}		
		scan.close();
		
		//Declaramos las variables con las que vamos a trabajar, de tipo int, para poder operar con ellas sin problemas 
		int cN1;
		int cN2;
		int cN3;
		
		//Mostramos un mensaje de error si alguno de los caracteres introducidos no es una letra minúscula
		if (c1 < 97 || c1 > 122 || c2 < 97 || c2 > 122 || c3 < 97 || c3 > 122) {
			System.out.println("Uno o varios de los caracteres introducidos no son letras minúsculas");	
		
		//Mostramos un mensaje de error si el número introducido es negativo
		} else if (n < 0) {	
			System.out.println("El número introducido no puede ser negativo");
		/* 
		 * Si todos los caracteres y el número introducidos son válidos, entonces sumamos el valor decimal del caracter ASCII al número introducido por teclado.
		 * De esta forma, sabemos cuánto se avanza desde ese caracter hasta el caracter n posiciones después
		 */	
		} else {
			cN1 = c1 + n;
			cN2 = c2 + n;
			cN3 = c3 + n;
			
			/*
			 * Si la suma del valor decimal del caracter introducido y el número introducido es mayor que 122 (que es el valor de la z, la última letra minúscula de la tabla ASCII),
			 * entonces calculamos el resto de dividir esa suma entre 122. 122 es una vuelta completa al alfabeto. Calculando el resto de esta división, sabemos en qué posición
			 * se queda tras haber dado n / 122 vueltas. Si no es mayor a 122, entonces esta asignación no se realiza, y la posición final será la que ya calculamos con 
			 * cNx = cx + n. Este camino iría directamente al bloque de condicionales de cada cNx de debajo, sin hacer las asignaciones de aquí debajo
			 */
			if (cN1 > 122) {
				cN1 = cN1 % 122;
			}
			if (cN2 > 122) {
				cN2 = cN2 % 122;
			}
			if (cN3 > 122) {
				cN3 = cN3 % 122;
			}
			
			/*
			 * Estas 3 líneas de código de debajo tienen la única función de saber el valor de cNx en el caso de que se esté depurando
			 * el código y queramos ver el valor de cNx para poder hacer nosotros cálculos manuales en un papel
			 * System.out.println("test. Valor cN1:  " + cN1);
			 * System.out.println("test. Valor cN2:  " + cN2);
			 * System.out.println("test. Valor cN3:  " + cN3);
			 */
			
			//Bloques de condicionales para resolver el primer caracter
			
			/*
			 * Si el número introducido es 0, cNx == cx. Si el número introducido es igual a 122 o uno de sus múltiplos, se dará una vuelta completa al abecedario. Por tanto, el valor final del caracter (cNx), seguirá siendo el mismo (cNx == cx). 
			 * Matermáticamente, esto se demuestra porque cNx % 122 == (cx + n) % 122 == cx % 122 + n % 122 == cx % 122 + 0. n % 122 es 0 porque se cumple que n es 122 o uno de sus múltiplos. El resultado de 
			 * cx % 122 siempre va a ser igual a cx, pues c1 siempre va a ser menor que 122, y el cociente será 0, y el resto es el valor del divisor, es decir, cx. Para el caso de la z (122) y n == 122, se 
			 * resuelve con el "else if (cN1 == 0)" 2 pasos más abajo.
			 */
			if (cN1 == c1) {
				System.out.println("La primera letra introducida no cambia, sigue siendo letra 1: " + (char)cN1);
				
			/*
			 * Hace falta meter este caso de debajo, porque si se da por ejemplo un caso de que el caracter fuera una y (y == 121) y el número introducido es n = 123, entonces el valor de cNx sería 0, y por tanto
			 * cNx no sería igual a cx en el if anterior, y al ser falsa la condición, se saltaría al else if que tiene la condición de que cNx == 0. Si esto pasa, se indicaría que la letra no cambia, que
			 * sigue siendo z. Aunque la letra mostrada es correcta, es incorrecto que diga que no ha cambiado, cuando sí que lo ha hecho, pues ha cambiado de y a z (123 es una vuelta completa más un paso adicional).
			 * La forma de resolver esto es poner en este else if la condición de que cNx == 0 y que el valor inicial del caracter introducido (cx) no fuera la z (122). Si el caracter introducido era la z, entonces
			 * salta al siguiente else if. La asignación de cNx que se hace en este caso es sumar al valor de cx el resto de dividir n entre 122. El máximo valor que puede tomar este resto es 25, cuando cx == 'a'.
			 * Esto es así porque hay que tener siempre en cuenta que (cx + n) es múltiplo de 122, para que cNx  == 0. Por lo tanto, si cx == a, n % 122 == 25, la suma de esto es 122 (nuevo valor de cNx, que sería la z). 
			 * En el caso de que cx == 'y', n % 122 == 1. La suma de esto es 122 (nuevo valor de cNx, que sería la z).
			 */
			} else if (cN1 == 0 && c1 != 122) {
				cN1 = c1 + n % 122;
				System.out.println("La primera letra introducida cambia a: " + (char)cN1);
				
			/*
			 * Este else if hace falta meterlo porque si n es igual a cualquier múltiplo de 122 y el caracter introducido es una z (122 en ASCII), el valor de cNx sería 0 (el resto de 
			 * dividir 122 o cualquiera de sus múltiplos entre 122), que se corresponde con un NUL en la tabla ASCII. Esto no puede ser así, pues si el caracter introducido es z y n = 122,
			 * lo que en realidad se ha hecho es dar una vuelta completa al abecedario de minúsculas, y el caracter debería seguir siendo z. Por tanto, al valor del caracter final le asignamos el 122
			 * y así resolvemos el problema de este caso concreto. No hace falta introducir en la condición que cx == 122, dado que la negación de esa condición ya fue falsa en el else if anterior (o lo que es lo mismo,
			 * en el else if anterior, ya se demostró que el valor inicial del caracter cx era igual a 122)
			 */
			} else if (cN1 == 0) {
				cN1 = 122;
				System.out.println("La primera letra introducida no cambia, sigue siendo letra 1: " + (char)cN1);
				
			/*
			 * Es bastante probable que se de el caso de que cNx sea mayor que 122, y por tanto al cambiar el valor de cNx por cNx % 122, el valor sea menor a 97 (que es el valor de la primera
			 * letra minúsucla, a, en la tabla ASCII). Si se da este caso e imprimimos directamente este valor, nos daría un caracter en la tabla ASCII que está a la izquierda de donde empiezan
		     * las letras minúsculas. Por tanto, la solución es sumar el valor de cNx a 96, que es el caracter que está justo antes de la a (pues al terminar el abecedario, se avanza el número
			 * de posiciones que toque desde la z. La forma de emular esto es usar el valor del caracter justo antes de la a). Así, sabemos cuántas posiciones ha avanzado desde que llegó al final
			 * del abecedario de minúsculas.
			 */
			} else if (cN1 < 97) {	
				cN1 = 96 + cN1;
				
				/*
				 * Si el resultado de cNx = = 96 + cNx es mayor que 122, tenemos un problema. Para resolverlo, añadimos otro condicional debajo
				 * dentro de este else if, poniendo la condición de que cNx sea mayor que 122. Si se cumple, lo que hacemos es restar a cNx (que es
				 * mayor que 122), 122. Al resultado de esto, le sumamos 96, que es el caracter anterior a la 'a'. La lógica de esto es que si cNx
				 * es mayor que 122, habrá dado una vuelta completa al abecedario de minúsculas, y la última posición del abecedario es la z (122).
				 * Si restamos 122 al valor de cNx, sabemos cuántas posiciones ha avanzado desde el final (122). El resultante de eso, se lo 
				 * sumamos al valor del caracter inmediatamente anterior al comienzo del abecedario de minúsculas (' == 96), como ya se explicó en
				 * el comentario anterior, y esto nos da cuántas posiciones ha avanzado desde el comienzo del abecedario de minúsculas.
				 * Como el máximo valor que puede tomar cNx es 96 para que se cumpla la condición, anidando 3 if con asignaciones como las que se ven abajo, 
				 * se resuelven todos los casos en los que (cN1 - 122 + 96) > 122. Así, resolvemos el problema aunque el valor de cNx 96.
				 */
				if (cN1 > 122) {
					cN1 = cN1 - 122 + 96;
				}	
				if (cN1 > 122) {
					cN1 = cN1 - 122 + 96;
				}
				if (cN1 > 122) {
					cN1 = cN1 - 122 + 96;
				}
				//Como puede darse el caso de que cNx sea igual a cx, incluyo aquí un condicional para que el print diga si realmente ha cambiado o no, además de indicar el valor final
				if (cN1 == c1) {
					System.out.println("La primera letra introducida no cambia, sigue siendo letra 1: " + (char)cN1);
				} else {
				System.out.println("La primera letra introducida cambia a: " + (char)cN1);
				}
			/*
			 * Este sería el caso en el que no se llega a dar una vuelta completa, dado que la suma del valor del caracter introducido y del número n introducido no llega a dar una vuelta completa
			 * (es menor a 122, que es el valor de la z). Por tanto, nos quedamos con ese valor tal cual y lo imprimimos como char
			 */
			} else {
				System.out.println("La primera letra introducida cambia a: " + (char)cN1);
			}	
			
			//Bloques de condicionales para resolver el segundo caracter
			if (cN2 == c2) {
				System.out.println("La segunda letra introducida no cambia, sigue siendo letra 2: " + (char)cN2);
			} else if (cN2 == 0 && c2 != 122) {
				cN2 = c2 + n % 122;
				System.out.println("La primera letra introducida cambia a: " + (char)cN2);
			} else if (cN2 == 0) {
				cN2 = 122;
				System.out.println("La segunda letra introducida no cambia, sigue siendo letra 2: " + (char)cN2);
			} else if (cN2 < 97) {	
				cN2 = 96 + cN2;
				if (cN2 > 122) {
					cN2 = cN2 - 122 + 96;
				}	
				if (cN2 > 122) {
					cN2 = cN2 - 122 + 96;
				}
				if (cN2 > 122) {
					cN2 = cN2 - 122 + 96;
				}
				if (cN2 == c2) {
					System.out.println("La primera letra introducida no cambia, sigue siendo letra 2: " + (char)cN2);
				} else {
				System.out.println("La primera letra introducida cambia a: " + (char)cN2);
				}
			} else {
				System.out.println("La segunda letra introducida cambia a: " + (char)cN2);
			}
			
			//Bloques de condicionales para resolver el tercer caracter
			if (cN3 == c3) {
				System.out.println("La tercera letra introducida no cambia, sigue siendo letra 3: " + (char)cN3);
			} else if (cN3 == 0 && c3 != 122) {
				cN3 = c3 + n % 122;
				System.out.println("La primera letra introducida cambia a: " + (char)cN3);	
			} else if (cN3 == 0) {
				cN3 = 122;
				System.out.println("La tercera letra introducida no cambia, sigue siendo letra 3: " + (char)cN3);
			} else if (cN3 < 97) {	
				cN3 = 96 + cN3;
				if (cN3 > 122) {
					cN3 = cN3 - 122 + 96;
				}	
				if (cN3 > 122) {
					cN3 = cN3 - 122 + 96;
				}
				if (cN3 > 122) {
					cN3 = cN3 - 122 + 96;
				}
				if (cN3 == c3) {
					System.out.println("La primera letra introducida no cambia, sigue siendo letra 3: " + (char)cN3);
				} else {
				System.out.println("La primera letra introducida cambia a: " + (char)cN3);
				}
			} else {
				System.out.println("La tercera letra introducida cambia a: " + (char)cN3);
			}
		}
	}

}
