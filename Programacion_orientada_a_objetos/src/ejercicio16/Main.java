package ejercicio16;

import java.util.Scanner;

public class Main {
	
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		Alumno alumno1 = new Alumno(null, null);
		
		Asignatura asignatura = new Asignatura(null, null);
		
		int opcion;
		
		do {
			opcion = Main.mostrarMenu();
			scan.nextLine();
			switch (opcion) {
			
			case 1 -> {
				System.out.println("Introduce el nombre del alumno");
				String nombre = scan.nextLine();
				alumno1.setNombre(nombre);
				System.out.println("Alumno añadido correctamente");
			}
			
			case 0 -> {
				System.out.println("Cerrando programa...");
			}
			
			case 2 -> {
				System.out.println("Introduce el nombre de la asignatura");
				String nombreAsignatura = scan.nextLine();
				Curso curso = null;
				boolean cursoValido = false;
				do {
					System.out.println("Introduce el curso en el que se imparte la asignatura");
					System.out.println("Valores posibles para curso: " + asignatura.consultarValoresPosiblesCurso());
					String cursoIntroducido = scan.nextLine();
					if (cursoIntroducido.equals("PRIMERO")) {
						curso = Curso.PRIMERO;
						cursoValido = true;
					} else if (cursoIntroducido.equals("SEGUNDO")) {
						curso = Curso.SEGUNDO;
						cursoValido = true;
					} else {
						System.err.println("El curso introducido no es válido");
					}
				} while (!cursoValido);
				asignatura.setNombre(nombreAsignatura);
				asignatura.setCurso(curso);
				System.out.println("Asignatura creada correctamente");
			}
			
			case 3 -> {
				System.out.println(asignatura.toString());
			}
			
			case 4 -> {
				System.out.println(alumno1.toString());
			}
			
			case 5 -> {
				if (alumno1.getNombre() != null && asignatura.getNombre() != null) {
					System.out.println(alumno1.asignaAsignatura(asignatura));
				} else if (alumno1.getNombre() == null) {
					System.err.println("Aún no se ha añadido ningún alumno");
				} else {
					System.err.println("Aún no se ha añadido nunguna asignatura");
				}
			}
			
			case 6 -> {
				if (asignatura != null && alumno1.getAsignatura() != null) {
					System.out.println("Introduce la nota de la asignatura");
					double nota = scan.nextDouble();
					asignatura.setNota(nota);
					System.out.printf("Nota asignada correctamente a %s del alumno %s%n%n", asignatura.getNombre(), alumno1.getNombre());
				} else {
					System.err.println("No existe ninguna asignatura aún");
				}
			}
			default -> {
				System.out.println("La opción introducida no es válida");
			}
			}
		} while (opcion != 0);

	}
	
	private static int mostrarMenu() {
		System.out.println("""
				1. Añadir Alumno
				2. Añade una asignatura al sistema
				3. Consultar asignatura
				4. Consultar alumno
				5. Asignar una asignatura existente a un alumno
				6. Poner nota en asignatura
				0. Salir del programa
				""");
		return scan.nextInt();
	}

}
