package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import dao.DestinoDAO;
import dao.ReservaDAO;
import modelo.Reserva;

public class ReservaService {
	private ReservaDAO reservadao;
	private DestinoDAO destinodao; // Igual esta no la llegamos a usar

	public ReservaService(ReservaDAO reservadao, DestinoDAO destinodao) {
		this.reservadao = reservadao;
		this.destinodao = destinodao;
	}

	public Reserva reservaMasProxima() {
		List<Reserva> reservas = reservadao.findAll();
		List<LocalDate> fechasReservas = new ArrayList<>();
		LocalDate closestDate = null;
		if (reservas != null) {
			for (Reserva r : reservas) {
				fechasReservas.add(r.getFecha());
			}
			fechasReservas.sort(null);
			closestDate = fechasReservas.getFirst();
		}		
		return closestDate;
	}

	public List<Reserva> reservasCliente(String nomCliente) {
		return null;
	}

	public boolean eliminaReservas(String destino) {
		return false;
	}

	public boolean descuentoCliente(String nomCliente, int porcentajeDescuento) {
		return false;
	}

}
