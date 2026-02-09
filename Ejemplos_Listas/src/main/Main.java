package main;

import model.Plato;
import model.Restaurante;

public class Main {

	public static void main(String[] args) {

		Restaurante r = new Restaurante("La Buena Mesa");

		Plato p1 = new Plato("Pizza", 9.5); // La JVM puede promocionar un double primitivo al wrapper Double, pero no
											// podrá promocionar un int primitivo a un wrapper Double (recordar que sí
											// puede promocionar un int primitivo a un double primitivo). Por ello, sí
											// aquí metemos un int, nos dará error
		p1.addIngrediente("Queso");
		p1.addIngrediente("Tomate");
		p1.addIngrediente("Jamón");

		Plato p2 = new Plato("Ensalada", 6.0);
		p2.addIngrediente("Lechuga");
		p2.addIngrediente("Tomate");
		p2.addIngrediente("Atún");

		Plato p3 = new Plato("Hamburguesa", 8.0);
		p3.addIngrediente("Pan");
		p3.addIngrediente("Carne");
		p3.addIngrediente("Queso");

		Plato p4 = new Plato("Cocido", 8.0);
		p4.addIngrediente("Morcilla");
		p4.addIngrediente("Garbanzos");
		p4.addIngrediente("Patatas");

		r.addPlato(p1);
		r.addPlato(p2);
		r.addPlato(p3);
		r.addPlato(p4);

		System.out.println(r.verCarta());
		System.out.println("----------------");
		System.out.println(r.platosContienenIngrediente("Queso"));

		Plato p5 = new Plato("Pizza", 100.0);
		System.out.println("Eliminamos pizza");
		r.eliminarPlatov3(p5);
		System.out.println(r.verCarta());

		r.eliminarPlatov2("Cocido");
		System.out.println(r.verCarta());

	}

}
