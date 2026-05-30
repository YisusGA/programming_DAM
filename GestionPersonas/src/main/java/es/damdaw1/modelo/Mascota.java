package es.damdaw1.modelo;

import java.util.Date;

public class Mascota {

	private Integer id;
	private String nombre;
	private Date vacuna;
	private Persona propietario; // Una mascota pertence a un propietario. Esto habilita la navegabilidad entre
									// clases

	public Mascota(Integer id, String nombre, Date vacuna, Persona propietario) {
		this.id = id;
		this.nombre = nombre;
		this.vacuna = vacuna;
		this.propietario = propietario;
	}

	public Mascota(Integer id, String nombre, Date vacuna) {
		this.id = id;
		this.nombre = nombre;
		this.vacuna = vacuna;
	}

	public Mascota(String nombre, Date vacuna, Persona propietario) {
		this.nombre = nombre;
		this.vacuna = vacuna;
		this.propietario = propietario;
	}

	public Mascota() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getVacuna() {
		return vacuna;
	}

	public void setVacuna(Date vacuna) {
		this.vacuna = vacuna;
	}

	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}

}
