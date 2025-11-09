package ejercicios_sobre_variables_y_lectura_por_teclado;
import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Haz click en la consola e introduce tu nota del examen poniendo los decimales con coma");
		double nota = scan.nextDouble();
		scan.close();
		boolean aprobado = nota >= 5;
		System.out.println("¿Has aprobado?: " + aprobado);

	}

}
