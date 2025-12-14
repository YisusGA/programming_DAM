package redondeo_decimales;

public class Redondeo_decimales {
	
private int numeroCifrasDecimales;
	
	/**
	 * Definir el número de cifras decimales
	 * @param Número de cifras decimales que quieras
	 */
	public Redondeo_decimales(int numeroCifrasDecimales){
		this.numeroCifrasDecimales = numeroCifrasDecimales;
	}
	
	//Getter
	public int getDecimal() {
		return numeroCifrasDecimales;
	}
	
	//Setter
	public void setDecimal(int decimal) {
		this.numeroCifrasDecimales = decimal;
	}
	
	/**
	 * Método para redondear un número decimal a un número de cifras decimales especificado
	 * @param El número decimal que quieras redondear
	 * @return El numero decimal redondeado
	 */
	public double redondeador(double operator) {
		double multiplicacionesPor10 = Math.pow(10, numeroCifrasDecimales);
		return (double)((int)(operator*multiplicacionesPor10))/multiplicacionesPor10;
	}
}
