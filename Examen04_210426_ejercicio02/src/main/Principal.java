package main;

import java.util.Scanner;

import gestion.GestorPrestamos;

public class Principal {

    public static void main(String[] args) {
        // 1. Instanciamos el objeto GestorPrestamos (asumiendo que se llama así)
        GestorPrestamos gp = new GestorPrestamos();
        
        // 2. Cargamos los préstamos previos al iniciar
        gp.cargaPrestamos();

        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        // 3. Bucle del menú
        do {
            System.out.println("\n=== MENÚ DE GESTIÓN DE PRÉSTAMOS ===");
            System.out.println("1 - Prestar");
            System.out.println("2 - Devolver");
            System.out.println("3 - Lista préstamos no devueltos");
            System.out.println("0 - Salir");
            System.out.print("Seleccione una opción: ");

            try {
                // Leemos como String y parseamos para evitar problemas con el buffer del Scanner
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, introduzca un número válido.");
                continue; // Vuelve al inicio del bucle
            }

            // 4. Lógica de cada opción
            switch (opcion) {
                case 1:
                    System.out.print("Introduzca el DNI del usuario: ");
                    String dni = scanner.nextLine();
                    
                    System.out.print("Introduzca el ISBN del libro: ");
                    String isbn = scanner.nextLine();
                    
                    gp.presta(dni, isbn);
                    break;
                    
                case 2:
                    System.out.print("Introduzca el ID del préstamo a devolver: ");
                    try {
                        int idPrestamo = Integer.parseInt(scanner.nextLine());
                        gp.devuelve(idPrestamo);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: El ID debe ser un número entero.");
                    }
                    break;
                    
                case 3:
                    // He corregido ligeramente el nombre del método para incluir la 'u' (Devueltos)
                    gp.listaPrestamosNoDevueltos();
                    break;
                    
                case 0:
                    System.out.println("Guardando los datos en el fichero...");
                    gp.guardaPrestamos();
                    System.out.println("Saliendo del programa. ¡Hasta pronto!");
                    break;
                    
                default:
                    System.out.println("Opción no reconocida. Por favor, elija una opción del 0 al 3.");
            }
            
        } while (opcion != 0);

        // Cerramos el scanner al finalizar el programa
        scanner.close();
    }
}