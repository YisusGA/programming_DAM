package model;

public class EnvioUrgente extends Envio implements Rastreable {
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

}
