package ejercicio16;

public class Alumno {
	private String nombre;
	private Asignatura[] asignaturas;
	
	
	
	/**
	 * Método constructor de Alumno sólo con su nombre
	 * @param Nombre del alumno
	 */
	public Alumno(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método constructor de Alumno con su nombre y asignatura
	 * @param Nombre del alumno
	 * @param Asignatura asignada al alumno
	 */
	public Alumno(String nombre, Asignatura[] asignatura) {
		this.nombre = nombre;
		this.asignaturas = asignatura;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String asignaAsignatura (Asignatura asignatura) {
		if (this.asignaturas == null) {
			asignaturas = new Asignatura[1];
			this.asignaturas[0] = asignatura;
		} else {
			Asignatura[] aux = new Asignatura[this.asignaturas.length + 1];
			for (int i = 0; i < this.asignaturas.length; i++) {
				aux[i] = this.asignaturas[i];
			}
			aux[aux.length - 1] = asignatura;
			this.asignaturas = aux;
		}
		return "Asignatura creada y asignada correctamente";
	}
	
	public Asignatura[] getAsignatura() {
		return asignaturas;
	}

	public String asignaAsignatura (String nombreAsignatura, double nota, Curso curso) {
		if (this.asignaturas == null) {
			asignaturas = new Asignatura[1];
			this.asignaturas[0] = new Asignatura(nombreAsignatura, nota, curso);
		} else {
			Asignatura[] aux = new Asignatura[this.asignaturas.length + 1];
			for (int i = 0; i < this.asignaturas.length; i++) {
				aux[i] = this.asignaturas[i];
			}
			aux[aux.length - 1] = new Asignatura(nombreAsignatura, nota, curso);
			this.asignaturas = aux;
		}
		return "Asignatura añadida y evaluada correctamente";
	}
	
	public String cambiaNota(String asignatura, double nota) {
		if (this.asignaturas == null) {
			return "No existe ninguna asignatura asociada al alumno, asígnale una primero";
		} else {
			for (int i = 0; i < this.asignaturas.length; i++) {
				if (this.asignaturas[i].getNombre().equals(asignatura)) {
					this.asignaturas[i].setNota(nota);
				}
			}
			return "Nota cambiada correctamente";
		}
	}

	public String boletinNotas() {
		if (asignaturas != null) {
			String result = "Asignaturas [";
			for (int i = 0; i < asignaturas.length; i ++) {
				result += asignaturas[i].getNombre() + " -> Nota: " + asignaturas[i].getNota() + ", ";
			}
			return "Alumno [Nombre=" + nombre + "] " + result + "]";
		} else {
			return "El alumno no tiene asignada ninguna asignatura";
		}
	}
	
	
	
	
}
