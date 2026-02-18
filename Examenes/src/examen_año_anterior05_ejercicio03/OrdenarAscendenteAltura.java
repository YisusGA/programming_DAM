package examen_año_anterior05_ejercicio03;

import java.util.Comparator;

public class OrdenarAscendenteAltura implements Comparator<Planta> {

	@Override
	public int compare(Planta o1, Planta o2) {
		return o1.getAlturaMaxima() - o2.getAlturaMaxima();
	}

}
