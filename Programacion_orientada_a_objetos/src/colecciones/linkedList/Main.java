package colecciones.linkedList;

public class Main {

	public static void main(String[] args) {
		MiLinkedList<String> cadenas = new MiLinkedList<>();
		
		cadenas.addFirst("Hola");
		cadenas.addFirst("Adios");
		for (int i = 0; i < cadenas.size; i++) {
			System.out.println(cadenas.get(i));
		}

	}

}
