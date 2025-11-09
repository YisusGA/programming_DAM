package ejercicios_sobre_variables_y_lectura_por_teclado;
import java.util.Scanner;

public class Ejercicio08 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Haz click en la consola e introduce un número entero de las horas que has trabajado esta semana");
		int horas = scan.nextInt();
		scan.close();
		double tarifa = 35.5;
		double salario_semana = horas * tarifa;
		System.out.println("Esta semana has ganado: " + salario_semana + " €");

	}

}
