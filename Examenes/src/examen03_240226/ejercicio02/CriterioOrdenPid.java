package examen03_240226.ejercicio02;

import java.util.Comparator;

public class CriterioOrdenPid implements Comparator<Proceso> {

	@Override
	public int compare(Proceso o1, Proceso o2) {
		return o1.getPid() - o2.getPid();
	}

}
