package ejercicios_sobre_variables_y_lectura_por_teclado;
import java.util.Scanner;

public class Ejercicio07 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Haz click en la consola e introduce el precio del artículo");
		double precio = scan.nextDouble();
		System.out.println("Haz click en la consola e introduce el porcentaje de descuento aplicable al artículo");
		double descuento = scan.nextDouble();
		scan.close();
		double precio_final = precio - precio * descuento / 100;
		System.out.println("El precio final es: " + precio_final);

	}

}
