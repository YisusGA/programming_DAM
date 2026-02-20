package ejercicio04_zoologico_virtual;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Zoologico {
	static Set<Animal> animales = new HashSet<>();
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("¿Cuántos animales quieres añadir?");
		int num = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < num; i++) {
			System.out.println(addAnimal());
		}
		System.out.println(animales);
	}

	public static String addAnimal() {
		System.out.println("Introduce el nombre del animal");
		String nombre = scan.nextLine();
		System.out.println("Introduce la edad del animal");
		int edad = scan.nextInt();
		scan.nextLine(); // Descartamos línea vacía
		TipoAnimal tipo;
		do {
			System.out.println("Introduce un tipo de animal válido: PERRO, GATO o AVE");
			String input = scan.nextLine();
			tipo = TipoAnimal.escogerTipo(input);
		} while (tipo == null);
		boolean added = false;
		switch (tipo) {
		case PERRO -> {
			System.out.println("Introduce la raza del perro");
			String raza = scan.nextLine();
			added = animales.add(new Perro(nombre, edad, raza));
		}
		case GATO -> {
			int vidas;
			do {
				System.out.println("¿Cuántas vidas le quedan? Valores admitidos: [0-7]");
				vidas = scan.nextInt();
			} while (vidas > 7 || vidas < 0);
			added = animales.add(new Gato(nombre, edad, vidas));
		}
		case AVE -> {
			System.out.println("¿Cuánto mide de ala a ala?");
			double envergadura = scan.nextDouble();
			added = animales.add(new Ave(nombre, edad, envergadura));
		}
		}
		if (added) {
			return "Animal añadido correctamente";
		} else {
			return "No puede llamarse igual, animal no añadido";
		}
	}

}
