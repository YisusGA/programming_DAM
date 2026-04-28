package main;

import interfaz.Operar;

public class Main {

	public static void main(String[] args) {
		
		// Este objeto no está pensado para contener números, cadenas, etc. Sólo está
		// pensado para contener una secuencia de instrucciones
		Operar suma = new Sumar(); // Creo una instancia de Operar cuya implementación es Sumar (o la que sea)

		Operar multiplica = new Multiplicar(); // Creo una instancia de Operar cuya implementación es Multiplicar (o la
												// que sea)

		// Le paso 3 datos: una secuencia de instrucciones, y 2 datos primitivos (int)
		System.out.println(Calculadora.operar(suma, 5, 7));
		System.out.println(Calculadora.operar(multiplica, 8, 10));

		// Pero se pueden usar funciones lambda, que son como un atajo para evitar tener
		// que hacer las implementaciones Sumar y Multiplicar
		Operar sumaLambda1 = (x, y) -> { // El paréntesis de antes de la flecha nos lo podemos ahorrar si sólo le pasamos un elemento
			return x + y; 
		};
		// Si la parte a la derecha de la flecha sólo es una sentencia, nos podemos ahorrar el return
		Operar sumaLambda2 = (x, y) -> x + y;
		Operar multiplicaLambda = (x, y) -> x * y;

		System.out.println(Calculadora.operar(sumaLambda1, 5, 7));
		System.out.println(Calculadora.operar(sumaLambda2, 5, 7));
		System.out.println(Calculadora.operar(multiplicaLambda, 8, 10));

		// Pero lo natural sería hacer esto, para atajar
		System.out.println(Calculadora.operar((x, y) -> x + y, 5, 7));
		System.out.println(Calculadora.operar((x, y) -> x * y, 5, 7));

	}

}
