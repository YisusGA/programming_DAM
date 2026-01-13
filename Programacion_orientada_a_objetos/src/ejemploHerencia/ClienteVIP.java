package ejemploHerencia;

public class ClienteVIP extends Cliente {
	
	String direccion;

	
	//No hace falta crear los getters y los setters de las propiedades de Cliente, pues los métodos (a excepción de los constructores)
	//se heredan de la superclase a las subclases
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	

}
