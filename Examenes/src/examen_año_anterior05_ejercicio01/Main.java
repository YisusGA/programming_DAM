package examen_año_anterior05_ejercicio01;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static List<MagoElemental> magos = new ArrayList<>();

	public static void main(String[] args) {
		magos.add(new MagoEstudiante("Elminster"));
		magos.add(new MagoAire("Morgana", 1000.0));
		magos.add(new MagoFuego("Albus", 100.7));
		
		lanzarHechizos();

	}

	public static void lanzarHechizos() {
		for (MagoElemental i : magos) {
			if (i instanceof MagoEstudiante) {
				System.out.println(i.getNombre() + " dice: " + ((MagoEstudiante) i).estudiar());
			}
			System.out.println(i.getNombre() + " dice: " + i.lanzarHechizo());
		}
	}

}
