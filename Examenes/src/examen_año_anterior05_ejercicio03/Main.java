package examen_año_anterior05_ejercicio03;

import java.util.ArrayList;
import java.util.List;

import teclado.TecladoOK;

public class Main {
	private static List<Planta> lista = new ArrayList<>();

	public static void main(String[] args) {
		addPlantas();
		lista.sort(new OrdenarAscendenteAltura());
		System.out.println(lista);

	}

	public static void addPlantas() {
		System.out.println("Cuantas plantas quieres añadir");
		int num = TecladoOK.leerEntero();
		for (int i = 0; i < num; i++) {
			Planta planta = new Planta();
			System.out.println("Introduce el nombre de la planta");
			planta.setNombreCientifico(TecladoOK.leerCadena());
			System.out.println("Introduce la altura máxima de la planta");
			planta.setAlturaMaxima(TecladoOK.leerEntero());
			lista.add(planta);

		}
	}

}
