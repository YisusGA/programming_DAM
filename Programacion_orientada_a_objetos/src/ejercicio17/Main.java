package ejercicio17;

import java.util.Scanner;
import ejercicio17.Agenda;

public class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		Agenda agenda = new Agenda();
		
		int opcion;
		do {
			opcion = Main.mostrarMenu();
			scan.nextLine();
			
			switch(opcion) {
			
			case 1 -> {
				System.out.println("Introduce el nombre de la persona a agregar");
				String nombre = scan.nextLine();
				System.out.println("Introduce la dirección de la persona a agregar");
				String direccion = scan.nextLine();
				System.out.println("Introduce la edad de la persona a agregar");
				int edad = scan.nextInt();
				Persona persona = new Persona(nombre, edad, direccion);
				System.out.println(agenda.agregarPersona(persona));
				System.out.println();
			}
			
			
			case 2 -> {
				boolean hayPersonas = false;
				System.out.println("La lista de personas registradas en la agenda es la siguiente:");
				System.out.println(agenda.obtenerInformacion(agenda.obtenerConteoDePersonas()));
				if (agenda.obtenerConteoDePersonas() > 0) {
					hayPersonas = true;
				}
				if (hayPersonas) {
					System.out.println("Introduce el nombre de la persona a eliminar");
					String nombreEliminar = scan.nextLine();
					System.out.println(agenda.eliminarPersona(nombreEliminar));
				}
				System.out.println();
			}
			
			case 3 -> {
				System.out.printf("Hay %d personas registradas en la agenda%n%n", agenda.obtenerConteoDePersonas());
			}
			
			case 4 -> {
				System.out.println("La lista de personas registradas en la agenda es la siguiente:");
				System.out.println(agenda.obtenerInformacion(agenda.obtenerConteoDePersonas()));
				System.out.println();
			}
			
			case 0 -> {
				System.out.println("Finalizando programa...");
			}
			
			default -> {
				System.out.println("La opción introducida no es válida");
			}
			}
		} while (opcion != 0);
		

	}
	
	private static int mostrarMenu() {
		System.out.println("""
				Bienvenido a Yisus Agenda App
				¿Qué acción desea realizar?
				1. Agregar persona a la agenda
				2. Eliminar persona de la agenda
				3. Contar cuántas personas hay registradas en la agenda
				4. Obtener un listado de las personas registradas en la agenda
				0. Salir del sistema
				""");
		return scan.nextInt();
	}

}
