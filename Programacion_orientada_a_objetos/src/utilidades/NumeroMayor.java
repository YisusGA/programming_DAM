package utilidades;

public class NumeroMayor {

	public static int numeroMayor(int num1, int num2) {
		int max = (num1 + num2 + Math.abs(num1 - num2)) / 2; // Se suman ambos números, y a eso se le suma la resta
																// absoluta de ambos. Y el resultado de todo eso, se
																// divide entre 2
		return max;
	}

}
