package ejercicio02;

import java.util.Comparator;

public class OrdenAlfabeticoAlumnos implements Comparator<Alumno> {

	@Override
	public int compare(Alumno o1, Alumno o2) {
		return o1.getNombre().compareToIgnoreCase(o2.getNombre()); // Usamos el compareTo de Strings para ordenarlas
	}

}
