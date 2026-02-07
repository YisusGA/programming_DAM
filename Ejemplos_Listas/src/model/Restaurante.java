package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Restaurante {
	private String nombre;
	private List<Plato> carta = new ArrayList<>(); // Inicializamos la lista como ArrayList, pues es más ventajosa para
													// el uso que le vamos a dar: normalmente no vamos a necesitar
													// añadir o eliminar elementos (que es el punto flojo de las
													// ArrayList), pero sí vamos a estar consultando continuamente
													// elementos (que es el punto fuerte de las ArrayList, y el flojo de
													// las LinkedList)

	public Restaurante(String nombre, List<Plato> carta) {
		super();
		this.nombre = nombre;
		this.carta = carta;
	}

	public Restaurante(String nombre) {
		this.nombre = nombre;
	}

	public Restaurante() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Plato> getCarta() {
		return carta;
	}

	public void setCarta(List<Plato> carta) {
		this.carta = carta;
	}

	public void addPlato(Plato plato) {
		carta.addLast(plato);

	}

	public String verCarta() {
		String resultado = "";
		for (int i = 0; i < carta.size(); i++) {
			resultado += carta.get(i).toString() + "\n"; // Así es como metemeos un salto de línea, con "\n"
		}
		return resultado;
	}

	public String platosContienenIngrediente(String ingrediente) {
		String resultado = "Los platos que contienen el ingrediente " + ingrediente + " son los siguientes\n";
		int contador = 0;
		for (int i = 0; i < carta.size(); i++) {
			if (carta.get(i).contieneIngrediente(ingrediente)) {
				resultado += carta.get(i).getNombre() + ", ";
				contador++;
			}
		}
		if (contador == 0) {
			return "Ninguno de los platos contiene " + ingrediente + " como ingrediente";
		}
		return resultado;

	}

//	public boolean eliminarPlatov1(String nombre) {
//		for (int i = 0; i < carta.size(); i++) {
//			if (carta.get(i).getNombre().equals(nombre)) {
//				return carta.remove(carta.get(i)); // Aquí hay sobre-iteración, porque estamos iterando en la carta con
//													// el for y luego con el método remove. Esto genera problemas en los extremos
//	                                                // La solución es el método v2
//			}
//		}
//		return false;
//	}

	public boolean eliminarPlatov2(String nombre) {
		Plato p = new Plato(nombre, 0.0); // Creamos un plato cuyo nombre sea el pasado por parámetro. Como está
											// explicado en la propiedad Double precio de plato, aquí tenemos que meter
											// un double primitivo para que pueda hacer el casting al wrapper Double; si
											// metemos un int primitivo, nos dará error
		return carta.remove(p); // Y como hemos creado un método equals cuyo criterio de igualdad es el nombre,
								// usamos el método remove, que podrá encontrar el plato que sea igual (tenga el
								// mismo nombre) que el nombre pasado por parámetro
	}

	public boolean eliminarPlatov3(Plato plato) {
		return carta.remove(plato); // ¿Qué criterio de igualdad sigue este método remove en el caso de comparar
									// objetos Plato? Pues el que está implementado en la superclase List. Y lo que
									// está implementado en List es que dos objetos son iguales si sus direcciones
									// de memoria son la misma. Por lo tanto, SIEMPRE tenemos que sobreescribir el
									// método equals en la clase de donde venga nuestra lista (Plato en este caso)
									// para establecer nosotros el criterio de igualdad. Y esto ya lo he hecho en
									// este caso en la clase Plato
	}

	public String getIngredientesPlato(String nombre) {
		for (int i = 0; i < carta.size(); i++) {
			if (carta.get(i).getNombre().equals(nombre)) {
				return carta.get(i).listadoIngredientes();
			}
		}
		return "Plato no encontrado";

	}

	public List<String> getIngredientesPlato2(String nombre) {
		for (int i = 0; i < carta.size(); i++) {
			if (carta.get(i).getNombre().equals(nombre)) {
				return carta.get(i).getIngredientes();
			}
		}
		return null;

	}

	public String platoMasCaro() {
		Double max = carta.getFirst().getPrecio();
		String masCaro = "";
		for (int i = 0; i < carta.size(); i++) {
			if (carta.get(i).getPrecio() > max) {
				max = carta.get(i).getPrecio();
				masCaro = carta.get(i).getNombre();
			}
		}
		return "El plato más caro es: " + masCaro + " y cuesta: " + max;

	}

	/**
	 * Método que crea una LinkedList auxiliar a la que añade todos los platos que
	 * continene un ingrediente pasado como parámetro. Luego usa el método
	 * removeAlll() de LinkedList para eliminar de nuestra carta todos los platos
	 * que se añadieron a la lista auxiliar
	 * 
	 * @param ingrediente
	 */
	public void eliminarPlatosContienen(String ingrediente) {
		List<Plato> platos = new LinkedList<>();
		for (Plato p : carta) {
			if (p.contieneIngrediente(ingrediente)) {
				platos.add(p);
			}
		}
		carta.removeAll(platos);

	}

}
