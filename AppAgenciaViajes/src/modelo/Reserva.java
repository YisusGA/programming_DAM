package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Reserva implements Serializable, Comparable<Reserva> {
	private int codigo;
	private String cliente;
	private LocalDate fecha;
	private Destino destino;

	public Reserva(int codigo, String cliente, LocalDate fecha, Destino destino) {
		this.codigo = codigo;
		this.cliente = cliente;
		this.fecha = fecha;
		this.destino = destino;
	}

	public Reserva() {
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return codigo == other.codigo;
	}

	@Override
	public String toString() {
		return "Reservas [codigo=" + codigo + ", cliente=" + cliente + ", fecha=" + fecha + ", destino=" + destino
				+ "]";
	}

	@Override
	public int compareTo(Reserva o) {
		return this.codigo - o.getCodigo();
	}

}
