package ejemploTeclado;

import teclado.TecladoOK;

public class EjemploTecladoOK {

	public static void main(String[] args) {
		System.out.println("Introduce un número decimal");
		double numDecimal = TecladoOK.leerDecimal(); //Tiene que introducirse con punto, pues lo que hace es leer una cadena y convertirla a número double. Y java
		                                           //necesita que el decimal esté puesto con punto
		
		System.out.println("Introduce un número entero");
		int numEntero = TecladoOK.leerEntero();
		
		System.out.println("Introduce cadena");
		String cadena = TecladoOK.leerCadena();
		
		System.out.printf("Has introducido %f %d %s", numDecimal, numEntero, cadena);

	}

}
