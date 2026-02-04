package model;

import java.util.LinkedList;
import java.util.List;

public class Plato {
	private String nombre;
	private Double precio; // Aquí estamos declarando la variable con un wrapper. Esto me da, por ejemplo,
							// la ventaja de tener un precio por definir, que tendría un null asignado

	private List<String> ingredientes = new LinkedList<>(); // Usamos la colección List de java.util en la declaración.
															// Lo que hicimos nosotros creando la
	// lista era simplemente un ejercicio para entenderlo. List es una interface.
	// Cuando instanciemos la lista, habrá que hacerlo como ArrayList o como
	// LinkedList, que ya son dos implementaciones de List. Pero si queremos evitar
	// NullPointerException, tenemos que inicializar la lista, y aquí ya sí que
	// tenemos que comprometernos con ArrayList o LinkedList

	public Plato(String nombre, Double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public List<String> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<String> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public void addIngrediente(String ingrediente) {
		ingredientes.add(ingrediente);
	}

	/**
	 * Este método borra el primer ingrediente (SÓLO EL PRIMERO QUE ENCUENTRE) de la
	 * lista de ingredientes que sea igual al parámetro
	 * 
	 * @param ingrediente
	 * @return true si se eliminó, false si no encontró ninguno y no borró nada
	 */
	public boolean removeIngrediente(String ingrediente) {
		return ingredientes.remove(ingrediente);
	}

	/**
	 * Este método borra todos los ingredientes de la lista de ingredientes que sean
	 * igual al parámetro
	 * 
	 * @param ingrediente
	 * @return true si se eliminaron, false si no encontró ninguno y no borró nada
	 */
	public boolean removeIngredientesTodos(String ingrediente) {
		// Esto sería un while que lo único que hace está dentro de la propia condición.
		// No hace
		// falta abrir y cerrar las llaves
//		while (ingredientes.remove(ingrediente));

		// Pero mejor si devolvemos un estado de lo que se ha hecho
		boolean hay = false;
		while (ingredientes.remove(ingrediente)) {
			hay = true;
		}
		return hay;
	}

	public String listadoIngredientes() {
		String lista = "";
		for (int i = 0; i < ingredientes.size(); i++) {
			lista += ingredientes.get(i) + "\n";
		}
		// Otra forma
//		for (String i : ingredientes) {
//			lista += i;
//		}
		return lista;
	}

	public boolean contieneIngrediente(String ingrediente) {
		return ingredientes.contains(ingrediente); // Este método ya tiene un bucle que itera y compara objetos. Como en
													// este caso, lo que comparamos son Strings, que ya tienen un
													// criterio de igualdad, este contains funciona
	}

	public boolean contieneIngredienteLargo(int numLetras) { // Aquí no se puede usar el contains, hay que hacerlo a la
																// vieja usanza
		boolean encontrado = false;
		for (String i : ingredientes) {
			if (i.length() > numLetras) {
				encontrado = true;
			}
		}
		return encontrado;
	}

	// Una versión más enrevesada de hacer lo que hemos hecho con el método remove
	// de antes
	public boolean removeIngredientev2(String ingrediente) {
		boolean encontrado = false;
		int posicion;
		while ((posicion = ingredientes.indexOf(ingrediente)) != -1) {
			ingredientes.remove(posicion);
			encontrado = true;
		}
		return encontrado;
	}

}
