package ejercicio02;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Profesor {
	private String nif, nombre;
	private List<Alumno> alumnos = new ArrayList<>();

	public Profesor(String nif, String nombre, List<Alumno> alumnos) {
		this.nif = nif;
		this.nombre = nombre;
		this.alumnos = alumnos;
	}

	public Profesor(String nif, String nombre) {
		this.nif = nif;
		this.nombre = nombre;
	}

	public Profesor(String nif) {
		this.nif = nif;
	}

	public Profesor() {
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public void addAlumno(Alumno alumno) {
		alumnos.addLast(alumno);
	}

	public double porcentajeAprobados() {
		int contador = 0;
		for (Alumno i : alumnos) {
			if (i.aprobado()) {
				contador++;
			}
		}
		return ((double) contador / alumnos.size()) * 100;
	}

	public boolean ponerNota(double nota, Alumno alumno) {
		boolean esta = false;
		int posicion = 0;
		for (int i = 0; !esta && i < alumnos.size(); i++) {
			if (alumnos.get(i).equals(alumno)) {
				esta = true;
				posicion = i;
			}
		}
		if (esta) {
			alumnos.get(posicion).setNota(nota);
		}

		return esta;

	}

	public boolean eliminarAlumno(Alumno alumno) {

		return alumnos.remove(alumno);
	}

	public Alumno devolverAlumno(String nif) {
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getNif().equals(nif)) {
				return alumnos.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		return Objects.equals(nif, other.nif);
	}

	// Aunque esto es funcional, debería haber una forma más sencilla de hacer esto
	public List<Alumno> listadoOrdenadoAlumnos() {
		if (alumnos.size() > 1) {
			List<Alumno> aux1 = new ArrayList<>();
			for (Alumno a : alumnos) {
				aux1.add(a);
			}
			Alumno min = aux1.getFirst();
			for (int i = 0; i < aux1.size(); i++) {
				for (int j = i + 1; j < aux1.size(); j++) {
					if (aux1.get(j).getNombre().toLowerCase().charAt(0) < aux1.get(i).getNombre().toLowerCase()
							.charAt(0)) {
						min = aux1.get(j);
						aux1.set(j, aux1.get(i));
						aux1.set(i, min);
					}

				}
			}
			return aux1;
		} else if (alumnos.size() == 1) {
			return alumnos;
		} else {
			return null;
		}
	}

}
