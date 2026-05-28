package es.damdaw1.main;

import java.util.List;
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
			System.out.println("5. Eliminar persona");
			System.out.println("6. Actualiza persona");
			System.out.println("0. Salir");
			op = Integer.parseInt(scan.nextLine());
			switch (op) {
			case 1 -> {
				System.out.println("Nombre:");
				String nombre = scan.nextLine();
				System.out.println("Edad:");
				int edad = Integer.parseInt(scan.nextLine());
				int personasInsertadas = Operaciones.insertPersona2(new Persona(edad, nombre));
				System.out.println(personasInsertadas + " personas insertadas");
			}
			case 2 -> {
				System.out.println("Dame id:");
				int id = Integer.parseInt(scan.nextLine());
				Persona p = null;
				if ((p = Operaciones.getPersona(id)) != null) {
					System.out.println(p);

				} else {
					System.err.println("No existe nadie con ese id");
				}
			}
			case 3 -> {
				System.out.println("Dame nombre:");
				String nombre = scan.nextLine();
				List<Persona> listaPersonas = Operaciones.getPersonasByNombre2(nombre);
				if (listaPersonas.size() > 0) {
					System.out.println("""
							
							Se recuperaron estas personas:
							------------------------------
							
							""");
					listaPersonas.stream().forEach(p -> System.out.println(p));
				} else {
					System.err.println("No se encontró ninguna persona con ese nombre en la base de datos");
				}
			}
			case 4 -> {
				System.out.println("Dame nombre:");
				String nombre = scan.nextLine();
				List<Persona> listaPersonas = Operaciones.getPersonasMayoresEdadByNombre(nombre);
				if (listaPersonas.size() > 0) {
					System.out.println("""
							
							Se recuperaron estas personas:
							------------------------------
							
							""");
					listaPersonas.stream().forEach(p -> System.out.println(p));
				} else {
					System.err.println("No se encontró ninguna persona mayor de edad con ese nombre en la base de datos");
				}
			}
			case 5 -> {
				System.out.println("Dame id:");
				int id = Integer.parseInt(scan.nextLine());
				int personasEliminadas = Operaciones.deletePersona(id);
				System.out.println(personasEliminadas + " personas insertadas");
			}
			case 6 -> {
				System.out.println("Dame id:");
				int id = Integer.parseInt(scan.nextLine());
				System.out.println("Nombre:");
				String nombre = scan.nextLine();
				System.out.println("Edad:");
				int edad = Integer.parseInt(scan.nextLine());
				int result = Operaciones.updatePersona(new Persona(id, edad, nombre));
				System.out.println(result + " personas actualizada(s)");
			}
			case 0 -> {
				System.out.println("Finalizando programa...");
			}
			default -> {
				System.err.println("La opción introducida no es válida");
			}
			}

		} while (op != 0);

		scan.close();

	}

}
