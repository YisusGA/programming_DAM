package ejercicios_sentencia_de_decision;

 import java.util.Scanner;
 
public class Ejercicio04 {

	//Realizar un programa que lea un número (que debe ser menor de 10) e indique si es o no primo.
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero menor que 10");
		int n = scan.nextInt();
		if (n >= 10) {
			System.out.println("El número introducido no es válido, por favor, prueba de nuevo");
		} else {
			String print = (((n % 2 == 0) && n != 2) || n == 9 || n == 1) ? "El número introducido no es primo" : "El número introducido es primo";
			//Otra forma de hacerlo sería la que está comentada debajo
			//CUIDADO: EL 1 NO ES PRIMO, ESTO ES UN AXIOMA DE LAS MATEMÁTICAS
			//if (n == 2 || n == 3 || n == 5 || n == 7) {
			//	System.out.println("El número es primo");
			//} else {
				//System.out.println("El número no es primo");
			//}
			System.out.println(print);
		}
		scan.close();
	}

}
