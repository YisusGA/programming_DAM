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
		return (contador / alumnos.size()) * 100;
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

	public boolean tieneAlumno(Alumno alumno) {
		return alumnos.contains(alumno);
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
	public List<Alumno> listadoOrdenadoAlumnosv1() {
		if (alumnos.size() > 1) {
			List<Alumno> aux = new ArrayList<>();
			for (Alumno a : alumnos) {
				aux.add(a);
			}
			Alumno min = aux.getFirst();
			for (int i = 0; i < aux.size(); i++) {
				for (int j = i + 1; j < aux.size(); j++) {
					if (aux.get(j).getNombre().toLowerCase().charAt(0) < aux.get(i).getNombre().toLowerCase()
							.charAt(0)) {
						min = aux.get(j);
						aux.set(j, aux.get(i));
						aux.set(i, min);
					}

				}
			}
			return aux;
		} else if (alumnos.size() == 1) {
			return alumnos;
		} else {
			return null;
		}
	}

	public List<Alumno> listadoOrdenadoAlumnosv2() {
		if (alumnos != null) { // En este caso, sabemos que alumnos nunca va a ser null, pues hemos
								// inicializado la lisa. Pero tenemos que pensar que mi método podría ser usado
								// por otra persona en otro contexto, y podría ser que su lista pudiera ser
								// null. Así que lo ideal, es meter siempre un comprobador de si mi lista es
								// null o no
			if (alumnos.size() > 1) {
				List<Alumno> aux = new ArrayList<>();
				for (Alumno a : alumnos) {
					aux.add(a);
				}
				aux.sort(null); // Si lo dejamos en null, usa el comparador que tengan los objetos que estemos
								// comparando (en este caso, el compareTo() que hemos sobreescrito en Alumno. Si
								// lo dejamos en null y no hemos sobreescrito el método compareTo(), nos va a
								// dar un error
				return aux;
//		} else if (alumnos.size() == 1) { // Esto no hace falta hacerlo, porque si sólo hay 1 elemento, sort() automáticamente no hace nada
//			return alumnos;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public List<Alumno> listadoOrdenadoDescendenteNotas() {
		// Para pasar un criterio específico, necesitamos un objeto de tipo comparator
		alumnos.sort(new CriterioNotaDescendente()); // Aquí, pasamos como parámetro de sort un objeto de nuestra clase CriterioNotaDescendente
		return alumnos;
	}

	@Override
	public String toString() {
		return "Profesor [nif=" + nif + ", nombre=" + nombre + "]";
	}

}
