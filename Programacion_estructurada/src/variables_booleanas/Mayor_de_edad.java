package variables_booleanas;
import java.util. Scanner;

public class Mayor_de_edad {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("¿Eres mayor de edad?");
		System.out.println("Haz click en la consola e introduce tu edad para descubrirlo");
		int edad = scan.nextInt();
		scan.close();
		boolean mayorDeEdad = edad >= 18;
		if (mayorDeEdad == true) {
			System.out.println("Eres mayor de edad");
		} else {
				System.out.println("Eres menor de edad");
		  }
	}

}
