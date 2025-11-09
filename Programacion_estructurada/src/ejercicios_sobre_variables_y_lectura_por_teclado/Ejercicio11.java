package ejercicios_sobre_variables_y_lectura_por_teclado;
import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Haz click en la consola e introduce el radio del círculo. Representa los decimales con coma");
		double radio = scan.nextDouble();
		scan.close();
		double area = radio * radio * 3.1415926535897932384626433832795;
		System.out.println("El área del círculo es: " + area);
	}

}
