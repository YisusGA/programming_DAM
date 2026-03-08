package ejercicio05_sistema_vehiculos;

import java.util.ArrayList;
import java.util.List;

public class SistemaVehiculos {
	private static List<Conducible> vehiculos = new ArrayList<>();

	public static void main(String[] args) {
		if (addVehiculos()) {
			System.out.println("Vehículos añadidos");
		} else {
			System.err.println("La lista es null y no se pudieron añadir los vehículos");
		}
		for (Conducible i : vehiculos) {
			System.out.println(i.arrancar());
			System.out.println(i.detener());
		}
	}

	public static boolean addVehiculos() {
		boolean added = false;
		if (vehiculos != null) {
			vehiculos.add(new Coche("Renault", "Clio", 240, "1234AAA", 5));
			vehiculos.add(new Camion("Iveco", "Eurocargo", 120, "5678AAA", 2));
			vehiculos.add(new Moto("Harley Davidson", "Street Bob", 320, "1234BBB", 1923));
			added = true;
		}
		return added;
	}

}
