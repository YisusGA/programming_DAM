package main;

import interfaz.Operar;

public class Multiplicar implements Operar {

	@Override
	public int operar(int op1, int op2) {
		return op1 * op2;
	}

}
