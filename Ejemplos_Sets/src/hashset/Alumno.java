package hashset;

import java.util.Objects;

public class Alumno {
	String nif;
	Double nota;

	public Alumno(String nif, Double nota) {
		this.nif = nif;
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

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Alumno [nif=" + nif + ", nota=" + nota + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nif);
	}

	@Override
	public boolean equals(Object obj) { // Igualdad de objetos de Alumno según su nif
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(nif, other.nif);
	}

}
