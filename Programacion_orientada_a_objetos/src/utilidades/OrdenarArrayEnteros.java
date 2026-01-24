package utilidades;

public class OrdenarArrayEnteros {

	public static int[] ordenarArray(int[] array) {
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[i]) {
					min = array[j];
					array[j] = array[i];
					array[i] = min;
				}

			}
		}
		return array;
	}

}
