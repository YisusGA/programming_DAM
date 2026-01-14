package ejemploHerencia.model;

public class Cliente {
	
	//Protected para que sean accesibles desde sus subclases fuera del paquete, pero no desde otras clases que estén fuera del paquete
	//Si una clase que no sea subclase, está dentro del mismo paquete, protected le permite acceder a la propiedad
	protected String nombre;
	protected String nif;
	
	public Cliente(String nombre, String nif) {
		super();
		this.nombre = nombre;
		this.nif = nif;
	}
	
	//Constructor sin parámetros
	public Cliente() {
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	
	public void mostrarDatos() {
		System.out.printf("Hola, soy el cliente %s y mi nif es %s%n", nombre, nif);
	}
	

}
