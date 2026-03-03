package treeset;

import java.util.Objects;

public class Alumno implements Comparable<Alumno> {
	private String nif, nombre;
	private int nota;

	public Alumno(String nif, String nombre, int nota) {
		this.nif = nif;
		this.nombre = nombre;
		this.nota = nota;
	}

	public Alumno() {
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

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Alumno [nif=" + nif + ", nombre=" + nombre + ", nota=" + nota + "]";
	}

	// Este se convierte automáticamente en el criterio de orden del TreeSet, salvo
	// que creemos una clase que implemente Comparator y se la pasemos como
	// parámetro al TreeSet al instanciarlo. Que es justo lo que hemos hecho (ver el
	// Main y la clase ComparadorNif). Esto nos da la ventaja de que podemos
	// establecer que el TreeSet se ordene según el dni (y por tanto, el criterio de
	// igualdad que use para insertar un nuevo objeto sea el nif), pero que nosotros
	// comparemos nuestros objetos en el contexto real según su nombre. Esto permite
	// que si hacemos un sort de alumnnos, use el nombre. Y además, si en algún
	// momento queremos hacer un sort según dni, podemos pasarle como parámetro del
	// sort la clase ComparadorNif en lugar del null
	@Override
	public int compareTo(Alumno o) {
		return this.nombre.compareTo(o.nombre);
	}

	// Como en este caso vamos a trabajar con un TreeSet en el main, no es necesario
	// implementar hashCode y equals, pues TreeSet no los va a usar en absoluto

//	@Override
//	public int hashCode() {
//		return Objects.hash(nif);
//	}
//
//	// El método equals no tiene por qué basarse en la misma propiedad que que el
//	// método compareTo (ver apuntes cuaderno 13/02/2026)
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Alumno other = (Alumno) obj;
//		return Objects.equals(nif, other.nif);
//	}

}
