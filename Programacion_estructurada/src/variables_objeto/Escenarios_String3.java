package variables_objeto;
import java.util.Scanner;

//En esta clase, vamos a ver que el orden de el escaneo de teclado importa cuando se está
//trabajando escaneando una variable String y una variable numérica. Esto se debe a una
//particularidad sobre cómo funciona el método Scanner

public class Escenarios_String3 {
	public static void main(String[] args) {
		Scanner escaneito = new Scanner(System.in);
		System.out.println("Introduzca un número");
		int num1 = escaneito.nextInt();
		//Si escaneamos primero el número, lo que va a suceder es que la variable String 
		//siguiente automáticamente va a escanear y almacenar una línea vacía. Esto se debe
		//a que el método que se usa para escanear un String es un nextLine(). La forma en que 
		//funciona el Scanner es leyendo el último dato del tipo que le hemos pedido que tenía 
		//en el buffer. Como le pedimos una línea, y tras introducir el número le hemos dado
		//a Enter, lo que tiene en buffer es una línea vacía. E introduce eso, que automáticamente 
		//es un valor false en el boolean que hemos declarado debajo. Hay una forma de solucionar 
		//esto además de cambiar el nombre. Mirar un poco más abajo. 
		//Esto no sucede así cuando escaneamos primero el String y luego el número, pues al escanear
		//el número, el método que usamos es nextInt(), que busca específicamente el último número entero
		//en el buffer, no la última línea
		System.out.println("Introduzca su nombre");
		String nombre1 = escaneito.nextLine();
		int numCar1 = nombre1.length();
		boolean caracteres1 = numCar1 > num1;
		System.out.println(caracteres1);
		
		//Si queremos escanear primero el número y luego el String y que no lea y almacene una línea vacía
		//dentro de nuestra variable String, la forma de proceder es declarar una variable String "basura" entre
		//el número y la variable String que realmente nos importa. De esta forma, la línea vacía se "tira a la basura"
		//y podemos almacenar el Strin que realmente nos interesa
		System.out.println("Introduzca un número");
		int num2 = escaneito.nextInt();
		String trash = escaneito.nextLine();
		System.out.println("Introduzca su nombre");
		String nombre2 = escaneito.nextLine(); 
		int numCar2 = nombre2.length();
		boolean caracteres2 = numCar2 > num2;
		System.out.println(caracteres2);
		escaneito.close();
	}
}