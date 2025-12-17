package ejercicio16;

import java.util.Scanner;

public class Main {
	
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		Alumno a = new Alumno(null, null);
		
		int opcion;
		
		do {
			opcion = Main.mostrarMenu();
			scan.nextLine();
		} while (opcion != 0);

	}
	
	private static int mostrarMenu() {
		return scan.nextInt();
	}

}
