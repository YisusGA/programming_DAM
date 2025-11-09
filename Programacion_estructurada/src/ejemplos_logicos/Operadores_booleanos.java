package ejemplos_logicos;

import java.util.Scanner;

public class Operadores_booleanos {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce tu edad");
		int edad = scan.nextInt();
		boolean cond = edad >= 18 && edad <= 70;
		System.out.println("¿Puedes trabajar? Respuesta: " + cond);
		
		//En el ejemplo de debajo, al ser un OR exclusive, arrojará el resultado true cuando un operando booleano sea verdadero
		//y el otro falso. Si pones edad = 12, saldrá falso (pues ambos booleanos son verdaderos). Si pones 24, saldrá true, pues
		//el primer booleano es falso y el segundo verdadero
		boolean cond2 = edad <= 12 ^ edad % 2 == 0;
		System.out.println("La condición 2 es: " + cond2);

	}

}
