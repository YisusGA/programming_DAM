package ejemplos_logicos;
import java.util.Scanner;

public class OperadorTernario {

	public static void main(String[] args) {
		//Operador ternario: es una asignación condicionada. Asigna una cosa u otra en función de una condición
		
		//Ejercicio: Asigna a una cadena el valor "Mayor de edad" o "Menor de edad" en función de la edad numérica
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce tu edad");
		int edad = scan.nextInt();
		String resultado;
		boolean condicion = edad >= 18;
		//Esto de debajo es un operador ternario
		resultado = condicion?"Mayor de edad":"Menor de edad";
		System.out.println(resultado);
		//No haría falta poner la condición en una variable booleana aparte, se podría meter directamente en resultado:
		//resultado = edad >= 18?"Mayor de edad":"Menor de edad";
		scan.close();
	}

}
