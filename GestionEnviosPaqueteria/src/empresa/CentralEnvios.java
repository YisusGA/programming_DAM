package empresa;

import model.Envio;
import model.EnvioEstandar;
import model.EnvioRefrigerado;
import model.EnvioUrgente;
import model.EstadoEnvio;
import model.TipoEnvio;
import teclado.Teclado2;

public class CentralEnvios {
	Envio[] envios = new Envio[0];
	private int codigo = 0;

	public CentralEnvios(Envio[] envios, int codigo) {
		super();
		this.envios = envios;
		this.codigo = codigo;
	}

	public CentralEnvios(Envio[] envios) {
		super();
		this.envios = envios;
	}

	public CentralEnvios(int codigo) {
		super();
		this.codigo = codigo;
	}

	public CentralEnvios() {

	}

	public int generarCodigoPedido() {
		return this.codigo++;
	}

//	public String registrarEnvio(Envio envio) {
//		Envio[] aux = new Envio[envios.length + 1];
//		for (int i = 0; i < envios.length; i++) {
//			aux[i] = envios[i];
//		}
//		aux[aux.length - 1] = envio;
//		envios = aux;
//		return "Envio registrado correctamente";
//	}

	public String registrarEnvio() {
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
		int codigo = this.codigo++;

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

	public boolean hayEnvios() {
		if (envios.length > 0) {
			return true;
		}
		return false;
	}

	public void listarEnvios() {
		if (envios.length > 0) {
			for (int i = 0; i < envios.length; i++) {
				System.out.println(envios[i].toString());
			}

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
