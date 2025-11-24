package ejercicios_arrays;

/**
 * Sistema de gestión de alumnos. 
 * El programa está hecho con un array más grande que el necesario pensando en un futuro programa que pueda leer un array con valores ya almacenados y se quiera añadir nuevos alumnos en él
 */

import java.util.Scanner;

public class Ejercicio28 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int alumnosSize = 20; //Tamaño máximo permitido para la clase de alumnos
		String[] alumnos = new String[alumnosSize]; //Array donde vamos a almacenar los nombres de los alumnos
		double[] notaMedia = new double[alumnosSize]; //Array donde vamos a almacenar la nota media de cada alumno
		
		//Leemos cuántos alumnos nuevos se quieren introducir. En esta versión del programa, los arrays comienzan estando vacíos, y los datos nuevos van a ser los únicos que pueblen el array 
		System.out.println("¿Cuántos alumnos quieres introducir?");
		int numeroAlumnosNuevos = scan.nextInt();
		String trash = "";
		
		//Leemos los nombres de cada alumno y su respectiva nota media. Almacenamos cada tipo de dato en un array diferente, con posiciones correlativas entre ellos
		for (int i = 0, j = 0; j < numeroAlumnosNuevos; i++) {
			if (alumnos[i] == null) {
				trash = scan.nextLine();
				System.out.println("Introduce el nombre del alumno");
				alumnos[i] = scan.nextLine();
				System.out.println("Introduce su nota media, separando los decimales con coma");
				notaMedia[i] = scan.nextDouble();
				j++;
			}
		}
		
		//Mostramos cuántos alumnos se han añadido a la lista
		System.out.println();
		System.out.println("Se han añadido " + numeroAlumnosNuevos + " alumnos nuevos");
		
		
		//Eliminamos las posiciones que quiera el usuario de los arrays de alumnos y notaMedia. Para eliminarlas, añadimos el valor null en el caso del array de alumnos, y 0 en el caso del array de notaMedia 
		System.out.println();
		int contadorAlumnosEliminados = 0;
		trash = scan.nextLine();
		System.out.println("¿Quieres eliminar algún alumno?");
		String eliminar = scan.nextLine();
		if (eliminar.equals("Sí") || eliminar.equals("Si") || eliminar.equals("sí") || eliminar.equals("si")) {
			int posicionEliminar = 0;
			while (posicionEliminar >= 0 && posicionEliminar <= 19) {
				//Mostramos todos los alumnos que hay en la lista, excluyendo las posiciones vacías(null). Mostramos la posición física de cada alumno dentro del array, contando los null también
				System.out.println("La lista de alumnos junto a sus posiciones es la siguiente:");
				int posicionArray = 0;
				for (String i : alumnos) {
						if (i != null) {
							System.out.println(posicionArray + "-" + i + ", ");
						}
						posicionArray++;
				}
				System.out.println("Qué posición quieres eliminar. Introduce -1 si ya no quieres eliminar más alumnos");
				posicionEliminar = scan.nextInt();
				if (posicionEliminar >= 0 && posicionEliminar <= 19) {
					alumnos[posicionEliminar] = null;
					notaMedia [posicionEliminar] = 0;
					contadorAlumnosEliminados++;
				}
			}
			
			//Mostramos cuántos alumnos se han eliminado y cómo queda la lista actualmente
			System.out.println("Contador de alumnos eliminados: " + contadorAlumnosEliminados);
			System.out.print("La lista de alumnos actual es: ");
			for (String i : alumnos) {
				if (!(i == null)) {
					System.out.print(i + ", ");
				}
			}
		}
		trash = scan.nextLine();
		System.out.println();
		
		//Consulta de la posición del alumno cuyo nombre se introduce
		System.out.println("¿Quieres consultar en qué posición está un alumno?");
		String consultar = scan.nextLine();
		if (consultar.equals("Sí") || consultar.equals("Si") || consultar.equals("sí") || consultar.equals("si")) {
			String nombre = "";
			while (!nombre.equals("stop")) {
				boolean aparece = false;
				System.out.println("Introduce el nombre del alumno a consultar. Introduce stop si quieres parar la consulta");
				nombre = scan.nextLine();
				for (int i = 0; i < alumnos.length && !nombre.equals("stop"); i++) {
					if (!(alumnos[i] == null) && alumnos[i].equals(nombre)) {
						System.out.println("La posición del alumno introducido es: " + i);
						aparece = true;
					}
				}
				if (!aparece && !nombre.equals("stop")) {
					System.err.println("El nombre introducido no figura en la lista");
				}
			}
		}
		
		//Leemos una nota media introducida por teclado
		System.out.println("Introduce la nota media de consulta");
		double notaMediaConsulta = scan.nextDouble();
		
		//Mostramos los nombres de los alumnos cuya nota media es superior a la introducida
		System.out.print("Estos alumnos tienen una nota media superior a la consultada: ");
		for (int i = 0; i < notaMedia.length; i++) {
			if (notaMedia[i] > notaMediaConsulta && alumnos[i] != null) {
				System.out.print(alumnos[i] + ", ");
			}
		}
		
		System.out.println();
		
		//Mostramos los nombres de los alumnos cuya nota media es inferior a la introducida
		System.out.print("Estos alumnos tienen una nota media inferior a la consultada: ");
		for (int i = 0; i < notaMedia.length; i++) {
			if (notaMedia[i] < notaMediaConsulta && alumnos[i] != null) {
				System.out.print(alumnos[i] + ", ");
			}
		}
		
		//Mostramos un mensaje de finalización del programa
		System.out.printf("%n %n");
		System.out.println("Programa finalizado con éxito, gracias por usar Yisus School Services");
		scan.close();
	}

}
