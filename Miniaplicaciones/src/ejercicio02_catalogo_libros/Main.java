package ejercicio02_catalogo_libros;

import java.util.ArrayList;
import java.util.List;

import teclado.TecladoOK;

public class Main {

	public static void main(String[] args) {
		int opcion;
		do {
			opcion = mostrarMenu();
			switch (opcion) {
			case 1 -> {
				Libro libro = new Libro();
				System.out.println("Introduce el ISBN");
				libro.setIsbn(TecladoOK.leerCadena());
				System.out.println("Introduce el título");
				libro.setTitulo(TecladoOK.leerCadena());
				System.out.println("Introduce el autor");
				libro.setAutor(TecladoOK.leerCadena());
				GestorLibros.addLibro(libro);
			}
			case 2 -> {
				List<Libro> aux = new ArrayList<>();
				if ((aux = GestorLibros.mostrarCatalogo()) != null) {
					System.out.println(aux);
				} else {
					System.err.println("No hay libros en el catálogo");
				}
			}
			case 3 -> {
				System.out.println("Saliendo del programa...");

			}
			default -> {
				System.err.println("La opción escogida no es válida");
			}
			}
		} while (opcion != 3);

	}

	public static int mostrarMenu() {
		System.out.println("""
				Bienvenido. Escoge una opción
				1. Añadir libro
				2. Mostrar catálogo
				3. Salir
				""");
		return TecladoOK.leerEntero();
	}

}
