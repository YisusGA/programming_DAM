package model;

public abstract class Envio {
	protected int codigo;
	protected double peso;
	protected String origen, destino;

	public Envio(double peso, String origen, String destino) {
		this.peso = peso;
		this.origen = origen;
		this.destino = destino;
	}

	public Envio() {
	}

	public int getCodigo() {
		return codigo;
	}

	private void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	@Override
	public String toString() {
		return "Envio [codigo=" + codigo + ", peso=" + peso + ", origen=" + origen + ", destino=" + destino + "]";
	}

	public abstract double calcularCoste();

}
