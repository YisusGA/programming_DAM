package variables_booleanas;
import java.util.Scanner;

public class Ejemplos_booleanos {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero");
		double n = scan.nextInt();
		boolean b = n != 3;
		System.out.println("La condición numérica es: " + b);
		
		//También podemos comparar caracteres ASCII (char)
		boolean cond = 'a' < 'c';
		System.out.println("La condición del char es: " + cond);
		
		
		String nombre1 = "Juanito";
		String nombre2 = "Luis";
		//Esto no se puede
		//boolean b2 = nombre1 > nombre2;
		
		//Esto sí se puede
		boolean cond2 = nombre1.length() > nombre2.length();
		System.out.println("La condición de la longitud del String es: " + cond2);
		
		//Esto sí que se puede porque ser igual o ser distinto no va asociado a ningún criterio de orden
		//CIUDADO. Ver explicación en apuntes del día 30/09/2025
		boolean cond3 = nombre1 == nombre2;
		boolean cond4 = nombre1 != nombre2;
		System.out.println("¿Los nombres son iguales¿: " + cond3);
		System.out.println("¿Los nombres son diferentes?: " + cond4);
		
		//Aunque a veces funciona el método anterior para comparar cadenas, no es nada recomendable, dado que muchas veces
		//el resultado será erróneo. Usar mejor el método de debajo
		boolean cond5 = nombre1.equals(nombre2);
		System.out.println("Ahora bien hecho: ¿los nombres son iguales?: " + cond5);
		
		String nombre3 = "Yisus";
		String nombre4 = "Yisus";
		boolean cond6 = nombre3.equals(nombre4);
		System.out.println("Ahora bien hecho: ¿los nombres son iguales?: " + cond6);
		//También se puede hacer lo siguiente
		boolean cond7 = nombre3.equals("Yisus");
		System.out.println("¿El String almacenado es igual al String metido en el booleano?: " + cond7);
		scan.close();
	}

}
