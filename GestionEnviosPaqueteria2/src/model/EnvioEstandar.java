package model;

public class EnvioEstandar extends EnvioRastreable {
	private int diasEstimados;

	public EnvioEstandar(int codigo, double peso, String origen, String destino, int diasEstimados,
			EstadoEnvio estado) {
		super(codigo, peso, origen, destino, estado);
		this.diasEstimados = diasEstimados;
	}
	
	public EnvioEstandar(int codigo, double peso, String origen, String destino, int diasEstimados) {
		super(codigo, peso, origen, destino);
		this.diasEstimados = diasEstimados;
	}

	public EnvioEstandar(int diasEstimados) {
		super();
		this.diasEstimados = diasEstimados;
	}

	public EnvioEstandar() {
		super();
	}

	public int getDiasEstimados() {
		return diasEstimados;
	}

	public void setDiasEstimados(int diasEstimados) {
		this.diasEstimados = diasEstimados;
	}

	public EstadoEnvio getEstado() {
		return estado;
	}

	public void setEstado(EstadoEnvio estado) {
		this.estado = estado;
	}

	@Override
	public double calcularCoste() {
		double precio = 3 + peso * 1.2;
		if (diasEstimados <= 2) {
			precio += 2.5;
		}
		return precio;
	}

	@Override
	public EstadoEnvio obtenerEstado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarEstado(EstadoEnvio nuevoEstado) {
		this.estado = nuevoEstado;

	}

	@Override
	public String toString() {
		return "EnvioEstandar [diasEstimados=" + diasEstimados + ", estado=" + estado + ", codigo=" + codigo + ", peso="
				+ peso + ", origen=" + origen + ", destino=" + destino + "]";
	}

}
