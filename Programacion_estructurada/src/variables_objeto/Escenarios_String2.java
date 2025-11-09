package variables_objeto;
import java.util.Scanner;

public class Escenarios_String2 {
	public static void main(String[] args) {
		Scanner escaneito = new Scanner(System.in);
		System.out.println("Introduzca su nombre");
		String nombre1 = escaneito.nextLine();
		System.out.println("Introduzca un número");
		int num1 = escaneito.nextInt();
		//En principio, no es necesario almacenar nombre1.length() en una variable,
		//se podría usar directamente el dato en el boolean. Sólo sería necesario realizar
		//la asignación en el caso de que vayamos a usar ese dato más veces. Sin embargo,
		//de momento vamos a asignar la variable cuando trabajemos.
		int numCar1 = nombre1.length();
		boolean caracteres1 = numCar1 > num1;
		System.out.println(caracteres1);
		escaneito.close();
	}
}
