package ejercicio01;

import teclado.TecladoOK;

public class Main {

	public static void main(String[] args) {
		MiStack<String> pila = new MiStack<>();
		for (int i = 0; i < 10; i++) {
			System.out.println("Introduzca cadena: ");
			String cad = TecladoOK.leerCadena();
			pila.push(cad);
		}
		
		while(!pila.isEmpty()) {
			System.out.println(pila.pop());
		}

	}

}
