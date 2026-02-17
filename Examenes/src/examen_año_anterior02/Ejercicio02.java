package examen_año_anterior02;

import java.util.Scanner;

public class Ejercicio02 {
	
	static Scanner scan = new Scanner(System.in);

	//Método main
	public static void main(String[] args) {
		
		//Arrays de apertura. Los números que introduzca el usuario deben coincidir exactamente con estos arrays
		int[] keyArray1 = {4, -4, 7 ,9};
		int[] keyArray2 = {7, -3, 7 , 10, 4, -1};
		
		//Suponemos que los números introducidos van a coincidir. Si no lo hacen, se asigna un false al boolean
		boolean validKey1 = true;
		boolean validKey2 = true;
		
		//Leemos los números y comprobamos si coinciden uno por uno con el array de apertura 1. 
		//En cuanto uno no coincida, se sale del bucle y se asigna false al boolean
		for (int i = 0; validKey1 == true && i < keyArray1.length; i++) {
			int n;
			System.out.println("Introduce un número entero para el array llave 1");
			if ((n = scan.nextInt()) != keyArray1[i]) {
				validKey1 = false;
			}
		}
		
		//Leemos los números y comprobamos si coinciden uno por uno con el array de apertura 2. 
		//En cuanto uno no coincida, se sale del bucle y se asigna false al boolean
		for (int i = 0; validKey1 == true && validKey1 == true && i < keyArray2.length; i++) {
			int n;
			System.out.println("Introduce un número entero para el array llave 2");
			if ((n = scan.nextInt()) != keyArray2[i]) {
				validKey2 = false;
			}
		}
		
		//Si ambos booleans son true, entonces llamamos al método devolverMaximo
		if (validKey1 && validKey2) {
			System.out.println("Clave introducida correctamente, puedes proseguir");
			int[] maxArray = devolverMaximo();
			
//			Esta sería la forma de trabajar con el método devolverMaximo() si no lo hemos hecho static
//			Ejercicio02 array = new Ejercicio02();
//			int[] maxArray = array.devolverMaximo();
			
			//Imprimimos el contenido del array con el valor máximo mayor, el cual es devuelto por el método devolverMaximo
			System.out.print("El contenido del array con el valor máximo mayor es: ");
			for (int i : maxArray) {
				System.out.print(i + ", ");
			}
			System.out.println();
			System.out.println("Programa finalizado con éxito");
		} else {
			System.err.println("Los arrays llave no son correctos, programa finalizado");
		}
	}
	
	/**
	 * 
	 * @return De dos arrays leídos por teclado, devuelve el que tiene el valor máximo mayor de los 2; si son iguales, devuelve el array 1
	 */
	private static int[] devolverMaximo() { //Como no depende de las propiedades de la clase Ejercicio01, lo declaramos static y así no tenemos que crear un objeto de la
		                                    //clase Ejercicio02 para luego llamar al método con objeto.devolverMaximo(). Si no lo declaramos static, dará error al usarlo en el main,
											//a menos que creemos un "objeto" de la clase Ejercicio02 para luego llamar al método con objeto.devolverMaximo()
		int arraySize = 5;
		int[] array1 = new int[arraySize];
		int[] array2 = new int[arraySize];
		
		//Llenamos el array1 y sacamos su máximo
		int maxArray1 = Integer.MIN_VALUE;
		for (int i = 0; i < array1.length; i++) {
			System.out.println("Introduce un número entero para el array 1");
			array1[i] = scan.nextInt();	
			if (array1[i] > maxArray1) {
				maxArray1 = array1[i];
			}
		}
		
		//Llenamos el array2 y sacamos su máximo
		int maxArray2 = Integer.MIN_VALUE;
		for (int i = 0; i < array2.length; i++) {
			System.out.println("Introduce un número entero para el array 2");
			array2[i] = scan.nextInt();	
			if (array2[i] > maxArray1) {
				maxArray2 = array2[i];
			}
		}
		
		//Comprobamos cuál de los 2 arrays tiene el valor máximo mayor, y ese es el que devolverá el método
		if (maxArray1 == maxArray2 || maxArray1 > maxArray2) {
			System.out.println("El array con el valor máximo mayor es el 1");
			return array1;
		} else {
			System.out.println("El array con el valor máximo mayor es el 2");
			return array2;
		}
	}

}
