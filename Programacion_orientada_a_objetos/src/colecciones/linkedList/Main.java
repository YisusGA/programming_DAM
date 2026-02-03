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

		// Imprimir los datos de la lista
		for (int i = 0; i < cadenas.size(); i++) {
			System.out.println(cadenas.get(i));
		}
		System.out.println();

		// Eliminar un elemento de una posición
		cadenas.remove(1);
		
		// Imprimir los datos de la lista
		for (int i = 0; i < cadenas.size(); i++) {
			System.out.println(cadenas.get(i));
		}
		System.out.println();
		
		System.out.println(cadenas.size());
		
		// Eliminar un elemento de la última posición
		cadenas.remove(cadenas.size() - 1); //Revisar esto
				
		// Imprimir los datos de la lista
		for (int i = 0; i < cadenas.size(); i++) {
			System.out.println(cadenas.get(i));
		}
		System.out.println();

	}

}
