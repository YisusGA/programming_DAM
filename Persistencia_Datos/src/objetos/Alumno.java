package objetos;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Alumno implements Serializable { // Serializable es una interface sin métodos. Únicamente tiene la función
												// de decirle a la JVM que tiene permiso para serializar objetos de
												// nuestra clase
	private String nif, nombre;
	private static int generadorCodigoMatricula = 0;
	private Matricula matricula;

	public Alumno(String nif, String nombre) { // Cuando creamos un alumno, su matrícula comienza siendo null. Y luego
												// usamos el método de matricularle
		this.nif = nif;
		this.nombre = nombre;
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

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nif);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(nif, other.nif);
	}

	public void matricularAlumno() {
		Scanner scan = new Scanner(System.in);
		List<String> modulos = new LinkedList<>();
		String modulo;
		do {
			System.out.println("Introduce módulo");
			if (!(modulo = scan.nextLine()).equals("fin")) {
				modulos.add(modulo);
			}
		} while (!modulo.equals("fin"));
		this.matricula = new Matricula();
		matricula.setCodigo(generadorCodigoMatricula++);
		matricula.setModulos(modulos);
	}

	@Override
	public String toString() {
		return "Alumno [nif=" + nif + ", nombre=" + nombre + ", matricula=" + matricula + "]";
	}

}
