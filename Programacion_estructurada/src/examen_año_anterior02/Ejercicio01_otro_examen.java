package examen_1ev_24_25;

import java.util.Scanner;

public class Ejercicio01_otro_examen {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arraySize = 5;
		String[] palabras = new String[arraySize];
		for (int i = 0; i < palabras.length; i++) {
			System.out.println("Introduce una palabra cualquiera");
			palabras[i] = scan.nextLine();
		}
		int sumaLongitudes = 0;
		for (int i = 0; i < palabras.length; i++) {
			sumaLongitudes += palabras[i].length();
		}
		int mediaLongitudes = sumaLongitudes / palabras.length;
		int contadorCortas = 0;
		for (int i = 0; i < palabras.length; i++) {
			if (palabras[i].length() <= mediaLongitudes) {
				contadorCortas++;
			}
		}
		String[] aux = new String[contadorCortas]; 
		for (int i = 0, j = 0; i < palabras.length; i++) {
			if (palabras[i].length() <= mediaLongitudes) {
				aux[j++] = palabras[i];
			}
		}
		
		palabras = aux;
		
		boolean mostrar = true;
		String[] llave = {"soy un perro", "soy un gato", "soy un rinoceronte", "soy un mosquito", "soy un humano"};
		String word = "";
		
		for (int i = 0; i < llave.length; i++) {
			System.out.println("Introduce 5 palabras para conseguir la secuencia correcta de apertura");
			if (!(word = scan.nextLine()).equals(llave[i])) {
				mostrar = false;
				break;
			} else {
				System.out.println("Palabra correcta");
			}
		}
		if (mostrar) {
			System.out.println("La media de longitudes es: " + mediaLongitudes);
			System.out.print("Las palabras cuya longitud es no superan la longitud media son: ");
			for (String i : palabras) {
				System.out.print(i + ", ");
			}
		} else {
			System.out.println("Programa terminado, el resultado no se mostrará hasta que no introduzcas la secuencia correcta de apertura");
		}
		scan.close();
	}

}
