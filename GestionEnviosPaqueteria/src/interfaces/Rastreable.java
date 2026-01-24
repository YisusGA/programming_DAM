package interfaces;

import model.EstadoEnvio;

public interface Rastreable {
	EstadoEnvio obtenerEstado();
	void actualizarEstado(EstadoEnvio nuevoEstado);

}
