package ejercicios_sentencia_iterativa;

/**
 * Programa que pida la estatura (en metros) y sexo (v/m) de un número indeterminado de personas (mientras el operador quiera). 
 * Posteriormente escribirá la estatura media de los varones y la estatura media de las mujeres
 */

import java.util.Scanner;

public class Ejercicio13 {

	public static void main(String[] args) {
		double estatura = 0;
		String sexo = "v";
		double sumaEstaturaHombre = 0;
		double sumaEstaturaMujer = 0;
		double mediaEstaturaHombre = 0;
		double mediaEstaturaMujer = 0;
		int contadorHombre = 0;
		int contadorMujer = 0;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Introduce el sexo de la persona: v para hombre y m para mujer. Si quieres dejar de introducir datos, escribe fin");
			sexo = scan.nextLine();
			while (!sexo.equals ("v") && !sexo.equals ("m") && !sexo.equals ("fin")) {
				System.out.println("El sexo introducido no es válido, prueba de nuevo");
				sexo = scan.nextLine();
			}
			if (!sexo.equals ("fin")) {
				System.out.println("Introduce la estatura de la persona");
				estatura = scan.nextDouble();
				String trash = scan.nextLine();
			}
			else if (sexo.equals ("v")) {
				contadorHombre++;
				sumaEstaturaHombre += estatura;
			}
			else {
				contadorMujer++;
				sumaEstaturaMujer += estatura;
			}
			
		} while (!sexo.equals ("fin"));
		scan.close();
		mediaEstaturaHombre = sumaEstaturaHombre / contadorHombre;
		mediaEstaturaMujer = sumaEstaturaMujer / contadorMujer;
		System.out.println("La estatura media de los hombres es: " + mediaEstaturaHombre);
		System.out.println("La estatura media de las mujeres es: " + mediaEstaturaMujer);
	}

}
