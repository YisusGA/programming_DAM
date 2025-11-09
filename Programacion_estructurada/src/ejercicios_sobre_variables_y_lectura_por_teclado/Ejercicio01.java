package ejercicios_sobre_variables_y_lectura_por_teclado;

//Escribe un programa en Java que lea por teclado dos variables enteras y muestre su suma en pantalla
import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Haz click en la terminal e introduce un número entero");
		int n1 = scan.nextInt();
		System.out.println("Haz click en la terminal e introduce otro número entero");
		int n2 = scan.nextInt();
		scan.close();
		int resultado = n1 + n2;
		System.out.println("Resultado: " + resultado);

	}

}
