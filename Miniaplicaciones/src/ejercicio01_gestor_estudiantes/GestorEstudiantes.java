package ejercicio01_gestor_estudiantes;

import java.util.ArrayList;
import java.util.List;

public class GestorEstudiantes {
	static List<Estudiante> estudiantes = new ArrayList<>();

	public static String addEstudiante(Estudiante estudiante) {
		estudiantes.add(estudiante);
		return "Estudiante añadido correctamente";
	}

	public static String listarEstudiantes() {
		if (estudiantes != null && estudiantes.size() > 0) {
		String list = "";
		for (Estudiante e : estudiantes) {
			list += e;
		}
		return list;
		}
		return "No hay estudiantes en la base de datos";
	}

	public static Estudiante buscarEstudiante(String nombre) {
		if (estudiantes != null && estudiantes.size() > 0) {
			Estudiante aux = new Estudiante(nombre);
			for (Estudiante i : estudiantes) {
				if (i.equals(aux)) {
					return i;
				}
			}
		}
		return null;
	}

	public static List<Estudiante> mostrarEstudiantesAprobados() {
		List<Estudiante> aprobados = new ArrayList<>();
		boolean hay = false;
		for (Estudiante i : estudiantes) {
			if (i.getNotaMedia() != null && i.getNotaMedia() >= 5) {
				aprobados.add(i);
				hay = true;
			}
		}
		if (hay) {
			return aprobados;
		}
		return null;
	}

}
