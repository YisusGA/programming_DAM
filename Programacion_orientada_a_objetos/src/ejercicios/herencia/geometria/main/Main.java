package ejercicios.herencia.geometria.main;

import java.util.Random;

import ejercicios.herencia.geometria.datos.ManejadorCirculos;
import ejercicios.herencia.geometria.datos.ManejadorCuadrados;
import ejercicios.herencia.geometria.datos.ManejadorFiguras;
import ejercicios.herencia.geometria.figuras.Circulo;
import ejercicios.herencia.geometria.figuras.Cuadrado;

public class Main {
	static Random generador = new Random();

	public static void main(String[] args) {
		ManejadorFiguras manejador;

		for (int i = 0; i < 1; i++) {
			Circulo circulo1 = new Circulo(generador.nextDouble());
			Circulo circulo2 = new Circulo(generador.nextDouble());
			Circulo circulo3 = new Circulo(generador.nextDouble());
			System.out.println("Radio círculo 1: " + circulo1.getRadio());
			System.out.println("Área círculo 1: " + circulo1.getArea());
			System.out.println("Radio círculo 2: " + circulo2.getRadio());
			System.out.println("Área círculo 2: " + circulo2.getArea());
			System.out.println("Radio círculo 3: " + circulo3.getRadio());
			System.out.println("Área círculo 3: " + circulo3.getArea());
			manejador = new ManejadorCirculos();
			System.out.println(manejador.addFigura(circulo1));
			System.out.println(manejador.addFigura(circulo2));
			System.out.println(manejador.addFigura(circulo3));
			System.out.println("Área total de los 3 círculos: " + manejador.getAreaTotalFiguras());
		}

		for (int i = 0; i < 1; i++) {
			Cuadrado cuadrado1 = new Cuadrado(generador.nextDouble());
			Cuadrado cuadrado2 = new Cuadrado(generador.nextDouble());
			Cuadrado cuadrado3 = new Cuadrado(generador.nextDouble());
			System.out.println("Lado cuadrado 1: " + cuadrado1.getLado());
			System.out.println("Área cuadrado 1: " + cuadrado1.getArea());
			System.out.println("Lado cuadrado 2: " + cuadrado2.getLado());
			System.out.println("Área cuadrado 2: " + cuadrado2.getArea());
			System.out.println("Lado cuadrado 3: " + cuadrado3.getLado());
			System.out.println("Área círculo 3: " + cuadrado3.getArea());
			manejador = new ManejadorCuadrados();
			System.out.println(manejador.addFigura(cuadrado1));
			System.out.println(manejador.addFigura(cuadrado2));
			System.out.println(manejador.addFigura(cuadrado3));
			System.out.println("Área total de los 3 cuadrados: " + manejador.getAreaTotalFiguras());
		}

	}

}
