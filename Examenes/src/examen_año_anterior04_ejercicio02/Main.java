package examen_año_anterior04_ejercicio02;

import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<CriaturaMistica> criaturas = new ArrayList<>();

	public static void main(String[] args) {
		addCriaturas();
		describirCriaturas();
		activarPoderElfos();

	}

	public static String addCriaturas() {
		criaturas.add(new Dragon("Pepe", 500, 2500.0));
		criaturas.add(new Unicornio("Azucarillo", 300, 80.0));
		criaturas.add(new Elfo("Serie", 5000, 500));
		criaturas.add(new Elfo("Frieren", 2000, 800));
		return "Criaturas añadidas correctamente";
	}

	public static void describirCriaturas() {
		System.out.println(criaturas);
	}

	public static void activarPoderElfos() {
		for (CriaturaMistica i : criaturas) {
			if (i instanceof Elfo) {
				System.out.println(i.activarPoder());
			}
		}
	}

}
