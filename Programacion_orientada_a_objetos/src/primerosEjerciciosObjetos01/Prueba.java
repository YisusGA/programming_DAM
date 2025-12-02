package primerosEjerciciosObjetos01;

public class Prueba {

	public static void main(String[] args) {
		Persona pepe = new Persona();
		pepe.saludar();
		pepe.despedirse();
		System.out.println(pepe.edad);
		System.out.println(pepe.nombre);
		pepe.edad = 20;
		pepe.nombre = "Pepe";
		System.out.println(pepe.edad);
		System.out.println(pepe.nombre);
		pepe.saludar();
		pepe.despedirse();
		
		Persona ana = new Persona();
		ana.nombre = "Ana";
		ana.edad = 18;
		
		pepe.saludar();
		ana.saludar();
		
		
		/*
		 * Con esto de debajo, crearíamos una variable tipo objeto con el nombre “aux”, que tomaría la dirección de memoria de
		 * la variable tipo objeto “pepe”. Por tanto, al operar con esa variable aux, tendrá los mismos valores en sus propiedades 
		 * que la variable pepe. Y por tanto, al usar el método saludar() con ella, mostraría el nombre y la edad almacenados 
		 * en las propiedades de la instancia pepe. En este punto del programa, tendríamos 3 objetos (o instancias) de la clase 
		 * Persona: pepe, ana y aux.
		 */
		Persona aux = pepe;
		aux.saludar();
		
		/*
		 * Con esto de debajo, asignamos a la instancia "ana" la dirección de memoria de aux, que ya tenía, por la asignación previa, 
		 * la dirección de memoria de la instancia "pepe". Por tanto, ahora las 3 instancias apuntan a la misma dirección de memoria,
		 * y tendrán los mismos valores para sus propiedades
		 */
		ana = aux;
		ana.saludar();
	}

}
