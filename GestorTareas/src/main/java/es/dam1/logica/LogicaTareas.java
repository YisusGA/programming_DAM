package es.dam1.logica;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Iterator;

import es.dam1.data.Data;
import es.dam1.model.Tarea;

public class LogicaTareas {

	public LogicaTareas() {
	}

	public static void completarTarea(int id) {
		boolean completada = false;
		
		for (int i = 0; i < Data.tareas.size() && !completada; i++) {
			Tarea aux = Data.tareas.get(i);
			if (aux.getId() == id) {
				aux.setCompletada(!aux.isCompletada()); // Esto invierte el valor que tenga el boolean
				Data.tareas.set(i, aux);
				completada = true;
			}
		}
		// Hacer lo mismo con programación funcional
//		Data.tareas.stream().filter(x -> x.getId() == id).forEach(x -> x.isCompletada());
	}

	public static boolean eliminarTarea(int id) {
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

	public static boolean addTarea(String nombre, String descripcion, String fecha) {
		boolean added = false;
		if (!nombre.isBlank() && !fecha.isBlank()) {
			try {
				LocalDate fechaParseada = LocalDate.parse(fecha);
				Data.tareas.add(new Tarea(nombre.trim(), descripcion.trim(), fechaParseada));
				added = true;
			} catch (DateTimeParseException ex) {
				System.err.println("Formato de fecha no valido");
			}
		}
		return added;
	}

}
