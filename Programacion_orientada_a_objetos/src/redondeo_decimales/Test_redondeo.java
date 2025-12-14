package redondeo_decimales;

import java.util.Scanner;

public class Test_redondeo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número decimal");
		double numeroDecimal = scan.nextDouble();
		int numeroCifrasDecimales;
		System.out.println("Introduce el número de cifras decimales a las que quieres redondear");
		while ((numeroCifrasDecimales = scan.nextInt()) < 0) {
			System.out.println("Debes introducir un número mayor o igual a 0");
		} 
		Redondeo_decimales redondeo = new Redondeo_decimales(numeroCifrasDecimales); 
		System.out.println("El número redondeado es: " + redondeo.redondeador(numeroDecimal));
		scan.close();		
	}

}
