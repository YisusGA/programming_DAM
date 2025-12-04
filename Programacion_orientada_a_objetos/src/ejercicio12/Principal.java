package ejercicio12;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Circulo circulo = new Circulo();
		Cuadrado cuadrado = new Cuadrado();
		Esfera esfera = new Esfera();
		Cubo cubo = new Cubo();
		boolean salir = false;
		while (!salir) {
			System.out.println("""
					¿Con qué tipo de figura quieres trabajar?
					a) Círculo
					b) Esfera
					c) Cuadrado
					d) Cubo
					e) Salir del programa
					""");
			char opcion = scan.nextLine().charAt(0);
			switch (opcion) {
			case 'a':
				System.out.println("¿Cuál es el radio del círculo?");
				circulo.radio = scan.nextDouble();
				System.out.printf("""
						
						El perímetro es %.3f
						El área es %.3f
						
						""", circulo.perimetro(), circulo.area());
				scan.nextLine();
				break;
			case 'b':
				System.out.println("¿Cuál es el radio de la esfera?");
				esfera.radio = scan.nextDouble();
				System.out.printf("""
						
						La superficie es %.3f
						El volumen es %.3f
						
						""", esfera.superficie(), esfera.volumen());
				scan.nextLine();
				break;
			case 'c':
				System.out.println("¿Cuál es el lado del cuadrado?");
				cuadrado.lado = scan.nextDouble();
				System.out.printf("""
						
						El perímetro es %.3f
						El área es %.3f
						
						""", cuadrado.perimetro(), cuadrado.area());
				scan.nextLine();
				break;
			case 'd':
				System.out.println("¿Cuál es el lado del cubo?");
				cubo.lado = scan.nextDouble();
				System.out.printf("""
						
						La superficie es %.3f
						El volumen es %.3f
						
						""", cubo.superficie(), cubo.volumen());
				scan.nextLine();
				break;
			case 'e':
				salir = true;
				break;
			default:
				System.out.println("La opción introducida no es válida");
				break;
			}
		}
		System.out.println("Programa finalizado con éxito. Gracias por usar Yisus Geometry S.L.");
		scan.close();
	}

}
