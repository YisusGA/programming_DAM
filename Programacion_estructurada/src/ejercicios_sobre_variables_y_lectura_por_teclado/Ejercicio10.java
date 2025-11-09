package ejercicios_sobre_variables_y_lectura_por_teclado;
import java.util. Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero con la distancia recorrida en km");
		int distancia = scan.nextInt();
		System.out.println("Introduce un número entero para el tiempo que has tardado en horas");
		int tiempo = scan.nextInt();
		scan.close();
		int velocidad = distancia / tiempo;
		System.out.println("Tu velocidad promedio ha sido: " + velocidad);

	}

}
