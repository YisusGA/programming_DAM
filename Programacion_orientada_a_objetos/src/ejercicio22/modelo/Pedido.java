package ejercicio22.modelo;

public class Pedido {
	
	private int codigo; //Debe ser único
	private String descripcion;
	private double precio;
	
	
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
	
		
	
	
}
