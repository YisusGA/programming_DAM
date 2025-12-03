package ejercicio11;

class Cuenta {
	String titular;
	double cantidad;
	double ingresar(double cantidadIngresar) {
		if (cantidad > 0) {
		cantidad += cantidadIngresar;
		}
		return cantidad;
	}
//	Podríamos usar el mismo nombre de variable entre paréntesis y que la que ya teníamos antes. Si no ponemos nada, la JVM entiende que se refiere siempre
//	a la que hay entre los paréntesis. Si ponemos this.cantidad, le decimos que se refiere a la que hay arriba, no dentro de los paréntesis. Lo más fácil sería
//	llamar diferente a las variables y ya
//	double ingresar(double cantidad) {
//		if (cantidad > 0) {
//		this.cantidad += cantidad;
//		}
//		return cantidad;
//	}
	double retirar(double cantidadRetirar) {
		cantidad -= cantidadRetirar;
		if (cantidad < 0) {
			cantidad = 0;
		}
		return cantidad;
	}
}
