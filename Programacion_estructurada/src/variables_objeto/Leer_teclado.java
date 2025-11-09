package variables_objeto;

import java.util.Scanner;

public class Leer_teclado {

	public static void main(String[] args) {
		//En la siguiente línea, scan es una variable que declaramos como variable de tipo objeto.
		//Por lo tanto, le podemos dar otro nombre diferente a scan. Si le ponemos otro nombre, como
		//por ejemplo pepito, luego al usarla en la línea de int dato, tendría que ser:
		//int dato = pepito.nextInt();
		//Esto es así porque el nextInt() es un método que nos permite usar la variable que hemos
		//declarado como tipo objeto, pepito
		Scanner scan = new Scanner(System.in);
		System.out.println("Haz click en la consola e introduce un número entero");
		int dato = scan.nextInt();
		scan.close();
		int resultado;
		resultado = 2 * dato;
		System.out.println("Resultado: " + resultado);

	}

}
