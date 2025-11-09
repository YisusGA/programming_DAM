package ejercicios_sentencia_de_decision;

import java.util.Scanner;

public class Ejercicio09 {
	//Una compañía dedicada al alquiler de coches cobra un monto fijo de 200 euros 
	//para los primeros 300 km de recorrido. Para más de 300 km y hasta 1000 km, 
	//cobra un monto adicional de 15 euros por cada kilómetro en exceso sobre 300, 
	//además del fijo. Para más de 1000 km cobra un monto adicional de 10 euros por 
	//cada kilómetro en exceso sobre 1000, además del fijo y de la cantidad extra 
	//correspondiente por los kilómetros entre 300 y 1000. Realizar un programa que, 
	//dada la cantidad de kilómetros muestre la cantidad a pagar
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Cuántos Km has recorrido");
		int d = scan.nextInt();
		int p1 = 200;
		int p2 = p1 + 15 * (d - 300);
		int p3 = p1 + 15 * 700 + 10 * (d - 1000);
		if (d > 300) {
			String pFinal = (d <= 1000) ? "Tienes que pagar: " + p2 : "Tienes que pagar: " + p3;
			System.out.println(pFinal + " €");
		} else {
			System.out.println("Tienes que pagar: " + p1 + " €");
		}

	}

}
