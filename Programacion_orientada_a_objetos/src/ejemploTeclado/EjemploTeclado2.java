package ejemploTeclado;

import teclado.Teclado2;

public class EjemploTeclado2 {

	public static void main(String[] args) {
		
		System.out.println("Introduce un número decimal");
		double numDecimal = Teclado2.leerDecimal(); //Tiene que introducirse con punto, pues lo que hace es leer una cadena y convertirla a número double. Y java
		                                           //necesita que el decimal esté puesto con punto
		
		System.out.println("Introduce un número entero");
		int numEntero = Teclado2.leerEntero();
		
		System.out.println("Introduce cadena");
		String cadena = Teclado2.leerCadena();
		
		System.out.printf("Has introducido %f %d %s", numDecimal, numEntero, cadena);

	}

}
