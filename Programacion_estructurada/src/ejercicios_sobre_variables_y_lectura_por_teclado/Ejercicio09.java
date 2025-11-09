package ejercicios_sobre_variables_y_lectura_por_teclado;
import java.util. Scanner;

public class Ejercicio09 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Haz click en la consola e introduce la temperatura en grados Celsius. Pon los decimales con coma");
		double temperaturaCelsius = scan.nextDouble();
		scan.close();
		double temperaturaFarenheit = (temperaturaCelsius * 9/5) + 32;
		if (temperaturaFarenheit < 0.2 && temperaturaFarenheit > -0.2) {
			System.out.println("Ni frío ni calor, cero grados jeje. " + temperaturaFarenheit);
		} else {
			System.out.println("La temperatura en Farenheit es: " + temperaturaFarenheit);
		}
	}

}
