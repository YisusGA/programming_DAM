package examen_año_anterior05_ejercicio03;

import java.util.Objects;

public class Planta {
	private String nombreCientifico;
	private int alturaMaxima;

	public Planta(String nombreCientifico, int alturaMaxima) {
		this.nombreCientifico = nombreCientifico;
		this.alturaMaxima = alturaMaxima;
	}

	public Planta(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}

	public Planta(int alturaMaxima) {
		this.alturaMaxima = alturaMaxima;
	}

	public Planta() {
	}

	public String getNombreCientifico() {
		return nombreCientifico;
	}

	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}

	public int getAlturaMaxima() {
		return alturaMaxima;
	}

	public void setAlturaMaxima(int alturaMaxima) {
		this.alturaMaxima = alturaMaxima;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombreCientifico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planta other = (Planta) obj;
		return Objects.equals(nombreCientifico, other.nombreCientifico);
	}

	@Override
	public String toString() {
		return "Planta [nombreCientifico=" + nombreCientifico + ", alturaMaxima=" + alturaMaxima + "]";
	}

}
