package ejercicio22.modelo;

public class Pedido {
	
	private int codigo; //Debe ser único
	private String descripcion;
	private double precio;
	
	public static double IVA; //Variable estática para el IVA. Las variables estáticas se suelen hacer public. Luego se inicializa en el main
	
	//Método constructor
	public Pedido(int codigo, String descripcion, double precio) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	//Getters y setters para poder acceder a las propiedades
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	//Método toString para visualizar el contenido de la clase
	public String toString() {
		return "Pedido [codigo=" + codigo + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}
	
	//El método de debajo sólo utiliza propiedades static de la clase, no toca ninguna otra propiedad.
	//Aunque no sea obligatorio, podemos hacer que el método sea static. Esto nos da la ventaja de que luego
	//podemos llamar a ese método directamente con el nombre de la clase, sin necesidad de instanciar la clase
	public static void modificaIVA(double iva) {
		IVA = iva;
		System.out.println("Comunicando cambios...");
	}
		
	
	
}
