package ejercicios_sentencia_de_decision;

/* DESCRIPCIÓN:
 * El usuario introduce el día, mes y año de 2 fechas.
 * Y se muestra información sobre cada una de las fechas.
 * 
 * FUNCIONES:
 * 
 * - Después de introducir una fecha pidiendo día, mes y año:
 * 
 * 1. Comprobar que la fecha sea correcta (en caso contrario, error)
 * 2. Mostrar si el año de la fecha es bisiesto
 * 3. Mostrar si el año de la fecha hay Mundial de fútbol
 * 4. Mostrar si el año de la fecha hay Eurocopa de fútbol
 * 5. Mostrar siguiente día de la fecha 
 * 
 * - Después de introducir 2 fechas:
 * 
 * 1. Mostrar los días de diferencia entre ambas
 * 
 * 
 * REQUERIMIENTOS:
 * - Cada mes debe tener sus días respectivos
 * y los años bisiestos deben tenerse en cuenta para febrero
 * - Preferiblemente usar métodos para reutilizarse a futuro
 * - El máximo de fechas son 2 (de momento porque me da pereza poner más)   
 */
import java.util.Scanner;

public class Ejercicio29_2_Alberto {
	// Main method
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Introduce DIA fecha 1: ");
		int diaFecha1 = scan.nextInt();
		
		System.out.print("Introduce MES fecha 1: ");
		int mesFecha1 = scan.nextInt();
		
		System.out.print("Introduce AÑO fecha 1: ");
		int anyoFecha1 = scan.nextInt();
		
		System.out.print("\nIntroduce DIA fecha 2: ");
		int diaFecha2 = scan.nextInt();
		
		System.out.print("Introduce MES fecha 2: ");
		int mesFecha2 = scan.nextInt();
		
		System.out.print("Introduce AÑO fecha 2: ");
		int anyoFecha2 = scan.nextInt();
		
		scan.close();
		
		
		// Comprobar si las fechas son correctas
		boolean fecha1Valida = fechaCorrecta(diaFecha1, mesFecha1, anyoFecha1);
		boolean fecha2Valida = fechaCorrecta(diaFecha2, mesFecha2, anyoFecha2);
		
		if (!fecha1Valida)
			System.err.println("Error: Fecha 1 no válida");
		if (!fecha2Valida)
			System.err.println("Error: Fecha 2 no válida");
		
		if (!fecha1Valida || !fecha2Valida)
			return;
		
		// Calcular diferencia de dias entre FECHA1 y FECHA2
		int diferenciaDias = Math.abs((fechaADias(diaFecha1, mesFecha1, anyoFecha1) - fechaADias(diaFecha2, mesFecha2, anyoFecha2)));
		
		// Print
		printFechaInfo(diaFecha1, mesFecha1, anyoFecha1);
		printFechaInfo(diaFecha2, mesFecha2, anyoFecha2);
		
		System.out.printf("%nDiferencia de días entre %d-%d-%d y %d-%d-%d: %d días", diaFecha1, mesFecha1, anyoFecha1, diaFecha2, mesFecha2, anyoFecha2, diferenciaDias);
	}
	
	
	// Módulos
	
	
	// Imprime una tarjeta de información sobre cada fecha
	static void printFechaInfo(int diaFecha, int mesFecha, int anyoFecha) {
		System.out.printf("%n---------------------");
		System.out.printf("%nFECHA: %d-%d-%d", diaFecha, mesFecha, anyoFecha);
		System.out.printf("%n---------------------");
		System.out.printf("%nBisiesto: %s", esBisiesto(anyoFecha) ? "si" : "no");
		System.out.printf("%nHay/hubo Mundial: %s", hayMundial(anyoFecha) ? "si" : "no");
		System.out.printf("%nHay/hubo Eurocopa: %s", hayEurocopa(anyoFecha) ? "si" : "no");
		System.out.printf("%nDía siguiente: %s", diaSiguiente(diaFecha, mesFecha, anyoFecha));
	}	
	
	
	// Comprueba que la fecha sea correcta y que los dias no sobrepasen el limite de cada mes
	// Devuelve 'false' siempre que la fecha sea INCORRECTA
	public static boolean fechaCorrecta(int dia, int mes, int anyo) {
		if (dia < 1 || mes < 1 || mes > 12 || anyo < 0) 
			return false;
		
		switch (mes) {
			case 4: case 6: case 9: case 11: // meses 30 dias
				return dia <= 30; // Devuelve 'false' si el mes es MAYOR a 30
			case 2: // Febrero
				if (esBisiesto(anyo))
					return dia <= 29;
				else
					return dia <= 28;
			default: // meses 31 dias
					return dia <= 31;
		}
}
	// Calcula si el año introducido es bisiesto
	public static boolean esBisiesto(int anyo) {
		return anyo % 400 == 0 || (anyo % 4 == 0 && anyo % 100 != 0); // Devuelve 'true' si el año introducido es bisiesto
	}
	
	// Calcula si hay/ha habido Europca en el año introducido
	public static boolean hayMundial(int anyo) {
		return (anyo >= 1930) && (Math.abs(anyo - 1930) % 4 == 0); // Devuelve 'true' si en el año introducido hay/hubo mundial
	}
	
	// Calcula si hay/ha habido Europca en el año introducido
	public static boolean hayEurocopa(int anyo) {
		return (anyo >= 1960) && (Math.abs(anyo - 1960) % 4 == 0); // Devuelve 'true' si en el año introducido hay/hubo mundial
	}
	
	// Convierte el mes y año de cada fecha en días 
	public static int fechaADias(int dia, int mes, int anyo) {
	    int total = 0;
	    
	    switch (mes) {
	        case 1: total += 0; break;// Enero
	        case 2: total += 31; break;// Febrero
	        case 3: total += 31 + 28; break;// Marzo
	        case 4: total += 31 + 28 + 31; break;// Abril
	        case 5: total += 31 + 28 + 31 + 30; break; // Mayo
	        case 6: total += 31 + 28 + 31 + 30 + 31; break; // Junio
	        case 7: total += 31 + 28 + 31 + 30 + 31 + 30; break; // Julio
	        case 8: total += 31 + 28 + 31 + 30 + 31 + 30 + 31; break; // Agosto
	        case 9: total += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31; break; // Septiembre
	        case 10: total += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30; break; // Octubre
	        case 11: total += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31; break; // Noviembre
	        case 12: total += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30; break; // Diciembre
	    }
	    
	    // Añadir dias y años
	    total += dia;
	    total += anyo * 365;
	    total += cuentaBisiestos(anyo); // Añadir años bisiestos
	    
	    return total; // Devuelve la fecha completa convertida en días
	}
	
	// Calcula el dia siguiente teniendo en cuenta bisiestos, cambios de mes y año
	public static String diaSiguiente(int dia, int mes, int anyo) {
		switch (mes) {
			case 4, 6, 9, 11 -> { // meses 30 días
				if (dia == 30) {
					dia = 1;
					mes++;
				} else dia++;
		}
			case 2 -> { // Febrero
				int limite = esBisiesto(anyo) ? 29 : 28;
				if (dia == limite) {
					dia = 1;
					mes++;
				} else dia++;
			}
			default -> { // meses 31 dias
				if (dia == 31 && mes == 12) {
					dia = 1;
					mes = 1;
					anyo++;
				} else if (dia == 31) {
					dia = 1;
					mes++;
				} else dia++;
			}
		}
		return String.format("%d-%d-%d", dia, mes, anyo); // Devuelve el día siguiente convertido en String
	}


	// Devuelve los dias a sumar por cada año bisiesto desde el año 0 hasta el año introducido
	public static int cuentaBisiestos(int anyo) {
		return anyo / 4 - anyo / 100 + anyo / 400; // Devuelve los dias a sumar
	}
	
	
/* POSTDATA para Yisus:
 * He intentado hacerlo lo más parecido posible a lo que sabemos de clase.
 * Pero es bastante un mierda hacer esto sin módulos, así que es lo único fuera del temario actual de clase que he usado (creo)
 * 
 * Sería mucho más bonito (y reutilizable) usar clases, porque crearías una clase llamada 'fecha', con 3 ints que son 'dia' 'fecha' y 'anyo'
 * Y ya no tendría que escribir (diaFecha1, mesFecha1, anyoFecha1) cada que vez que quieras usar la fecha para algo. 
 * O tampoco tendrías que llama las variables (d1, m1, a1) porque son variables bastante ambiguas
 * 
 * Otra cosa que me ha costado es no usar bucles, porque para tareas como la de contar cuantos días EXACTOS 
 * hay desde el 01/01 hasta el 01/07. (Tareas muy repetitivas de escribir) son muy muy utiles los bucles. 
 * Pero yo he hecho la psicopatada de sumar cada uno de los dias de cada mes a mano para evitarme usarlos xdd. 
 * Que putas ganas de dar bucles, modulos y programacion orientada a objetos en clase dios mio jajaja.
*/
	
}
