package examen_año_anterior06_ejercicio02;

import java.util.Set;

public class AbonadoVIP extends Abonado {

	public AbonadoVIP(String nif, String nombre, Set<Actividad> actividades) {
		super(nif, nombre, actividades);
	}

	public AbonadoVIP(String nif, String nombre) {
		super(nif, nombre);
	}

	public AbonadoVIP() {

	}

	@Override
	public boolean registrarActvidad(Actividad actividad) {
		actividades.add(actividad);
		return actividades.add(actividad);
	}

	@Override
	public boolean cancelarActividad(String nombre) {
		Actividad aux = new Actividad(nombre);
		return actividades.remove(aux);
	}

}
