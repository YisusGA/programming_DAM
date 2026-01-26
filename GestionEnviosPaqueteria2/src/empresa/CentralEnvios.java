package empresa;

import model.Envio;
import model.EnvioRefrigerado;
import model.EnvioUrgente;
import model.EstadoEnvio;
import repositorio.RepositorioEnvios;

public class CentralEnvios {

	public CentralEnvios() {

	}

	public static String addEnvio(Envio envio) {
		RepositorioEnvios.addEnvio(envio);
		return "Envio registrado correctamente";
	}

	public static String registrarEnvio() {
		return RepositorioEnvios.registrarEnvio();
	}

	public static void listarEnvios() {
		for (Envio e : RepositorioEnvios.findAll())
			System.out.println(e);
	}

	public static double costeTotal() {
		double coste = 0;
		for (Envio e : RepositorioEnvios.findAll()) {
			coste += e.calcularCoste();
		}
		return coste;
	}

	public static double costeTotalSeguros() {
		double coste = 0;
		for (Envio e : RepositorioEnvios.findAll()) {
			// Si hubiera muchos tipos, habría que hacer muchos if. Veremos una forma de
			// generalizar esto de mejor forma
			if (e instanceof EnvioUrgente) {
				coste += ((EnvioUrgente) e).calcularCosteSeguro();
			}
			if (e instanceof EnvioRefrigerado) {
				coste += ((EnvioRefrigerado) e).calcularCosteSeguro();
			}

		}
		return coste;
	}

	public static String actualizarEstadoEnvio(EstadoEnvio estado, int codigo) {
		return RepositorioEnvios.actualizarEstadoEnvio(estado, codigo);
	}

}
