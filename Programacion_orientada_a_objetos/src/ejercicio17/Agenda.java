package ejercicio17;

import java.util.Arrays;

public class Agenda {
	
	private Persona[] personas;

	//Getters and setters
	public Persona[] getPersonas() {
		return personas;
	}

	public void setPersonas(Persona[] personas) {
		this.personas = personas;
	}
	
	/**
	 * 
	 * @param Persona a agregar a la agenda
	 * @return Mensaje de que se ha agregado la persona con éxito
	 */
	public String agregarPersona(Persona persona) {
		if (personas == null) {
			personas = new Persona[1];
			personas[0] = persona;
		} else {
			Persona[] aux = new Persona[personas.length + 1];
			for (int i = 0; i < personas.length; i++) {
				aux[i] = personas[i];
			}
			aux[aux.length - 1] = persona;
			personas = aux;
		}
		return "Persona agregada correctamente a la agenda";
	}
	
	/**
	 * 
	 * @param Nombre de la persona a eliminar
	 * @return Mensaje de la operación realizada
	 */
	public String eliminarPersona(String nombre) {
		if (personas == null) {
			return "No hay personas registradas en la agenda";
		} else {
			boolean encontrado = false;
			for (int i = 0; !encontrado && i < personas.length; i++) {
				if (personas[i].getNombre().equals(nombre)) {
					encontrado = true;
				}
			}
			if (encontrado) {
				Persona[] aux = new Persona[personas.length - 1];
				boolean eliminado = false;
				for (int i = 0; !eliminado && i < personas.length; i++) {
					if (!personas[i].getNombre().equals(nombre)) {
						aux[i] = personas[i];
						eliminado = true;
					}
				}
				personas = aux;
				return "Persona eliminada correctamente de la agenda";
			} else {
				return "La persona solicitada no se encuentra registrada en la agenda";
			}
		}
	}
	
	public int obtenerConteoDePersonas() {
		if (personas == null) {
			return 0;
		} else {
			return personas.length;
		}
	}

	public String obtenerInformacion(int conteoPersonas) {
		if (personas == null) {
			return "No hay personas registradas en la agenda";
		} else {
			String datosPersonas = "";
			for (int i = 0; i < personas.length; i++) {
				datosPersonas += personas[i].getNombre() + " (edad " + personas[i].getEdad() + ", " + personas[i].getDireccion() + "), ";
			}
			return "La agenda contiene " + conteoPersonas + " personas: " + datosPersonas;
		}
	}
	
	
}
