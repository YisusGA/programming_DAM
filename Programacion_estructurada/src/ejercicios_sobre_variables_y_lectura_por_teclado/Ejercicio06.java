package ejercicios_sobre_variables_y_lectura_por_teclado;
import java.util.Scanner;

public class Ejercicio06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Haz click en la consola e introduce el número de tarjetas gráficas que hay en el almacén");
		int tarjetas = scan.nextInt();
		scan.close();
		boolean stock = tarjetas > 5;
		if (stock == true) {
			System.out.println("Hay stock suficiente");
		} else {
			System.out.println("No hay stock suficiente");
		}
	}

}
