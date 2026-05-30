package es.damdaw1.modelo;

import java.util.List;
import java.util.Objects;

public class Persona {

	// Estas propiedades deben existir en la tabla de la base de datos de donde
	// vayamos a sacar las personas
	private Integer id, edad;
	private String nombre;
	private List<Mascota> mascotas; // Una persona puede tener muchas mascotas. Esto habilita la navegabilidad entre
									// clases

	public Persona(Integer id, Integer edad, String nombre, List<Mascota> mascotas) {
		this.id = id;
		this.edad = edad;
		this.nombre = nombre;
		this.mascotas = mascotas;
	}

	public Persona(Integer edad, String nombre, List<Mascota> mascotas) {
		this.edad = edad;
		this.nombre = nombre;
		this.mascotas = mascotas;
	}
	
	
	public Persona(Integer id, Integer edad, String nombre) {
		this.id = id;
		this.edad = edad;
		this.nombre = nombre;
	}

	public Persona() {
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", edad=" + edad + ", nombre=" + nombre + "]";
	}

}
