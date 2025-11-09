package ejercicios_con_operador_ternario_y_operadores_de_logica_booleana;

import java.util.Scanner;

public class Ejercicio26 {

	public static void main(String[] args) {
		//Escribe un programa que lea de teclado tres variables de tipo double para representar las
		//longitudes de los lados de un triángulo. Muestra en pantalla si el triángulo es equilátero,
		//isósceles o escaleno, o si no es un triángulo. Para que sea un triángulo, la suma de cada par de sus lados 
		//tiene que ser mayor que el otro lado. Se tienen que dar las 3 condiciones simultáneamente.
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce la longitud de un lado del triángulo");
		double n1 = scan.nextDouble();
		System.out.println("Introduce la longitud de otro lado del triángulo");
		double n2 = scan.nextDouble();
		System.out.println("Introduce la longitud del tercer lado del triángulo");
		double n3 = scan.nextDouble();
		String lados = (((n1 + n2) < n3) || ((n1 + n3) < n2) || ((n2 + n3) < n1)) ? "Eso no es un triángulo, picha" : (n1 == n2 && n2 == n3) ? "El triángulo es equilátero": ((n1 == n2) || (n1 == n3) || (n2 == n3)) ? "El triángulo es isósceles" : "El triángulo es escaleno";
		System.out.println(lados);
		scan.close();

	}

}
