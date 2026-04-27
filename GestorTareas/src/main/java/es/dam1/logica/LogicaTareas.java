package es.dam1.logica;

import java.util.Iterator;

import es.dam1.data.Data;
import es.dam1.model.Tarea;

public class LogicaTareas {
	

	public LogicaTareas() {
	}

	public boolean completarTarea(int id) {
		boolean completada = false;
		for (int i = 0; i < Data.tareas.size() && !completada; i++) {
			Tarea aux = Data.tareas.get(i);
			if(aux.getId() == id) {
				aux.setCompletada(true);
				Data.tareas.set(i, aux);
				completada = true;
			}
		}
		return completada;
	}

	public boolean eliminarTarea(int id) {
		boolean eliminada = false;
		Iterator<Tarea> it = Data.tareas.iterator();
		while (it.hasNext() && !eliminada) {
			Tarea t = it.next();
			if (t.getId() == id) {
				it.remove();
				eliminada = true;
			}
		}
		return eliminada;
	}

	public void addTarea() {

	}

}
