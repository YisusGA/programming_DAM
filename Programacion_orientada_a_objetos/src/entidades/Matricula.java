package entidades;

class Matricula {
	int codigo;
	String descripcion;
	double cantidad;
	double cantidadConIVA(int iva) {
		double result = cantidad + cantidad * iva / 100; //Cuidado, con que aquí el resultado sea double. Como cantidad
		                                                 //es double, promociona iva a double y result será double
		return result;
	}
}
