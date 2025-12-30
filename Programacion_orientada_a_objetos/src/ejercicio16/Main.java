package ejercicio16;

import java.util.Scanner;

public class Main {
	
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		Alumno alumno1 = new Alumno(null, null);
		
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
			
			case 2 -> {
				if (alumno1.getNombre() == null) {
					System.err.println("No se ha añadido ningún alumno aún");
				} else {	
					Asignatura asignatura = new Asignatura(null, null);
					System.out.println("Introduce el nombre de la asignatura");
					asignatura.setNombre(scan.nextLine());
					boolean cursoValido = false;
					do {
						System.out.println("Introduce el curso en el que se imparte la asignatura");
						System.out.printf("Valores posibles para curso:%nPRIMERO%nSEGUNDO%n");
						String cursoIntroducido = scan.nextLine();
						if (cursoIntroducido.equals("PRIMERO")) {
							asignatura.setCurso(Curso.PRIMERO);
							cursoValido = true;
						} else if (cursoIntroducido.equals("SEGUNDO")) {
							asignatura.setCurso(Curso.SEGUNDO);
							cursoValido = true;
						} else {
							System.err.println("El curso introducido no es válido");
						}
					} while (!cursoValido);
					System.out.println(alumno1.asignaAsignatura(asignatura));
				}
			}
			
			//Esta opción es muy parecida a la anterior, con la diferencia de que usa el otro método constructor que se pide
			//en el ejercicio, y además añade la nota al crear y asignar la asignatura al alumno
			case 3 -> {
				if (alumno1.getNombre() == null) {
					System.err.println("No se ha añadido ningún alumno aún");
				} else {	
					System.out.println("Introduce el nombre de la asignatura");
					String nombreAsignatura = scan.nextLine();
					Curso curso = null;
					boolean cursoValido = false;
					do {
						System.out.println("Introduce el curso en el que se imparte la asignatura");
						System.out.printf("Valores posibles para curso:%nPRIMERO%nSEGUNDO%n");
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
					System.out.println("Introduce la nota del alumno en esta asignatura");
					double nota = scan.nextDouble();
					System.out.println(alumno1.asignaAsignatura(nombreAsignatura, nota, curso));
				}
			}

			case 4 -> {
				if (alumno1.getNombre() == null) {
					System.err.println("No se ha añadido ningún alumno aún");
				} else {	
					System.out.println("Asignaturas en las que está matriculado el alumno");
					System.out.println(alumno1.boletinNotas());
					System.out.println("¿De qué asignatura quieres cambiar la nota?");
					String asignatura = scan.nextLine();
					System.out.println("¿Cuál es la nueva nota de la asignatura?");
					double nota;
					while ((nota = scan.nextDouble()) < 0) {
						System.err.println("La nota introducida debe ser mayor o igual que 0");
					}
					alumno1.cambiaNota(asignatura, nota);
				}
			}
			
			case 5 -> {
				if (alumno1.getNombre() == null) {
					System.err.println("No se ha añadido ningún alumno aún");
				} else {
					System.out.println(alumno1.boletinNotas());
				}
			}
			
			case 0 -> {
				System.out.println("Cerrando programa...");
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
				2. Crea una asignatura y añádela al alumno (sin nota)
				3. Añadir los datos de una asignatura y su nota a un alumno
				4. Poner/cambiar nota en asignatura del alumno
				5. Consultar datos del alumno
				0. Salir del programa
				""");
		return scan.nextInt();
	}

}
