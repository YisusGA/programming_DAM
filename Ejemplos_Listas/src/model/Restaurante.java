package model;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
	private String nombre;
	private List<Plato> carta = new ArrayList<>(); // Inicializamos la lista como ArrayList, pues es más ventajosa para el
													// uso que le vamos a dar: normalmente no vamos a necesitar añadir o
													// eliminar elementos (que es el punto flojo de las ArrayList), pero
													// sí vamos a estar consultando continuamente elementos (que es el
													// punto fuerte de las ArrayList, y el flojo de las LinkedList)

	public Restaurante(String nombre) {
		this.nombre = nombre;
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
		if (contador > 0) {
			return "Ninguno de los platos contiene " + ingrediente + " como ingrediente";
		}
		return resultado;

	}

	public boolean eliminarPlato(String nombre) {
		for (int i = 0; i < carta.size(); i++) {
			if (carta.get(i).getNombre().equals(nombre)) {
				return carta.remove(carta.get(i));
			}
		}
		return false;
	}

	public String getIngredientesPlato(String nombre) {
		for (int i = 0; i < carta.size(); i++) {
			if (carta.get(i).getNombre().equals(nombre)) {
				return carta.get(i).listadoIngredientes();
			}
		}
		return "Plato no encontrado";

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

}
