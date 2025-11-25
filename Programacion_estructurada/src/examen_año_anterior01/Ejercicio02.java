package examen_año_anterior01;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean salir = false;
		boolean logged = false;
		boolean passwordExists = false;
		String password = "";
		while (!salir) {
			if (!logged) {
				System.out.println("""
						Bienvenido a Yisus Software S.L.
						Escoge una de las siguientes opciones introduciendo el número correspondiente;
						1-Establecer/cambiar contraseña
						2-Hacer login
						0-Salir
						""");
			} else {
				System.out.println("""
						Bienvenido a Yisus Software S.L.
						Escoge una de las siguientes opciones introduciendo el número correspondiente;
						1-Establecer/cambiar contraseña
						2-Hacer login
						3-Hacer logout
						0-Salir
						""");
			}
			int opcion = scan.nextInt();
			String trash = scan.nextLine();
			switch (opcion) {
			case 1:
				if (!passwordExists) {
					boolean validPassword = false;
					while (!validPassword) {
						int contadorMay = 0;
						int contadorMin = 0;
						int contadorNum = 0;
						System.out.println(
								"Introduce una contraseña válida. Debe tener al menos una mayúscula, al menos una minúscula y al menos un número");
						password = scan.nextLine();
						for (int i = 0; i < password.length(); i++) {
							if (password.charAt(i) >= 65 && password.charAt(i) <= 90) {
								contadorMay++;
							}
							if (password.charAt(i) >= 97 && password.charAt(i) <= 122) {
								contadorMin++;
							}
							if (password.charAt(i) >= 48 && password.charAt(i) <= 57) {
								contadorNum++;
							}
						}
						if (contadorMay > 0 && contadorMin > 0 && contadorNum > 0) {
							validPassword = true;
						}
					}
					passwordExists = true;
				} else {
					boolean validPassword = false;
					boolean passwordCoincide = false;
					while (!passwordCoincide) {
						System.out.println("Introduce tu contraseña actual");
						String intentoPassword = scan.nextLine();
						if (password.equals(intentoPassword)) {
							passwordCoincide = true;
						}
					}
					while (!validPassword) {
						int contadorMay = 0;
						int contadorMin = 0;
						int contadorNum = 0;
						System.out.println(
								"Introduce una contraseña válida. Debe tener al menos una mayúscula, al menos una minúscula y al menos un número");
						password = scan.nextLine();
						for (int i = 0; i < password.length(); i++) {
							if (password.charAt(i) >= 65 && password.charAt(i) <= 90) {
								contadorMay++;
							}
							if (password.charAt(i) >= 97 && password.charAt(i) <= 122) {
								contadorMin++;
							}
							if (password.charAt(i) >= 48 && password.charAt(i) <= 57) {
								contadorNum++;
							}
						}
						if (contadorMay > 0 && contadorMin > 0 && contadorNum > 0) {
							validPassword = true;
						}
					}
				}
				break;
			case 2:
				if (passwordExists) {
					boolean passwordCoincide = false;
					while (!passwordCoincide) {
						System.out.println("Introduce tu contraseña para hacer login");
						String intentoPassword = scan.nextLine();
						if (password.equals(intentoPassword)) {
							System.out.println("Contraseña introducida correctamente. Estás loggeado en el sistema");
							passwordCoincide = true;
							logged = true;
						} else {
							System.out.printf("La contraseña no coincide %n");
						}
					}
				} else {
					System.out.println("No se ha establecido ninguna contraseña previamente");
				}
				break;
			case 3:
				if (logged) {
					logged = false;
					System.out.println("Has hecho logout correctamente");
				}
				break;
			case 0:
				salir = true;
				break;
			default:
				System.out.println("La opción introducida no es válida");
				break;
			}
		}
		if (salir) {
			System.out.printf("Has salido del programa correctamente%nGracias por usar Yisus Software S.L.");
		}
		scan.close();

	}

}
