package model;

public interface Rastreable {
	EstadoEnvio obtenerEstado();
	void actualizarEstado(EstadoEnvio nuevoEstado);

}
