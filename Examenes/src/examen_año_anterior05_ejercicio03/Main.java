package examen_año_anterior05_ejercicio03;

import java.util.ArrayList;
import java.util.List;

import teclado.Teclado2;

public class Main {
	private static List<Planta> lista = new ArrayList<>();

	public static void main(String[] args) {
		addPlantas();
		lista.sort(new OrdenarAscendenteAltura());
		System.out.println(lista);

	}

	public static void addPlantas() {
		System.out.println("Cuantas plantas quieres añadir");
		int num = Teclado2.leerEntero();
		for (int i = 0; i < num; i++) {
			Planta planta = new Planta();
			System.out.println("Introduce el nombre de la planta");
			planta.setNombreCientifico(Teclado2.leerCadena());
			System.out.println("Introduce la altura máxima de la planta");
			planta.setAlturaMaxima(Teclado2.leerEntero());
			lista.add(planta);

		}
	}

}
