package model;

import interfaces.Rastreable;

public abstract class EnvioRastreable extends Envio implements Rastreable {
	EstadoEnvio estado = EstadoEnvio.CREADO;

	public EnvioRastreable(int codigo, double peso, String origen, String destino, EstadoEnvio estado) {
		super(codigo, peso, origen, destino);
		this.estado = estado;
	}

	public EnvioRastreable(int codigo, double peso, String origen, String destino) {
		super(codigo, peso, origen, destino);
	}

	public EnvioRastreable() {
	}

	public EstadoEnvio getEstado() {
		return estado;
	}

	public void setEstado(EstadoEnvio estado) {
		this.estado = estado;
	}

	public abstract EstadoEnvio obtenerEstado();

	public abstract void actualizarEstado(EstadoEnvio estado);

	@Override
	public double calcularCoste() {
		// TODO Auto-generated method stub
		return 0;
	}

}
