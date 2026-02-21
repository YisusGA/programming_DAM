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
				List<Particula> aux = buscarPorRangoMasa();
				if (aux.size() > 0) {
					System.out.println(aux);
				} else {
					System.err.println("No hay partículas añadidas");
				}
				break;
			case 3:
				boolean eliminada = eliminarPorPosicion();
				if (eliminada) {
					System.out.println("Partícula eliminada");
				} else {
					System.err.println("No hay partículas añadidas");
				}
				break;
			case 4:
				Particula particula = particulaMaxMasa();
				if (particula != null) {
					System.out.println(particula);
				} else {
					System.err.println("No hay partículas añadidas");
				}

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
		List<Particula> lista = new ArrayList<>();
		System.out.print("Rango de masa (min): (double) ");
		double minMasa = scanner.nextDouble();
		System.out.print("Rango de masa (max): (double) ");
		double maxMasa = scanner.nextDouble();
		for (Particula i : particulas) {
			if (i.getMasa() >= minMasa && i.getMasa() <= maxMasa) {
				lista.add(i);
			}
		}
		return lista;
	}

	// Como en este caso no me interesa establecer un criterio de igualdad en la
	// clase Particula, la forma que tengo de eliminar un elemento sin usar remove()
	// es encontrarlo mediante un for clasico que itere sobre la lista. Es importante
	// usar particulas.get(i) para poder seleccionar la particula de la posición del
	// index i del for, pues al ser una lista y no un array, no se puede escribir
	// como particulas[i]. Y luego ya accedo a las propiedades o métodos que quiera
	// de ese elemento particula.get(i). Y cuando lo haya encontrado, entrará en el
	// if y guardará la posición en la variable index que he declarado antes del
	// método for. Y luego ya fuera del bucle, puedo usar el método remove(int
	// index), que elimina un elemento de la lista según su posición
	private boolean eliminarPorPosicion() {
		if (particulas != null && particulas.size() > 0) {
			System.out.print("Posición para eliminar (x): (double)");
			double x = scanner.nextDouble();
			System.out.print("Posición para eliminar (y): (double)");
			double y = scanner.nextDouble();
			Punto posicion = new Punto(x, y);
			double menorDistancia = Double.MAX_VALUE;
			int index = -1;
			for (int i = 0; i < particulas.size(); i++) {
				if (calcularDistancia(particulas.get(i).getPosicion(), posicion) < menorDistancia) {
					index = i;
				}
			}
			particulas.remove(index);
			return true;
		} else {
			return false;
		}
	}

	private double calcularDistancia(Punto p1, Punto p2) {
		return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
	}

	private Particula particulaMaxMasa() {
		if (particulas != null && particulas.size() > 0) {
			Particula max = particulas.getFirst();
			for (Particula i : particulas) {
				if (i.getMasa() > max.getMasa()) {
					max = i;
				}
			}
			return max;
		} else {
			return null;
		}

	}

	public static void main(String[] args) {
		SimulacionParticulas simulacion = new SimulacionParticulas();
		simulacion.ejecutar();
	}
}
