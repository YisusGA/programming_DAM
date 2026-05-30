package es.damdaw1.service;

import java.util.List;

import es.damdaw1.dao.PersonaDAO;
import es.damdaw1.modelo.Mascota;
import es.damdaw1.modelo.Persona;

public class Service {

	// El Service ya sí que ofrece funcionalidades relacionadas con las
	// particularidades de mi app. Y se apoyará en los métodos genéricos del DAO
	// para construir sus métodos

	// Importante: no hacemos que la propiedad sea static, porque nos puede
	// interesar instanciar diferentes Service (en una app multihilo, por ejemplo) y
	// queremos que instancia de Service tenga su propio PersonaDAO
	private PersonaDAO daoPersonas;

	public Service(PersonaDAO dao) {
		this.daoPersonas = dao;
	}

	public List<Mascota> getMascotasUsuario(Integer id) {
		Persona p = daoPersonas.getPersona(id);
		return p.getMascotas();
	}

	public List<Persona> vacunasProximoMes() {
		// TODO
		return null;
	}
}
