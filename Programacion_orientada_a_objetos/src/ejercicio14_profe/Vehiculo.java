package ejercicio14_profe;

public class Vehiculo {
	
	private double gastoKm;
	
	public Vehiculo(double gastoKm) {
		this.gastoKm = gastoKm;
	}

	public double getGastoKm() {
		return gastoKm;
	}

	public void setGastoKm(double gastoKm) {
		this.gastoKm = gastoKm;
	}
	
	public double gastadoTrayectoria(Punto[] puntos) {
		
		double result = 0;
		
		for(int i=0;i<puntos.length-1;i++)
			result += puntos[i].distancia(puntos[i+1]);
		
		return result*gastoKm;
	}
	
	public double gastadoTrayectoria_v2(Trayectoria t) {
		
		double result = 0;
		
		for(int i=0;i<t.getPuntos().length-1;i++)
			//result += t.getPuntos()[i].distancia(t.getPuntos()[i+1]);
			result += Punto.distancia(t.getPuntos()[i],t.getPuntos()[i+1]);
		return result*gastoKm;
	}
	
	

}
