package utilidades;

public class NumeroMayor {

	public static int numeroMayor(int num1, int num2) {
		System.out.println("Introduce el segundo número");
		int max = (num1 + num2 + Math.abs(num1 - num2)) / 2;
		return max;
	}

}
