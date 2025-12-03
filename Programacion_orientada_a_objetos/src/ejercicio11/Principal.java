package ejercicio11;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Cuenta cuentaYisus = new Cuenta();
		System.out.println("Introduce el nombre del titular de la cuenta");
		cuentaYisus.titular = scan.nextLine();
		System.out.println("Introduce la cantidad de dinero que tienes en la cuenta");
		while ((cuentaYisus.cantidad = scan.nextInt()) <= 0) {
			System.out.println("La cantidad introducida no es válida, debe ser mayor que 0");
		}
		while (cuentaYisus.cantidad > 0) {
			System.out.println("""
					¿Qué operación deseas realizar?
					-Introduce 0 para ingresar efectivo
					-Introduce 1 para retirar efectivo
					""");
			int operacion = scan.nextInt();
			switch (operacion) {
			case 0:
				System.out.println("¿Qué cantidad deseas ingresar?");
				double cantidadIngresar = scan.nextInt();
				cuentaYisus.ingresar(cantidadIngresar);
				break;
			case 1:
				System.out.println("¿Qué cantidad deseas retirar?");
				double cantidadRetirar = scan.nextInt();
				cuentaYisus.retirar(cantidadRetirar);
				break;
			default:
				System.out.println("La operación solicitada no es válida");
				break;
			}
			System.out.printf("Tu saldo actual es: %.2f %n %n", cuentaYisus.cantidad);
		}
		System.out.println("Te has quedado pelado, la cantidad de dinero en tu cuenta es: " + cuentaYisus.cantidad);
		scan.close();
	}

}
