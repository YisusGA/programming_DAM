package ejercicio02;

import java.util.Comparator;

public class OrdenAlfabeticoAlumnos implements Comparator<Alumno> {

	@Override
	/**
	 * Devuelve int negativo si o1 va antes que o2, 0 si están en la misma posición
	 * e int positivo si o1 va después que o2. El método compare siempre devuelve un
	 * int
	 */
	public int compare(Alumno o1, Alumno o2) {
		return o1.getNombre().toLowerCase().charAt(0) - o2.getNombre().toLowerCase().charAt(0);
	}

}
