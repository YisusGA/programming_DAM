package treeset;

import java.util.Comparator;

public class ComparadorNif implements Comparator<Alumno> {

	@Override
	public int compare(Alumno o1, Alumno o2) {
		return  o1.getNif().compareTo(o2.getNif());
	}

}
