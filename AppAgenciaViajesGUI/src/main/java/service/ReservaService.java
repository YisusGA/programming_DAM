package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import dao.ReservaDAO;
import modelo.Reserva;

public class ReservaService {
	private ReservaDAO reservadao;

	public ReservaService(ReservaDAO reservadao) {
		this.reservadao = reservadao;
	}

	public Reserva reservaMasProxima() {
		List<Reserva> reservas = reservadao.findAll();
		Reserva reservaMasProxima = null;
		if (reservas != null) {
			reservaMasProxima = reservas.get(0);
			LocalDate closestDate = LocalDate.MAX;
			for (Reserva r : reservas) {
				if (r.getFecha().isBefore(closestDate) && r.getFecha().isAfter(LocalDate.now())) {
					closestDate = r.getFecha();
					reservaMasProxima = r;
				}
			}
		}
		return reservaMasProxima;
	}

	public List<Reserva> reservasCliente(String nomCliente) {
		List<Reserva> reservasTotales = reservadao.findAll();
		List<Reserva> reservasCliente = null;
		if (reservasTotales != null) {
			reservasCliente = new ArrayList<>();
			for (Reserva r : reservasTotales) {
				if (r.getCliente().equalsIgnoreCase(nomCliente)) {
					reservasCliente.add(r);
				}
			}
			if (reservasCliente.size() == 0) {
				reservasCliente = null;
			}
		}
		return reservasCliente;
	}

	public int eliminaReservas(String destino) throws FileNotFoundException, IOException {
		int numReservasEliminadas = 0;
		List<Reserva> reservasTotales = reservadao.findAll();
		if (reservasTotales != null) {
			for (Reserva r : reservasTotales) {
				if (r.getDestino().getNombre().equalsIgnoreCase(destino)) {
					reservadao.delete(r.getCodigo());
					numReservasEliminadas++;
				}
			}
		}
		return numReservasEliminadas;
	}

	public boolean descuentoCliente(String nomCliente, int porcentajeDescuento) throws IOException {
		boolean aplicadoDescuento = false;
		List<Reserva> reservasCliente = reservasCliente(nomCliente);
		if (reservasCliente != null) {
			for (Reserva r : reservasCliente) {
				double precioConDescuento = r.getDestino().getPrecio() * ((100 - porcentajeDescuento) / 100.0);
				r.getDestino().setPrecio(precioConDescuento);
				aplicadoDescuento = reservadao.update(r);
			}
		}
		return aplicadoDescuento;
	}

}
