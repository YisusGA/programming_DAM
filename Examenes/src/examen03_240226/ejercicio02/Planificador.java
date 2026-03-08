package examen03_240226.ejercicio02;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;

public class Planificador {
	private static List<Proceso> pendientes = new ArrayList<>();
	private static Set<Proceso> ejecucion = new HashSet<>();

	// Podría ser más conveniente usar un TreeSet, metiéndole como criterio de
	// ordenamiento CriterioOrdenPid, pues así el TreeSet tiene ya un orden y no
	// tenemos que usar sort cada vez que listemos los procesos en ejecución
//	private static Set<Proceso> ejecucion1 = new TreeSet<>(new CriterioOrdenPid());

	// Si sólo vamos a usar el Comparator una vez nada más, podemos declarar una
	// clase anónima, que es lo que se ve aquí debajo. Y así nos ahorramos tener
	// otra clase en nuestro proyecto si sólo la vamos a usar una vez. Si hubiera
	// que llamarla varias veces, entonces ya sí que compensa más crear la clase que
	// implemente Comparator
	
	// Ver Planificador2 para ver cómo hacerlo con el TreeSet
	
//	private static Set<Proceso> ejecucion1 = new TreeSet<>(new Comparator<Proceso>() {
//		@Override
//		public int compare(Proceso o1, Proceso o2) {
//			return o1.getPid() - o2.getPid();
//		}
//	});

	private static Scanner scan = new Scanner(System.in);
	private static int pidGenerado = 0;

	public static void main(String[] args) {
		int opcion;

		do {
			opcion = mostrarMenu();
			scan.nextLine();

			switch (opcion) {
			case 1 -> {
				int prioridad;
				do {
					System.out.println("Introduce la prioridad del proceso a añadir. Valores admitidos: [0-10]");
					prioridad = scan.nextInt();
				} while (prioridad < 0 || prioridad > 10);
				System.out.println("Introduce la duración (ms) del proceso a añadir");
				int duracion = scan.nextInt();
				System.out.println(agregarProcesoPendiente(prioridad, duracion));
			}
			case 2 -> {
				if (pendientes != null && pendientes.size() > 0) {
					System.out.println(ejecutar());
				} else {
					System.err.println("No existen procesos pendientes");
				}
			}
			case 3 -> {
				if (ejecucion != null && ejecucion.size() > 0) {
					System.out.println(listarEjecucion());
				} else {
					System.err.println("No hay procesos ejecutándose");
				}
			}
			case 4 -> {
				if (ejecucion != null && ejecucion.size() > 0) {
					System.out.println("Introduce el pid del proceso que quieres detener");
					if (abortarProceso(scan.nextInt())) {
						System.out.println("Proceso eliminado correctamente");
					} else {
						System.err.println("Proceso no encontrado");
					}
				} else {
					System.err.println("No hay procesos en ejecución");
				}
			}
			case 0 -> {
				System.out.println("Saliendo del menú...");
			}
			default -> {
				System.err.println("La opción introducida no es válida");
			}
			}
		} while (opcion != 0);
	}

	public static int mostrarMenu() {
		System.out.println("""
				Bienvenido
				Escoge una opción
				1. Agregar proceso pendiente
				2. Ejecutar proceso
				3. Listar procesos en ejeccución
				4. Abortar proceso en ejecución
				0. Salir del menú
				""");
		return scan.nextInt();
	}

	public static String agregarProcesoPendiente(int prioridad, int duracion) {
		pendientes.add(new Proceso(pidGenerado++, prioridad, duracion));
		pendientes.sort(null);
		return "Proceso agregado a lista de pendientes";
	}

	public static String ejecutar() {
		Proceso aux = pendientes.get(0);
		ejecucion.add(pendientes.get(0));
		pendientes.remove(0);

		// Esto de debajo también funcionaría
//		Proceso aux = pendientes.get(0);
//		ejecucion.add(aux);
//		pendientes.remove(aux); // Esto funcionaría aunque no hubiésemos implementado un equals. Si hemos
		// implementado equals, usaría el equals de nuestra implementación. Si no
		// hubiésemos implementado un equals, usaría el equals de Object, que compara
		// direcciones de memoria. Como a aux le hemos asignado la dirección de memoria
		// de pendientes.get(0), funcionaría, pues la dirección de memoria es la misma
		return "El proceso con pid " + aux.getPid() + " pasa a ejecutarse";
	}

	public static List<Proceso> listarEjecucion() {
		List<Proceso> aux = new ArrayList<>();
		aux.addAll(ejecucion);
		aux.sort(new CriterioOrdenPid());
		return aux;
	}

	public static boolean abortarProceso(int pid) {
		Iterator<Proceso> it = ejecucion.iterator();
		boolean eliminado = false;
		while (!eliminado && it.hasNext()) {
			Proceso p = it.next();
			if (p.getPid() == pid) {
				it.remove();
				eliminado = true;
			}
		}
		return eliminado;
	}

}
