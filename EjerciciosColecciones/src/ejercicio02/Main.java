package ejercicio02;

import java.util.ArrayList;
import java.util.List;

import teclado.Teclado2;

public class Main {
	static List<Profesor> profesores = new ArrayList<>();

	public static void main(String[] args) {
		int opcion;

		do {
			opcion = mostrarMenu();

			switch (opcion) {
			case 1 -> {
				Profesor profesor = new Profesor();
				do {
					System.out.println("Escribe el dni del profesor, no debe existir uno igual");
					profesor.setNif(Teclado2.leerCadena());
				} while (profesores.contains(profesor)); // Parece que este contains no está usando el método equals que he sobreescrito en Profesor
				System.out.println("Escribe el nombre del profesor");
				profesor.setNombre(Teclado2.leerCadena());
			}
			case 2 -> {
				Profesor profesor;
				do {
					System.out.println("Introduce el dni del profesor, debe existir");
					profesor = devolverProfesor(Teclado2.leerCadena());
				} while (profesor != null);
				Alumno alumno = new Alumno();
				do {
					System.out.println("Escribe el dni del alumno, no debe existir uno igual");
					alumno.setNif(Teclado2.leerCadena());
				} while (profesor.getAlumnos().contains(alumno));
				System.out.println("Inserta el nombre del alumno");
				alumno.setNombre(Teclado2.leerCadena());
				profesor.addAlumno(alumno);
			}
			case 3 -> {
				Profesor profesor;
				do {
					System.out.println("Introduce el dni del profesor, debe existir");
					profesor = devolverProfesor(Teclado2.leerCadena());
				} while (profesor != null);
				Alumno alumno;
				do {
					System.out.println("Introduce el dni del alumno, debe existir");
					alumno = profesor.devolverAlumno(Teclado2.leerCadena());
				} while (alumno != null);
				double nota;
				do {
					System.out.println("Introduce la nota del alumno, debe estar comprendida entre 0 y 10");
					nota = Teclado2.leerDecimal();
				} while (nota < 0 || nota > 10);

				profesor.ponerNota(nota, alumno);

			}
			case 4 -> {
				Profesor profesor;
				do {
					System.out.println("Introduce el dni del profesor, debe existir");
					profesor = devolverProfesor(Teclado2.leerCadena());
				} while (profesor != null);
				System.out.println(profesor.porcentajeAprobados());
			}
			case 5 -> {
				// ToDo
			}
			case 6 -> {
				Profesor profesor;
				do {
					System.out.println("Introduce el dni del profesor, debe existir");
					profesor = devolverProfesor(Teclado2.leerCadena());
				} while (profesor != null);
				System.out.println(profesor.listadoOrdenadoAlumnos()); // ¿Esto funcionará así tal cual?
			}
			case 7 -> {
				Profesor profesor;
				do {
					System.out.println("Introduce el dni del profesor, debe existir");
					profesor = devolverProfesor(Teclado2.leerCadena());
				} while (profesor != null);
				Alumno alumno;
				do {
					System.out.println("Introduce el dni del alumno, debe existir");
					alumno = profesor.devolverAlumno(Teclado2.leerCadena());
				} while (alumno != null);
				profesor.eliminarAlumno(alumno);

			}
			case 0 -> {
				System.out.println("Saliendo del menú...");
			}
			default -> {
				System.err.println("La opción introducida no es válida");
			}
			}
		} while (opcion != 0);
	}

	public static int mostrarMenu() {
		System.out.println("""
				Bienvenido
				Escoge una opción
				1. Insertar profesor
				2. Agregar nuevo alumno a un profesor, con nota 0
				3. Poner nota a un alumno de un profesor
				4. Mostrar porcentaje de aprobados de un profesor
				5. Dado el nif de un alumno, mostrar los nombres de todos los profesores que lo tienen
				6. Dado el nif de un profesor, mostrar un listado ordenado alfabéticamente de sus alumnos
				7. Eliminar un alumno de un profesor
				0. Salir del menú
				""");
		return Teclado2.leerEntero();
	}

	public static Profesor devolverProfesor(String nif) {
		for (int i = 0; i < profesores.size(); i++) {
			if (profesores.get(i).getNif().equals(nif)) {
				return profesores.get(i);
			}
		}
		return null;
	}
}
