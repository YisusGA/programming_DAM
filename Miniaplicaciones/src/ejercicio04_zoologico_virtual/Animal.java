package ejercicio04_zoologico_virtual;

import java.util.Objects;

public abstract class Animal {
	protected String nombre;
	protected int edad;

	public Animal(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	public Animal() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public abstract String hacerSonido();

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) // El equals primero mira si las direcciones de memoria coinciden. Si coinciden,
							// ambos objetos son iguales y devuelve True
			return true;
		if (obj == null) // Luego mira que el objeto pasado por parámetro no sea null, pues si es null,
							// no tiene sentido que haya igualdar, y devuelve False
			return false;
		if (getClass() != obj.getClass()) // Luego mira que las clases de los dos objetos sean la misma, pues si no lo
											// son, entonces no son iguales y devolvería False (podríamos querer
											// eliminar esta condición)
			return false;
		Animal other = (Animal) obj; // Asigna a una variable la dirección de memoria del objeto pasado por parámetro
		return Objects.equals(nombre, other.nombre); // Y por último, si no ha entrado en ninguno de los if anteriores,
														// comprueba si el valor de la propiedad nombre es igual en
														// ambos objetos (usando el método equals implementado en String
														// en este caso)
	}

	@Override
	public String toString() {
		return "Animal [nombre=" + nombre + ", edad=" + edad + "]";
	}

}
