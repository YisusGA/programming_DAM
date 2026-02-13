package treeset;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	private static Set<Alumno> alumnos = new TreeSet<>(new ComparadorNif()); // Tenemos que haber implementado la clase
																				// Alumno, o pasarle un comparador como
																				// parámetro. Ver explicación en el
																				// compareTo(Alumno o) de Alumno

	public static void main(String[] args) {

		insertAlumno(new Alumno("1234", "pepe", 10));
		System.out.println(listadoAlumnos());
		insertAlumno(new Alumno("5678", "pepe", 8));
		insertAlumno(new Alumno("9999", "aaaa", 6));
		System.out.println("Nuevo listado");
		System.out.println(listadoAlumnos());

		List<Alumno> alumnosLista = new LinkedList<>();
		alumnosLista.addAll(alumnos);

		alumnosLista.sort(null);

		System.out.println("Listado ordenado de alumnos"); // Esto usa el compareTo de Alumno, que usa el nif
		for (Alumno a : alumnosLista) {
			System.out.println(a + "");
		}

	}

	private static void insertAlumno(Alumno a) {
		alumnos.add(a);
	}

	private static String listadoAlumnos() {
		String listado = "";
		for (Alumno a : alumnos) {
			listado += (a + "\n");
		}
		return listado;
	}

}
