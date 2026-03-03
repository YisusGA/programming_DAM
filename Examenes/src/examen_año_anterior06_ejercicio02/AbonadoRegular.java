package examen_año_anterior06_ejercicio02;

import java.util.Set;

public class AbonadoRegular extends Abonado {
	public static int maximoActividades;

	public AbonadoRegular(String nif, String nombre, Set<Actividad> actividades) {
		super(nif, nombre, actividades);
	}
	
	public AbonadoRegular(String nif, String nombre) {
		super(nif, nombre);
	}

	public AbonadoRegular() {
	}

	public static int getMaximoActividades() {
		return maximoActividades;
	}

	public static void setMaximoActividades(int maximoActividades) {
		AbonadoRegular.maximoActividades = maximoActividades;
	}

	@Override
	public boolean registrarActvidad(Actividad actividad) {
		boolean added = false;
		if (actividades.size() < maximoActividades) {
			added = actividades.add(actividad);
		}
		return added;
	}

	@Override
	public boolean cancelarActividad(String nombre) {
		Actividad aux = new Actividad(nombre);
		return actividades.remove(aux);
	}

}
