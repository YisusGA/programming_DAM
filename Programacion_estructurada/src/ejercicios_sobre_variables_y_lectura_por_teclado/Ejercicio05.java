package ejercicios_sobre_variables_y_lectura_por_teclado;
import java.util.Scanner;
public class Ejercicio05 {

		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Introduce un número entero para la altura del rectángulo");
			int altura = scan.nextInt();
			System.out.println("Introduce un número entero para el ancho del rectángulo");
			int ancho = scan.nextInt();
			scan.close();
			int area = altura * ancho;
			System.out.println("El área del rectángulo es: " + area);
		}
}
