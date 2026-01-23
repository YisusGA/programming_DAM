package model;

public class EnvioRefrigerado extends Envio {
	private double temperatura;

	public EnvioRefrigerado(int codigo, double peso, String origen, String destino, double temperatura) {
		super(codigo, peso, origen, destino);
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
		double precio =  6 + 2.5 * peso;
		if (this.temperatura < 0) {
			precio += 4; 
		}
		return precio;
	}

}
