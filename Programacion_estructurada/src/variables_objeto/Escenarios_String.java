package variables_objeto;
import java.util.Scanner;

public class Escenarios_String {

	public static void main(String[] args) {
		//En una variable de tipo String, se almacenan cadenas de caracteres
		String nombre1;
		nombre1 = "Yisus";
		char caracter;
		//Las dobles comillas son para cadenas de caracteres (String), No podemos almacenar un String
		//en una variable declarada como char. Por eso da error la siguiente línea
		//caracter = "p";
		caracter = 'p';
		//No se puede promocionar de char a String, por eso da error la siguiente línea
		//nombre1 = caracter;
		
		Scanner escaneito = new Scanner(System.in);
		System.out.println("Introduzca su nombre");
		String nombre2 = escaneito.nextLine();
		escaneito.close();
		System.out.println("Hola " + nombre2);
		//Ahora vamos a contar el número de caracteres que hay almacenados dentro de una variable String
		int numCar = nombre2.length();
		System.out.println("Hola " + nombre2);
		System.out.println("Tu nombre tiene " + numCar + " caracteres");
		
	}

}
