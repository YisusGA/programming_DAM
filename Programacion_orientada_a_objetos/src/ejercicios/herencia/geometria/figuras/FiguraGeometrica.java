package ejercicios.herencia.geometria.figuras;

public abstract class FiguraGeometrica { // Tiene que ser clase asbtracta para poder tener un método abstracto. La
											// limitación de que sea una clase asbtracta es que no puedo instanciar
											// objetos de esta clase. De todos modos, no necesito instanciar objetos de
											// esta clase. Además, hacer una clase abstracta con un método asbtracto
											// obliga a que todas sus subclases implementen ese método asbtracto. Si no
											// se implementa, da error de compilación. Esto me ayuda a que si creo una
											// nueva subclase, no me voy a olvidar de implementar el método, porque me
											// saldrá el error de compilación
	protected String nombre;

	public FiguraGeometrica(String nombre) {
		this.nombre = nombre;
	}

	public FiguraGeometrica() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public abstract double getPerimetro(); // Un método asbtracto es un método por definir. Y puede ser sobreescrito por
											// cada una de sus subclases. La utilidad de tener un método abstracto está
											// explicada justo debajo

	public abstract double getArea();

	// En lugar de hacer un método abstracto, se podría hacer esto de debajo. El
	// problema es que si tenemos una subclase y se nos olvida hacer su método
	// getPerimetro(), va a usar el método de la superclase y nos devolverá 0

//	public double getPerimetro() {
//		return 0;
//	}
//	
//	public double getArea () {
//		return 0;
//	}

}
