package model;

import interfaces.Asegurable;
import interfaces.Rastreable;

public class EnvioUrgente extends Envio implements Rastreable, Asegurable {
	private double recargo;
	private EstadoEnvio estado = EstadoEnvio.CREADO;

	public EnvioUrgente(int codigo, double peso, String origen, String destino, double recargo) {
		super(codigo, peso, origen, destino);
		this.recargo = recargo;
	}

	public EnvioUrgente(double recargo) {
		this.recargo = recargo;
	}

	public EnvioUrgente() {

	}

	public double getRecargo() {
		return recargo;
	}

	public void setRecargo(double recargo) {
		this.recargo = recargo;
	}

	public EstadoEnvio getEstado() {
		return estado;
	}

	public void setEstado(EstadoEnvio estado) {
		this.estado = estado;
	}

	@Override
	public double calcularCoste() {

		return 5 + 2 * peso + recargo;
	}

	@Override
	public EstadoEnvio obtenerEstado() {
		// TODO Auto-generated method stub
		return estado;
	}

	@Override
	public void actualizarEstado(EstadoEnvio nuevoEstado) {
		this.estado = nuevoEstado;
	}

	@Override
	public double calcularCosteSeguro() {

		return 1.5 + peso * 0.8;
	}

	@Override
	public String toString() {
		return "EnvioUrgente [recargo=" + recargo + ", estado=" + estado + ", codigo=" + codigo + ", peso=" + peso
				+ ", origen=" + origen + ", destino=" + destino + "]";
	}

}
