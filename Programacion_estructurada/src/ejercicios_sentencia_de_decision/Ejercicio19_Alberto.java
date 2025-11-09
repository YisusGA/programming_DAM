package ejercicios_sentencia_de_decision;

import java.util.Scanner;

/*
 * Recibe tres letras minúsculas y un int n 
 * Sustituye cada char con el char equivalente del alfabeto 
 * que se encuentra n posiciones después(si acaba el alfabeto, empieza desde el principio)
 * Por ejemplo si recibe ‘a’ ‘b’ ‘c’ 2 
 * a --> 2 --> c
 * b --> 2 --> d
 * c --> 2 --> e
 */

public class Ejercicio19_Alberto {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Introduce una letra minúscula: ");
		String input1 = scan.next();
		char char1 = input1.charAt(0);
		
		System.out.print("Introduce otra letra minúscula: ");
		String input2 = scan.next();
		char char2 = input2.charAt(0);
		
		System.out.print("Introduce OTRA letra minúscula: ");
		String input3 = scan.next();
		char char3 = input3.charAt(0);
		
		
		int jumps = 0;
		System.out.print("Introduce un número entero POSITIVO: ");
		
		// Comprobamos que 'jumps' sea un Int válido
		if (scan.hasNextInt()) {
			jumps = scan.nextInt();
		    if (jumps > Integer.MAX_VALUE - 122) {
		        System.err.println("ERROR: El número es demasiado grande (máx permitido: " + (Integer.MAX_VALUE - 122) + ")");
		        return;
		    }
		} else {
			System.err.println("ERROR: Input no válido");
			return;
		}
		
		scan.close();

		
		
		// Input validation (Comprobamos que el número sea un char ASCII mínuscula y que no sea negativo
		if (jumps < 0) {
			System.err.println("ERROR: El número debe ser positivo.");
		}
		boolean validLowercase = (char1 >= 97 && char1 <= 122) && (char2 >= 97 && char2 <= 122) && (char3 >= 97 && char3 <= 122);
		if (!validLowercase) {
			System.err.println("ERROR: Valor no válido, deben ser letras minúsculas de (a-z)");
			return;
		}
		

		// CONVERSION DE LETRAS
		// Char1 (Ejemplo explicado)
		
		int newChar1 = char1 + jumps; // Por ejemplo: la letra 'a' (97) + el número de saltos (10) = 107 (k) en ASCII 
		
		// En caso de que la suma de (char1 + jumps) sea mayor que 122 (osea, esté fuera del rango ASCII de las minúsculas) haremos lo siguiente:  
		if (newChar1 > 122) {
			int excessTimes = (newChar1 - 97) / 26; // Calculamos cuantas veces sobrepasa 'newChar1' el rango ASCII válido.
													// El rango ASCII para las minúsculas abarca desde (97 = a) hasta (122 = z)
													// Entonces, si 'newChar1' es mayor que 122, volvemos a empezar el abecedario
													// Ej: 123 = a, 124 = b, 125 = c
			
													// RANGOS:
													// (97(a) - 122(z)) [0 veces] (Esto es el rango ASCII normal)
													// (123(a) - 148(z)) [1 vez]
			                                        // (149(a) - 174(z)) [2 veces]
													// Para calcularlos simplemente sumamos 25 a la letra 'a'. Ej: 97(a) + 25 = 122(z). Esto es un abecedario entero en ASCII
			
													// Por ejemplo, si el usuario introduce 'char1' = d y 'jumps' = 50
													// newChar1 sería char1(100) + jumps(50) = 150
													// 150 - 97 = 53
													// 53 / 26 = 2.03. (Nos pasaríamos 2 veces del rango.)
													//Podemos comprobarlo porque 150 está dentro del rango (149 - 173).
													

			newChar1 -= (excessTimes * 26);	        // Si restamos 26 tantas veces como nos pasemos del rango, nos da la letra dentro del rango (97-122)
                                                    // Ej: 150 - (2 * 26) = 98(b)
													// Ej2: 140 - (1 * 26) = 114 (r)	
					
		}

		
		
		
		// Char2
		int newChar2 = char2 + jumps;
		if (newChar2 > 122) {
			int excessTimes = (newChar2 - 97) / 26;
			newChar2 -= (excessTimes * 26);
		}

		// Char3
		int newChar3 = char3 + jumps;
		if (newChar3 > 122) {
			int excessTimes = (newChar3 - 97) / 26;
			newChar3 -= (excessTimes * 26);
		}
		
		
		// PRINT
		System.out.printf("%n%c --> %d --> %c", char1, jumps, newChar1);
		System.out.printf("%n%c --> %d --> %c", char2, jumps, newChar2);
		System.out.printf("%n%c --> %d --> %c", char3, jumps, newChar3);
		
		
	}
}
