package model;

import java.util.List;

public class Restaurante {
	private String nombre;
	private List<Plato> carta;
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
		
	}
	
	public String verCarta() {
		
	}
	
	public String platosContienenIngrediente(String ingrediente) {
		
	}
	
	public boolean eliminarPlato(String nombre) {
		
	}
	
	public List<String> getIngredientesPlato (String nombre) {
		
	}
	
	public String platoMasCaro() {
		
	}

}
