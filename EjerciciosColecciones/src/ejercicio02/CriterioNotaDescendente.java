package ejercicio02;

import java.util.Comparator;

public class CriterioNotaDescendente implements Comparator<Alumno> { // Comparator es una interface funcional, lo que
																		// quiere decir que tiene únicamente 1 método
																		// abstracto

	@Override
	/**
	 * Devuelve int negativo si o1 va antes que o2, 0 si están en la misma posición
	 * e int positivo si o1 va después que o2
	 */
	public int compare(Alumno o1, Alumno o2) {
		return (int) (o2.getNota() - o1.getNota());
	}

}
