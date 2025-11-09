package ejercicios_sentencia_de_decision;

/**
 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56 mostrar: cincuenta y seis
 */

import java.util.Scanner;

public class Ejercicio31 {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		System.out.println("Introduce un número entero comprendido entr 0 y 99");
		int n = scan.nextInt();
		scan. close();
		int decenas = n / 10;
		int unidades = n % 10;
		//Inicializamos las variables String para el nombre de las unidades y de las decenas, para luego poder asignarle
		//el valor que toque en función del case dentro del switch que corresponda
		String nombreUnidades = "";
		String nombreDecenas = "";
		
		//Asignamos de forma general el nombre que va a recibir el String nombreUnidades en función del número que sea la unidad
		switch (unidades) {
		case 0:
			nombreUnidades = "cero";
			break;
		case 1:
			nombreUnidades = "uno";
			break;
		case 2:
			nombreUnidades = "dos";
			break;
		case 3:
			nombreUnidades = "tres";
			break;
		case 4:
			nombreUnidades = "cuatro";
			break;
		case 5:
			nombreUnidades = "cinco";
			break;
		case 6:
			nombreUnidades = "seis";
			break;
		case 7:
			nombreUnidades = "siete";
			break;
		case 8:
			nombreUnidades = "ocho";
			break;
		case 9:
			nombreUnidades = "nueve";
			break;
		}	
		
		//Asignamos de forma general el nombre que va a recibir el String nombreDecenas en función del número que sea la decena
		switch (decenas) {
		case 1:
			nombreDecenas = "dieci";
			break;
		case 2:
			nombreDecenas = "veinti";
			break;
		case 3:
			nombreDecenas = "treinta y ";
			break;
		case 4:
			nombreDecenas = "cuarenta y ";
			break;
		case 5:
			nombreDecenas = "cincuenta y ";
			break;
		case 6:
			nombreDecenas = "sesenta y ";
			break;
		case 7:
			nombreDecenas = "setenta y ";
			break;
		case 8:
			nombreDecenas = "ochenta y ";
			break;
		case 9:
			nombreDecenas = "noventa y ";
			break;
		}
		
		//Consideramos los casos en los que el número se salga del rango [0-99], para mostrar un mensaje de error
		if (n < 0 || n > 99) {
			System.err.println("ERROR: el número introducido debe estar comprendido entre 0 y 99");
			return;
			//Consideramos el caso de que el número esté en el rango [0-9], y le asignamos los nombres que generamos en el switch-case
			//del nombreUnidades
		} else if (n >= 0 && n < 10) {
			
			System.out.println("El número introducido se lee como: " + nombreUnidades);
			
			//Consideramos los casos únicos de que el número esté en el rango [10-15], pues tienen nombres únicos
		} else if (n >= 10 && n <= 15) {
			switch (unidades) {
			case 0:
				System.out.println("El número introducido se lee como: diez");
				break;
			case 1:
				System.out.println("El número introducido se lee como: once");
				break;
			case 2:
				System.out.println("El número introducido se lee como: doce");
				break;
			case 3:
				System.out.println("El número introducido se lee como: trece");
				break;
			case 4:
				System.out.println("El número introducido se lee como: catorce");
				break;
			case 5:
				System.out.println("El número introducido se lee como: quince");
				break;
			}	
		//Consideramos el caso de los números a partir del 20 (incluid) que acaban en 0, porque tienen nombres únicos
		} else {
			if (n % 10 == 0) {
				switch (decenas) {
				case 2:
					System.out.println("El número introducido se lee como veinte");
					break;
				case 3:
					System.out.println("El número introducido se lee como treinta");
					break;
				case 4:
					System.out.println("El número introducido se lee como cuarenta");
					break;
				case 5:
					System.out.println("El número introducido se lee como cincuenta");
					break;
				case 6:
					System.out.println("El número introducido se lee como sesenta");
					break;
				case 7:
					System.out.println("El número introducido se lee como setenta");
					break;
				case 8:
					System.out.println("El número introducido se lee como ochenta");
					break;
				case 9:
					System.out.println("El número introducido se lee como noventa");
					break;
				}
				//En cualquiera de los otros casos (número [16-99] que no acabe en 0), concatenamos el nombreDecenas con el
				//nombreUnidades
			} else {
				System.out.println("El número introducido se lee como: " + nombreDecenas + nombreUnidades);
			}
		}
	}

}
