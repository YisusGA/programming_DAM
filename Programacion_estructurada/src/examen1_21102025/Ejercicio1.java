package examen1_21102025;

import java.util.Scanner;

public class Ejercicio1 {

public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("Introduce tu edad");
	int edad = scan.nextInt();
	System.out.println("Introduce el precio original del producto");
	double precio = scan.nextDouble();
	scan.close();
	double precioFinal = edad >= 65 ? precio * 0.85 : precio;
	//En el examen, pedía mostrar el número con dos decimales, así había que hacer el proceso de casting que está
	//aquí debajo para dejar el número con 2 cifras decimales
	int precioFinalIntermedio = (int)(precioFinal * 100); //Cuidado aquí, hay que poner paréntesis en la operación,
														  //pues si no, haría el casting de la variable y luego
														  //la operación, y se perderían los decimales.
	double precioFinalRedondeado = (double)precioFinalIntermedio / 100;
	//También se podría poner como se ve debajo. Al menos uno de los 2 números tiene que ser decimal para que haga división de decimales
	//double precioFinalRedondeado = precioFinalIntermedio / 100.0;
	System.out.println("El precio final es: " + precioFinalRedondeado + " euros");
	}

}
