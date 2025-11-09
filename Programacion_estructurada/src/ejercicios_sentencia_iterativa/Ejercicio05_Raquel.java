package ejercicios_sentencia_iterativa;

import java.util.Scanner;

//VAMOS A CONTAR TODOS LOS MÚLTIPLOS ENTRE DOS
//NÚMEROS LEÍDOS POR TECLADO, SIEMPRE ENTRE EL MENOR
//Y EL MAYOR
public class Ejercicio05_Raquel {

	public static void main(String[] args) {
		
		int contador = 0;
		Scanner scan = new Scanner(System.in);

		System.out.println("Valor inicial:");
		int n1 = scan.nextInt();
		System.out.println("Valor final:");
		int n2 = scan.nextInt();
		
		//SI n1 > n2, LOS TENEMOS QUE INTERCAMBIAR
		//DE TAL FORMA QUE EL MENOR VALOR ESTÉ EN
		//n1 Y EL MAYOR VALOR EN n2:
		if(n1 > n2) {
			int aux = n1;
			n1 = n2;
			n2 = aux;
		}
		
		System.out.println("Introduce un valor distinto de cero");
		int m;
		do {
			m = scan.nextInt();
			if(m == 0)
				System.out.println("No puede ser cero, intenta otra vez");
		} while (m == 0);
		
		int n = n1;
		
		//si n1 > n2, nunca entra al bucle
		while(n <= n2) {
			
			if (n % m == 0) {
				contador++;
			}
			n++;
		}
		
		System.out.println("Resultado: "+contador);
	}

}
