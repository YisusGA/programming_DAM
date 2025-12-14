package ejercicio15;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// Leemos los parámetros de inicialización de las propiedades del objeto que
		// instanciaremos de partitura
		System.out.println("Quién es el autor de la partitura");
		String autor = scan.nextLine();
		System.out.println("¿Para qué instrumento se ha compuesto la partitura?");
		String instrumento = scan.nextLine();
		System.out.println("Cuál es el tempo de la partitura");
		int tempo = scan.nextInt();
		String trash = scan.nextLine();

		// Instanciamos Patitura
		Partitura partitura1 = new Partitura(autor, instrumento, tempo);

		boolean salir = false;

		while (!salir) {
			System.out.println("""
					¿Qué acción deseas realizar?
					a-Aumentar el tempo en 10
					b-Reducir el tempo en 10
					c-Cambiar de instrumento
					d-Añadir un nuevo instrumento
					e-Contar el número de instrumentos
					f-Mostrar un resumen de los parámetros actuales de la partitura
					g-Salir
					""");
			char opcion = scan.nextLine().charAt(0);
			switch (opcion) {
				case 'a' -> {
					System.out.printf("%n%n%s%n%n", partitura1.aumentaTempo());
				}
				case 'b' -> {
					System.out.printf("%n%n%s%n%n", partitura1.reduceTempo());
				}
				case 'c' -> {
					System.out.println("¿Por qué instrumento quieres cambiarlo?");
					System.out.printf("%n%n%s%n%n", partitura1.cambiaInstrumento(scan.nextLine()));
				}
				case 'd' -> {
					System.out.println("¿Qué instrumento quieres añadir?");
					System.out.printf("%n%n%s%n%n", partitura1.addInstrumento(scan.nextLine()));
				}
				case 'e' -> {
					System.out.println(partitura1.cuentaInstrumentos());
				}
				case 'f' -> {
					System.out.println("La partitura tiene los siguientes parámetros actualmente: " + partitura1.toString());
				}
				case 'g' -> {
					salir = true;
				}
				default -> {
					System.err.println("La opción escogida no es válida");
				}
			}
		}
		if (salir) {
			System.out.printf("%n%nPrograma finalizado correctamente, gracias por usar Yisus Music Associated S.L.");
		}
		scan.close();

	}

}
