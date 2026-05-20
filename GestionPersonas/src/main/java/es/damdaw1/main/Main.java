package es.damdaw1.main;

import java.util.Scanner;

import es.damdaw1.logica.Operaciones;
import es.damdaw1.modelo.Persona;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int op;
		
		do {
			System.out.println("1. Insertar nueva persona");
			System.out.println("2. Recuperar persona");
			System.out.println("3. Recupera personas por nombre");
			System.out.println("4. Recupera personas mayores de edad por nombre");
			System.out.println("0. Salir");
			op = Integer.parseInt(scan.nextLine());
			switch(op) {
				case 1 -> {
					System.out.println("Nombre:");
					String nombre = scan.nextLine();
					System.out.println("Edad:");
					int edad = Integer.parseInt(scan.nextLine());
					if(Operaciones.insertPersona2(new Persona(edad,nombre)))
						System.out.println("Se insertó correctamente");
					else
						System.out.println("Error de inserción");
				}
				case 2 -> {
					System.out.println("Dame id:");
					int id = Integer.parseInt(scan.nextLine());
					Persona p = null;
					if( (p = Operaciones.getPersona(id)) != null ){
						System.out.println(p);
						
					}else {
						System.out.println("No existe nadie con ese id");
					}
				}
				case 3 -> {
					System.out.println("Dame nombre:");
					String nombre = scan.nextLine();
					for(Persona p : Operaciones.getPersonasByNombre2(nombre))
						System.out.println(p);
				}
				case 4 -> {
					System.out.println("Dame nombre:");
					String nombre = scan.nextLine();
					for(Persona p : Operaciones.getPersonasMayoresEdadByNombre(nombre))
						System.out.println(p);
				}
			}
			
		}while(op != 0);
		
		scan.close();

	}

}
