package empresa;

import interfaces.Asegurable;
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
			if (e instanceof Asegurable) {
				coste += ((Asegurable) e).calcularCosteSeguro(); // Para no meter un if para EnvioRefrigerado y
																	// EnvioUrgente, podemos hacer un instanceof de la
																	// interface. El compilador mira que está declarado
																	// como Asegurable, que tiene un método
																	// calcularCosteSeguro() vacío. Pero en tiempo de
																	// ejecución del programa, mirará cómo se ha
																	// instanciado el objeto. No se pueden crear
																	// instancias de Asegurable, pues es una clase
																	// abstracta, así que el objeto se habrá instanciado
																	// como alguno de los tipos de envío (urgente,
																	// estandar o refrigerado). Y si se ha instanciado
																	// como EnvioEstandar o EnvioUrgente (que son
																	// Asegurables), entonces entrará dentro del if.
			}
		}
		return coste;
	}

	public static String actualizarEstadoEnvio(EstadoEnvio estado, int codigo) {
		return RepositorioEnvios.actualizarEstadoEnvio(estado, codigo);
	}

}
