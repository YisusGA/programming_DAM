package ejercicios_sentencia_de_decision;

import java.util.Scanner;

public class Ejercicio19OK {
	
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
		//Inicializamos las variables para que no no de error la JVM
		int cN1 = 1;
		int cN2 = 1;
		int cN3 = 1;
		int n = 1;
		System.out.println("Introduce un número entero positivo");
//		Compruebo que n sea un número int válido, y limito su tamaño, para que no se salga del rango de un int y no se convierta 
//		en negativo al operar con él.Al introducir el método, te dice a qué se debe el error, porque hemos
//		puesto una condición que, si se cumple, muestra el mensaje de error que nosotros queremos.
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
		
		if (c1 < 97 || c1 > 122 || c2 < 97 || c2 > 122 || c3 < 97 || c3 > 122) {
			System.out.println("La letra introducida debe ser una minúscula y ser diferente de ñ");
			System.exit(0);
		}	
		/*
		 * Con esto tan sencillo de debajo, se resuelve. Sumamos el valor y del número n, y le restamos a, para saber cuánto ha avanzado
		 * desde el comienzo del alfabeto de minúsculas ('a') tras haber dado una o varias vueltas. Dividimos ese resultado entre 26 
		 * (26 es la distancia desde la 'a' hasta que da la vuelta y vuelve a la 'a') y nos quedamos con el resto. Si le sumamos ese resto
		 * a la 'a', tenemos cuántas posiciones ha avanzado desde la 'a', y por tanto, sabemos el caracter final donde se ha quedado.
		 * Este método sirve independientemente de lo grande que sea n, siempre que (c1 + n) no exceda la capacidad de un int. Pero para eso
		 * ya hemos limitado antes este escenario mostrando un mensaje de error.
		 * Esta operación también sirve si n es pequeño. Por ejemplo, nos dan c1 == b == 98 y n == 5. El resultado sería 103, que es la 'g'.
		 * Podemos comprobar fácilmente que esto es así moviéndonos 5 posiciones desde la 'b' inicial.
		 */
		cN1 = ((c1 + n - 'a') % 26) + 'a';
		cN2 = ((c2 + n - 'a') % 26) + 'a';
		cN3 = ((c3 + n - 'a') % 26) + 'a';
		
		System.out.println(c1 + " " + n + " posiciones= " + (char)cN1);
		System.out.println(c2 + " " + n + " posiciones= " + (char)cN2);
		System.out.println(c3 + " " + n + " posiciones= " + (char)cN3);
	}

}
