package ejercicios_en_clase;

import java.util.Scanner;

public class Ejercicio01 {
	
	//Programa para dejar pasar a alguien sólo si es mayor de edad o si tiene al menos 16 años y tiene un permiso paterno
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce tu edad");
		int edad = scan.nextInt();
		String trash = scan.nextLine();
		if (edad >= 18) { 
			System.out.println("Puedes entrar");
		} else {
			if (edad >= 16) {
				System.out.println("¿Tienes permiso paterno?");
				String permiso = scan.nextLine();
				boolean entrar = permiso.equals("Sí") || permiso.equals("Si") || permiso.equals("sí") || permiso.equals("si");
				String print = entrar?"Puedes entrar":"No puedes entrar";				
				System.out.println(print);
			} else {
				System.out.println("No puedes entrar");
			}
		}
		scan.close();
	}
}