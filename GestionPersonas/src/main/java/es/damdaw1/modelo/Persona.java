package es.damdaw1.modelo;

public class Persona {
	
	private Integer id, edad;
	private String nombre;
	
	
	
	public Persona(Integer id, Integer edad, String nombre) {
		super();
		this.id = id;
		this.edad = edad;
		this.nombre = nombre;
	}
	public Persona(Integer edad, String nombre) {
		super();
		this.edad = edad;
		this.nombre = nombre;
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
	@Override
	public String toString() {
		return "Persona [id=" + id + ", edad=" + edad + ", nombre=" + nombre + "]";
	}
	
	
	

}
