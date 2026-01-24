package model;

import interfaces.Asegurable;

public class EnvioRefrigerado extends Envio implements Asegurable {
	private double temperatura;

	public EnvioRefrigerado(double peso, String origen, String destino, double temperatura) {
		super(peso, origen, destino);
		this.temperatura = temperatura;
	}

	public EnvioRefrigerado(double temperatura) {
		this.temperatura = temperatura;
	}

	public EnvioRefrigerado() {

	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	@Override
	public double calcularCoste() {
		double precio = 6 + 2.5 * peso;
		if (this.temperatura < 0) {
			precio += 4;
		}
		return precio;
	}

	@Override
	public double calcularCosteSeguro() {

		return 1.5 + peso * 0.8;
	}

	@Override
	public String toString() {
		return "EnvioRefrigerado [temperatura=" + temperatura + ", codigo=" + codigo + ", peso=" + peso + ", origen="
				+ origen + ", destino=" + destino + "]";
	}

}
