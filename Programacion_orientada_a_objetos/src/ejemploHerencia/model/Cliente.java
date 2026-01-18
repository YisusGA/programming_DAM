package ejemploHerencia.model;

public class Cliente {

	// Protected para que sean accesibles desde sus subclases fuera del paquete,
	// pero no desde otras clases que estén fuera del paquete
	// Si una clase que no sea subclase, está dentro del mismo paquete, protected le
	// permite acceder a la propiedad
	protected String nombre;
	protected String nif;

	public Cliente(String nombre, String nif) {
		super();
		this.nombre = nombre;
		this.nif = nif;
	}

	// Constructor sin parámetros
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

	// Con este método, hacemos un override del equals() que tiene la clase
	// Object.class, que nos sirve para comparar de forma útil 2 objectos de nuestra
	// clase, en lugar de comparar direcciones de memoria, que es lo que hace el
	// método equals() de Object.class. Es imprescindible que el objeto que le
	// pasemos por parámetro sea un Object, pues la cabecera del método debe ser
	// igual a la del método de Object.class para que se haga un override. Y eso por
	// supuesto, nos obliga a hacer el casting que se ve dentro del método
	@Override
	public boolean equals(Object c) {
		if (this.nif.equals(((Cliente) c).nif)) {
			return true;
		} else {
			return false;
		}
	}

}
