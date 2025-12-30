package ejercicio15;

class Partitura {
	String autor;
	String instrumento;
	int tempo;
	int numInstrumentos = 1;
	
	Partitura(String autor, String instrumento, int tempo) {
		this.autor = autor;
		this.instrumento = instrumento;
		this.tempo = tempo;
	}
	String aumentaTempo() {
		String mensaje;
		tempo += 10;
		return mensaje = "Tempo aumentado en 10";
	}
	String reduceTempo() {
		String mensaje;
		tempo -= 10;
		return mensaje = "Tempo reducido en 10";
	}
	public String toString() {
		return "Partitura [autor=" + autor + ", instrumento=" + instrumento + ", tempo=" + tempo + ", numInstrumentos="
				+ numInstrumentos + "]";
	}
	String cambiaInstrumento (String instrumento) {
		String mensaje;
		this.instrumento = instrumento;
		return mensaje = "Instrumento cambiado";
	}
	String addInstrumento (String instrumento) {
		String mensaje;
		this.instrumento += "," + instrumento;
		numInstrumentos++;
		return mensaje = "Instrumento añadido. Ahora están los siguientes instrumentos: " + this.instrumento;
	}
	String cuentaInstrumentos() {
		String mensaje = "Hay " + numInstrumentos;
		return mensaje;
	}
	
	public int cuentaInstrumentos_v2() {
		//Método split para dividir un String en un array de Strings mediante el reconocimiento de un patrón regular, una coma en este caso.
		//Ver explicación más detallada en los apuntes del cuaderno
		String[] instrumentos = instrumento.split(",");
		for(String inst : instrumentos)
			System.out.println(inst);
		return instrumentos.length;
	}

}
