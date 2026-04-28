package main;

import java.util.ArrayList;
import java.util.List;

public class Main2 {

	public static void main(String[] args) {
		List<Integer> numeros = new ArrayList<>();

		for (int i = 0; i < 20; i++) {
			numeros.add((int) (Math.random() * 100));
		}

		for (Integer n : numeros) {
			System.out.println("Soy " + n);
		}
		// forEach necesita que le pases un elemento y qué hacer con ese elemento (una
		// lambda). Y le tienes que pasar una lambda que se adapte a lo que hace ese
		// método

		// Esto es lo mismo que el for-each de encima, pero nos ahorramos hacer ese for.
		// Este método forEach necesita que le pasemos un Consumer, que básicamente
		// significa que le pasamos un dato y lo consume sin devolver absolutamente
		// nada. En este caso, cuando el Consumer "consume" ese dato, le decimos que lo
		// imprima por consola
		numeros.forEach(x -> System.out.println("Soy " + x));

		// removeIf necesita una función lambda de tipo Predicate. Una función lambda
		// Predicate devuelve un booleano, en función de si se cumple una condición. Y
		// como le pasamos ese Predicate al método removeIf, si el Predicate devuelve
		// true, se elimina el elemento de la colección. Y con todo esto, te ahorras
		// crear un Iterator y un bucle while para eliminar items de la colección
		numeros.removeIf(x -> x % 2 == 0);

	}

}
