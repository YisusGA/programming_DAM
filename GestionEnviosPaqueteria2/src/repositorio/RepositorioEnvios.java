package repositorio;

import model.Envio;
import model.EnvioEstandar;
import model.EnvioRefrigerado;
import model.EnvioUrgente;
import model.EstadoEnvio;
import model.TipoEnvio;
import teclado.Teclado2;

public class RepositorioEnvios {
	static Envio[] envios = new Envio[0];
	private static int codigo = 0;

	public static int generarCodigoPedido() {
		return codigo++;
	}

	public static void addEnvio(Envio envio) {
		Envio[] aux = new Envio[envios.length + 1];
		for (int i = 0; i < envios.length; i++) {
			aux[i] = envios[i];
		}
		aux[aux.length - 1] = envio;
		envios = aux;
	}

	public static String registrarEnvio() {
		Envio envio;
		TipoEnvio tipo;
		do {
			System.out.println("""
					¿Qué tipo de envío deseas realizar?
					Opciones válidas:
					ENVIOESTANDAR, ENVIOREFRIGERADO, ENVIOURGENTE
					""");
			tipo = TipoEnvio.leerTeclado();
		} while (tipo == null);

		System.out.println("Introduce el peso");
		double peso = Teclado2.leerDecimal();
		System.out.println("Introduce el origen");
		String origen = Teclado2.leerCadena();
		System.out.println("Introduce el destino");
		String destino = Teclado2.leerCadena();
		int codigo = generarCodigoPedido();

		switch (tipo) {
		case ENVIOESTANDAR -> {
			System.out.println("Introduce los días estimados de envío");
			int dias = Teclado2.leerEntero();
			envio = new EnvioEstandar(codigo, peso, origen, destino, dias);
		}
		case ENVIOREFRIGERADO -> {
			System.out.println("Introduce la temperatura");
			double temperatura = Teclado2.leerDecimal();
			envio = new EnvioRefrigerado(codigo, peso, origen, destino, temperatura);
		}
		case ENVIOURGENTE -> {
			System.out.println("Introduce el recargo por envío urgente");
			double recargo = Teclado2.leerDecimal();
			envio = new EnvioUrgente(codigo, peso, origen, destino, recargo);
		}
		default -> {
			envio = null;
		}
		}
		if (envio != null) {
			Envio[] aux = new Envio[envios.length + 1];
			for (int i = 0; i < envios.length; i++) {
				aux[i] = envios[i];
			}
			aux[aux.length - 1] = envio;
			envios = aux;
			return "Envio registrado correctamente";
		} else {
			return "Envío no válido";
		}

	}

	public static boolean hayEnvios() {
		if (envios.length > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param codigo El codigo de envio
	 * @return Un boolean indicando si se ha encontrado el envío cuyo código
	 *         coincide con el código pasado como parámetro
	 */
	public static boolean eliminarEnvio(int codigo) {
		Envio[] aux = new Envio[envios.length - 1];
		boolean encontrado = false;
		for (int i = 0, j = 0; j < aux.length; i++) { // Usamos la longitud del array aux como límite del bucle, porque
														// si no, nos podría salir OutOfBounds index error
			if (envios[i].getCodigo() != codigo) {
				aux[j++] = envios[i];
			} else {
				encontrado = true; // Si se encuentra, se actualiza a true
			}
		}

		if (encontrado) { // Si se ha encontrado, se sobreescribe el array envios con el array aux
			envios = aux;
		} else { // Si no se ha encontrado, todavía existe la posibilidad de que la última
					// posición del array envios fuera el código buscado. Si ese es el caso, se
					// actualiza a true
			if (envios[envios.length - 1].getCodigo() == codigo) {
				encontrado = true;
				envios = aux;
			}
			// Si no se ha encontrado el código, entonces no se sobreescribe el array envios
			// con el array aux
		}
		return encontrado;
	}

	public static Envio findEnvioByCodigo(int codigo) {

		for (Envio e : envios)
			if (e.getCodigo() == codigo)
				return e;
		return null;
	}

	public static String actualizarEstadoEnvio(EstadoEnvio estado, int codigo) {
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

	public static Envio[] findAll() {
		return envios;
	}

	// Localiza en el array el envío con el código que tenga el objeto parámetro
	// envio. Si lo encuentra, lo sustituye por el parámetro; si no lo encuentra,
	// devuelve false
	public boolean cambiarEnvio(Envio envio, int codigo) {
		boolean encontrado = false;
		for (int i = 0; !encontrado && i < envios.length; i++) {
			if (envios[i].getCodigo() == codigo) {
				encontrado = true;
				envios[i] = envio;
			}
		}

		return encontrado;

	}

}
