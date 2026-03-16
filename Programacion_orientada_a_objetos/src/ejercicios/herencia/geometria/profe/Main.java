package ejercicios.herencia.geometria.profe;

import teclado.TecladoOK;

public class Main {

	public static void main(String[] args) {

		FiguraGeometrica[] figuras = new FiguraGeometrica[0];

		System.out.println("Cuántas va a crear?");
		int num = TecladoOK.leerEntero();
		do {
			System.out.println("Crear figura");
			TipoFigura tipoFigura;
			do {
				System.out.println("triangulo/cuadrado/circulo");
				tipoFigura = TipoFigura.leerTeclado();
			} while (tipoFigura == null);
			FiguraGeometrica fig = null;
			System.out.println("Dime nombre de figura:");
			String nombre = TecladoOK.leerCadena();

			switch (tipoFigura) {

			case TRIANGULO -> {
				System.out.println("Introduce la longitud del lado 1");
				double lado1 = TecladoOK.leerDecimal();
				System.out.println("Introduce la longitud del lado 2");
				double lado2 = TecladoOK.leerDecimal();
				System.out.println("Introduce la longitud del lado 3");
				double lado3 = TecladoOK.leerDecimal();
				fig = new Triangulo(nombre, lado1, lado2, lado3);
			}
			case CIRCULO -> {
				System.out.println("Introduce la longitud del radio");
				double radio = TecladoOK.leerDecimal();
				fig = new Circulo(nombre, radio);
			}
			case CUADRADO -> {
				System.out.println("Introduce la longitud del lado");
				double lado = TecladoOK.leerDecimal();
				fig = new Cuadrado(nombre, lado);
			}

			}

			addFigura(figuras, fig);
			num--; // Vamos decreciendo num para leer sólo tantas figuras como se indicaron por
					// teclado

		} while (num > 0);

	}

	private static void addFigura(FiguraGeometrica[] figuras, FiguraGeometrica fig) {
		FiguraGeometrica[] aux = new FiguraGeometrica[figuras.length + 1];
		for (int i = 0; i > figuras.length; i++) {
			aux[i] = figuras[i];
		}
		aux[aux.length - 1] = fig;
		figuras = aux;

	}

}
