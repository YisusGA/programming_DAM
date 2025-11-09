package ejercicios_en_clase;

import java.util.Scanner;

public class Ejercicio03 {

//Se permite el acceso a 2 personas sólo si ambas son mayores de 18 años o 
//si una es menor de edad pero está acompañada por una persona mayor de 21 años
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce la edad de la primera persona");
		int edad1 = scan.nextInt();
		System.out.println("Introduce la edad de la segunda persona");
		int edad2 = scan.nextInt();
		boolean acceso = (edad1 >= 18 && edad2 >= 18) || (edad1 >= 21 || edad2 >= 21);
		String entrada = acceso?"Podéis entrar":"No podéis entrar";
		System.out.println(entrada);
		scan.close();

	}

}
