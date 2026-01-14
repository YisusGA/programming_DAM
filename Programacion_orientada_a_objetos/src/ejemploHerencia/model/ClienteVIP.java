package ejemploHerencia.model;

public class ClienteVIP extends Cliente {
	
	String direccion;
	
	//Constructor de la subclase. Si ya tengo el constructor generado en la superclase, al hacer click derecho en la subclase > Source
	//> Generate Constructor, ya genera automáticamente el super
	public ClienteVIP(String nombre, String nif, String direccion) { 
		super(nombre, nif); //Llamar a la superclase. Si se llama sin más, se refiere al constructor
		this.direccion = direccion;
	}
	
	//Constructor vacío
	public ClienteVIP() { 
	}

	//No hace falta crear los getters y los setters de las propiedades de Cliente, pues los métodos (a excepción de los constructores)
	//se heredan de la superclase a las subclases
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	//Esto es el polimorfismo. Se escribe un método que debe tener EXACTAMENTE el mismo nombre, pero cambiando su funcionamiento.
	//Se sobreescribe el método de la superclase para objetos de la subclase. El método adopta una forma u otra dependiendo de si
	//el objeto es de la superclase o de la subclase.
	//Método sobreescrito de la superclase. Si pongo la anotación Override que se ve debajo, dejo claro que estoy sobreescribiendo el método.
	//Además, cuando use el método mostrarDatos() en un objeto en el Main, al pasar el ratón por encima, nos indicará si es el método de la
	//superclase o si es el Override
	@Override
	public void mostrarDatos() {
		//Si hago esto, me da error el compilador, porque nombre y nif sn privadas de Cliente, y no son accesibles ni siquiera para sus subclases
//		System.out.printf("Hola, soy el cliente %s, mi nif es %s y mi dirección es %s%n", nombre, nif, direccion);
		
		//Podría solucionarlo con los getters, aunque queda feo
//		System.out.printf("Hola, soy el cliente %s, mi nif es %s y mi dirección es %s%n", getNombre(), getNif(), direccion);
		
		//La mejor forma de solucionarlo es poner el modificador Protected en las propiedades de la superclase
		System.out.printf("Hola, soy el cliente %s, mi nif es %s y mi dirección es %s%n", nombre, nif, direccion);
		
	}
	

}
