package ejercicios_sobre_variables_y_lectura_por_teclado;

//Crea un programa que lea por teclado tres variables de tipo doble (números decimales) y calcule su promedio. 
//Luego, muestra el resultado en la pantalla

import java.util.Scanner;
public class Ejercicio02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Haz click en la consola e introduce un número decimal poniendo el decimal con coma");
		double n1 = scan.nextDouble();
		System.out.println("Haz click en la consola e introduce un segundo número decimal");
		double n2 = scan.nextDouble();
		System.out.println("Haz click en la consola e introduce un tercer número decimal");
		double n3 = scan.nextDouble();
		scan.close();
		double resultado = (n1 + n2 + n3) / 3;
		System.out.println ("Resultado: " + resultado);
		

	}

}
