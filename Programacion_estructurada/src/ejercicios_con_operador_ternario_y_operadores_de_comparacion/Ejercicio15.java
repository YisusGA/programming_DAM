package ejercicios_con_operador_ternario_y_operadores_de_comparacion;
import java.util.Scanner;

public class Ejercicio15 {
	//Escribe un programa que lea por teclado dos variables de tipo double y muestre en pantalla el
	//resultado de la resta de ambas, pero asegurándote de que el resultado nunca sea negativo.
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número decimal con coma");
		double n1 = scan.nextDouble();
		System.out.println("Introduce otro número decimal con coma");
		double n2 = scan.nextDouble();
		//La clave de este programa es que siempre se reste el número mayor menos el menor. Para hacer eso, hace
		//falta crear un booleano en el que se haga una asignación condicional
		double nResta = (n1 > n2)?(n1 - n2):(n2 - n1);
		
		//Otra forma que se me ocurrión de hacerlo, aunque más compleja, sería la de debajo
		//double nResta;
		//boolean resta = ((n1 > n2) & ((nResta = n1 - n2) > 0)) || ((n2 > n1) & ((nResta = n2 - n1) > 0));
		
		//Otra forma que se le ocurrió a Alberto es la siguiente:
		//double nResta = n1 - n2;
		//double print = (n1 > n2)?(nResta):(nResta - nResta - nResta);
		
		System.out.println(nResta);
		scan.close();
	}

}
