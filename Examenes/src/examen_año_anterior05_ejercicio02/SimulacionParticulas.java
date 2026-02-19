package examen_año_anterior05_ejercicio02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 public class SimulacionParticulas {
    
    Scanner scanner;
    
    List<Particula> particulas = new ArrayList<>();

    public SimulacionParticulas() {
        
        scanner = new Scanner(System.in);
    }

    public void ejecutar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner
            switch (opcion) {
                case 1:
                    agregarParticula();
                    break;
                case 2:
                    buscarPorRangoMasa();
                    break;
                case 3:
                    eliminarPorPosicion();
                    break;
                case 4:
                    particulaMaxMasa();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("\n--- Simulador de Partículas ---");
        System.out.println("1. Agregar partícula");
        System.out.println("2. Buscar por rango de masa");
        System.out.println("3. Eliminar por posición");
        System.out.println("4. Buscar partícula con más masa");
        System.out.println("0. Salir");
        System.out.print("Ingrese una opción: ");
    }

    private void agregarParticula() {
        System.out.println("Carga: (int)");
        int carga = scanner.nextInt();
        System.out.println("Masa: (double)");
        double masa = scanner.nextDouble();
        System.out.println("Posición x: (double)");
        double x = scanner.nextDouble();
        System.out.println("Posición y: (double)");
        double y = scanner.nextDouble();        
        particulas.add(new Particula(carga, masa, new Punto(x, y)));        
        System.out.println("Partícula agregada.");
    }


    private List<Particula> buscarPorRangoMasa() {
    	List<Particula> lista=null;
        System.out.print("Rango de masa (min): (double) ");
        double minMasa = scanner.nextDouble();
        System.out.print("Rango de masa (max): (double) ");
      //TODO: buscar todas las particulas que entren el rango de masa proporcionado,
        //guardalas en una List y devolverla
        return lista;
    }

    private void eliminarPorPosicion() {
        System.out.print("Posición para eliminar (x): (double)");
        double x = scanner.nextDouble();
        System.out.print("Posición para eliminar (x): (double)");
        double y = scanner.nextDouble();
        Punto posicion = new Punto(x, y);
      //TODO: usando el método proporcionado para calcular distancias entre dos puntos,
        //encontrar la particula más cercana al punto proporcionado y quitarla de la colección
        //de particulas
    }

    private double calcularDistancia(Punto p1, Punto p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }


    private void particulaMaxMasa() {
    	
    	//TODO: mostrar la particula con max Masa
    	
        
    }

    public static void main(String[] args) {
        SimulacionParticulas simulacion = new SimulacionParticulas();
        simulacion.ejecutar();
    }
}
