package colecciones.linkedList;

public class Main {

	public static void main(String[] args) {
		MiLinkedList<String> cadenas = new MiLinkedList<>(); // Lo que realmente estamos instanciado aquí es la
																// dirección de un primer nodo, que de momento es null

		// Añadir elementos al principio de la lista
		cadenas.addFirst("Hola"); // Y aquí le añadimos el primer nodo no null a la lista, usando el método
									// addFirst(T dato) que creamos en la clase MiLinkedList
		cadenas.addFirst("Adios"); // Y aquí otro

		// Imprimir los datos de la lista
		for (int i = 0; i < cadenas.size(); i++) {
			System.out.println(cadenas.get(i));
		}
		System.out.println();

		// Añadir un elemento al final de la lista
		cadenas.addLast("Pedro");

		// Tamaño de la lista
		System.out.println("Tamaño de la lista: " + cadenas.size());
		System.out.println("*********************");
		// Imprimir los datos de la lista
		for (int i = 0; i < cadenas.size(); i++) {
			System.out.println(cadenas.get(i));
		}
		System.out.println();

		pruebaRemove(); // Probamos el método auxiliar de eliminación

	}

	// Método auxiliar para probar los casos extremos en los que eliminamos la
	// primera y la última posición
	private static void pruebaRemove() {

		MiLinkedList<String> cadenas = new MiLinkedList<>();

		// Añadimos 4 elementos
		cadenas.addFirst("Hola");
		cadenas.addFirst("Adiós");
		cadenas.addFirst("Otra");
		cadenas.addLast("Blabla");

		// Imprimir los datos de la lista
		System.out.println("Añadir elementos");
		System.out.println("****************");
		for (int i = 0; i < cadenas.size(); i++) {
			System.out.println(cadenas.get(i));
		}
		System.out.println();

		// Eliminar el elemento de la última posición
		cadenas.remove(cadenas.size() - 1);

		// Imprimir los datos de la lista
		System.out.println("Eliminar el elemento de la última posición");
		System.out.println("******************************************");
		for (int i = 0; i < cadenas.size(); i++) {
			System.out.println(cadenas.get(i));
		}
		System.out.println();

		// Eliminar el elemento de la primera posición (0)
		cadenas.remove(0);

		// Imprimir los datos de la lista
		System.out.println("Eliminar el elemento de la posición 0");
		System.out.println("*************************************");
		for (int i = 0; i < cadenas.size(); i++)
			System.out.println(cadenas.get(i));

	}

}
