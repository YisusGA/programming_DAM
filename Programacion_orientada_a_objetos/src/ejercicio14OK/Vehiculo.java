package ejercicio14OK;

public class Vehiculo {
	private double consumo; //Consumo del vehículo en litros / km

	//Método constructor
	public Vehiculo(double consumo) {
		this.consumo = consumo;
	}	
	
	//Método getter para consulta
	public double getConsumo() {
		return consumo;
	}
	
	//Método setter para cambiar consumo
	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}
	
	
	/**
	 * Calcular consumo del coche en todo el trayecto
	 * @param Un array de objetos Punto
	 * @return El consumo tras recorrer el trayecto trazado a lo largo de todos los objetos Punto
	 */
	public double consumoTrayecto(Punto[] p) {
		double distancia = 0;
		for (int i = 0; i < p.length - 1; i++) { //Importante que la condición sea p.length - 1, si ponemos sólo p.length, dará error OutOfBounds
			distancia += p[i].distancia(p[i + 1]);
		}
		return distancia * consumo;
	}

}
