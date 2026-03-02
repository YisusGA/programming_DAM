package examen03_240226.ejercicio01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SimulacionEcosistema {
	private static List<Animal> animales = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println(llenarLista());
		System.out.println(rondaComida());
		System.out.println(rondaCaza());

		System.out.println("La lista final de animales queda de la siguiente forma:");
		for (Animal i : animales) {
			System.out.println(i);
		}

	}

	public static String llenarLista() {
		int contadorLeones = 0;
		int contadorConejos = 0;
		animales.add(new Conejo("conejo" + contadorConejos++));
		animales.add(new Leon("leon" + contadorLeones++));
		animales.add(new Conejo("conejo" + contadorConejos++));
		animales.add(new Conejo("conejo" + contadorConejos++));
		animales.add(new Leon("leon" + contadorLeones++));
		return "Animales añadidos";
	}

	public static String rondaComida() {
		Random generador = new Random();
		for (Animal i : animales) {
			i.comer(generador.nextInt(1, 60));
		}
		return "Ala, todos comidos";
	}

	public static String rondaCaza() {
		String resultadoCaza = "";
		boolean encontrado = false;
		Depredador dep = null; // Aunque en este caso sólo Leon implementa Depredador, si queremos que el
								// programa sea escalable, mejor trabajar con la interfaz que con la clase que
								// la implementa, por si en un futuro hubiera más clases que implementen
								// Depredador. Y como Animal es una clase abstracta, no podemos crear instancias
								// de Animal
		for (int i = 0; !encontrado && i < animales.size(); i++) {
			if (animales.get(i) instanceof Depredador) {
				dep = (Depredador) animales.get(i); // Este casting es necesario, o el compilador da error
				encontrado = true;
			}
		}
		if (encontrado) {
			int contadorCazasExito = 0;
			boolean haCazado = false;
			Iterator<Animal> it = animales.iterator();
			while (it.hasNext()) {
				Animal a = it.next(); // Importante guardar el it.next() en un objeto Animal, pues cada vez que
										// llamamos a it.next(), estamos avanzando una posición en el iterador, y si
										// usamos varias veces it.next() en lugar de almacenarlo en un objeto Animal (y
										// luego usar ese objeto), puede que no estemos usando el elemento del iterador
										// que creemos que estamos usando. Esto lo hice fatal durante el examen, si
										// quiero ver cómo hacerlo mal, ver mi versión
				if (dep.cazar(a)) {
					it.remove();
					haCazado = true;
					contadorCazasExito++;
				}
			}
			if (!haCazado) {
				animales.remove((Animal) dep);
				resultadoCaza = "El depredador no ha cazado ninguna presa, así que ha sido eliminado";
			} else {
				resultadoCaza = "El depredador " + ((Animal) dep).getNombre() + " ha cazado con éxito a "
						+ contadorCazasExito + " presas";
			}
		} else {
			resultadoCaza = "No hay depredadores a la vista";
		}
		return resultadoCaza;
	}

}
