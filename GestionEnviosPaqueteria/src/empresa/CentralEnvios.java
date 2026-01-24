package empresa;

import model.Envio;
import model.EnvioEstandar;
import model.EnvioRefrigerado;
import model.EnvioUrgente;
import model.EstadoEnvio;

public class CentralEnvios {
	Envio[] envios = new Envio[0];
	private int codigo = 0;

	public CentralEnvios(Envio[] envios) {

		this.envios = envios;
	}

	public CentralEnvios() {

	}

	public int generarCodigoPedido() {
		return this.codigo++;
	}

	public String registrarEnvio(Envio envio) {
		Envio[] aux = new Envio[envios.length + 1];
		for (int i = 0; i < envios.length; i++) {
			aux[i] = envios[i];
		}
		aux[aux.length - 1] = envio;
		envios = aux;
		return "Envio registrado correctamente";
	}

	public void listarEnvios() {
		for (int i = 0; i < envios.length; i++) {
			System.out.println(envios[i].toString());
		}
	}

	public double costeTotal() {
		double coste = 0;
		for (Envio e : envios) {
			coste += e.calcularCoste();
		}
		return coste;
	}

	public double costeTotalSeguros() {
		double coste = 0;
		for (Envio e : envios) {
			if (e instanceof EnvioUrgente) {
				coste += ((EnvioUrgente) e).calcularCosteSeguro();
			}
			if (e instanceof EnvioRefrigerado) {
				coste += ((EnvioRefrigerado) e).calcularCosteSeguro();
			}

		}
		return coste;
	}

	public String actualizarEstadoEnvio(EstadoEnvio estado, int codigo) {
		boolean encontrado = false;
		int posicion = 0;
		for (int i = 0; !encontrado && i < envios.length; i++) {
			if (envios[i].getCodigo() == codigo) {
				encontrado = true;
				posicion = i;
			}
		}
		if (encontrado) {
			if (envios[posicion] instanceof EnvioUrgente) {
				((EnvioUrgente) envios[posicion]).actualizarEstado(estado);
				return "Estado actualizado correctamente";
			}
			if (envios[posicion] instanceof EnvioEstandar) {
				((EnvioEstandar) envios[posicion]).actualizarEstado(estado);
				return "Estado actualizado correctamente";
			}
			return "Este tipo de envío no admite rastreo";
		} 
		return "Pedido no encontrado";
	}

}
