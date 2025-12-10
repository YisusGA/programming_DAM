package modelo;

//Modificador public para la clase: permite que clases fuera del paqueta puedan hacer referencia a esa clase.
//Si no se pone, sólo pueden hacer referencia a esa clase las clases que estén dentro de su mismo paquete.
public class Alumno {
	
	//Hay que poner el public también a las propiedades que queremos que sean accesibles a otras clases fuera del paquete 
	public String nombre;
	
	//Con el modificador private, sólo se puede acceder únicamente desde la propia clase
	private String nif;
		
	//La propiedad id no sería pública tal y como está escrita, pero tampoco privada. O sea que sería accesible desde clases
	//de su mismo paquete
	int id;
	
	//Hay un cuarto modificador de acceso que es protected, que tiene que ver con la herencia. No lo veremos por ahora
	
	//A los métodos les aplican los identificadores, igual que a las propiedades
	public boolean idSobreCien() {
		return id > 100; 
	}
	
	//Método constructor. Es lo que nos permite darle los valores en la línea 11 directamente al crear la instancia a de Alumno
	public Alumno(String nombre, int id, String nif) {
		this.nombre = nombre;
		this.id = id;
		this.nif = nif;
	}
	
	//Los métodos getter y setter nos sirven para poder consultar y modificar propiedades sin necesidad de hacerlas públicas. Esto aumenta
	//la seguridad de mi aplicación
	
//	Método para consulta (método getter). Nos sirve para consultar una propiedad 
	public String getNif() {
		return nif;
	}
//	Método setter para poder modificar la propiedad cuando se llame al método
	public void setNif(String nif) {
		this.nif = nif;
	}
	
	
}
