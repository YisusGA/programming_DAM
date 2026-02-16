package ejercicio01_gestor_estudiantes;

import teclado.Teclado2;

import java.util.ArrayList;
import java.util.List;

import ejercicio01_gestor_estudiantes.GestorEstudiantes;

public class Main {

	public static void main(String[] args) {

		int opcion;
		do {
			opcion = mostrarMenu();

			switch (opcion) {
			case 1 -> {
				Estudiante estudiante = new Estudiante();
				System.out.println("Introduce el nombre del estudiante");
				estudiante.setNombre(Teclado2.leerCadena());
				int edad;
				do {
					System.out.println("Introduce una edad válida: [3-100]");
					edad = Teclado2.leerEntero();
				} while (edad < 3 || edad > 100);
				double nota;
				do {
					System.out.println("Introduce una nota válida: [0-10]");
					nota = Teclado2.leerEntero();
				} while (nota < 0 || nota > 10);
				estudiante.setNotaMedia(nota);
				GestorEstudiantes.addEstudiante(estudiante);
			}
			case 2 -> {
				System.out.println(GestorEstudiantes.listarEstudiantes());
			}
			case 3 -> {
				Estudiante aux = new Estudiante();
				System.out.println("Introduce el nombre del estudiante");
				String nombre = Teclado2.leerCadena();
				aux = GestorEstudiantes.buscarEstudiante(nombre);
				if (aux != null) {
					System.out.println(aux);
				} else {
					System.err.println("No se ha encontrado el estudiante");
				}

			}
			case 4 -> {
				List<Estudiante> list = new ArrayList<>();
				list = GestorEstudiantes.mostrarEstudiantesAprobados();
				if (list != null) {
					System.out.println(list);
				} else {
					System.err.println("No hay estudiantes en la base de datos");
				}
			}
			case 5 -> {
				System.out.println("Saliendo del programa...");
			}
			default -> {
				System.err.println("La opción introducida no es válida");
			}
			}
		} while (opcion != 5);

	}

	public static int mostrarMenu() {
		System.out.println("""
				Bienvenido. Escoge una opción
				1. Añadir estudiante
				2. Listar estudiantes
				3. Buscar estudiante por nombre
				4. Mostrar estudiantes aprobados
				5. Salir
				""");

		return Teclado2.leerEntero();
	}

}
