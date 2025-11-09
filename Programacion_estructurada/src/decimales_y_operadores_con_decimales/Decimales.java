package decimales_y_operadores_con_decimales;

public class Decimales {

	public static void main(String[] args) {
		//Podemos ver cuántas cifras decimales puede almacenar una variable de tipo float y de tipo double
		System.out.println(Float.MAX_VALUE);
		System.out.println(Double.MAX_VALUE);
		
		double num1 = 5.7;
		//Como la JVM trabaja por defecto con double, tenemos que poner una f al final del número que asignemos a una variable de tipo float, para que no dé error el compilador
		float num2 = 7.8f;
		//La JVM puede promocionar de float a double, pero no al revés
		double num3 = num1 / num2;
		System.out.println(num3);
		
		//El resultado del operador de num4 de debajo debería dar 0.333333333..., pero da 0.0. Esto es porque tanto 1 como 3 son datos de tipo int, y el resultado de operar con ellos es un dato de tipo int. Por tanto, se queda con el cociente 
		//entero, que es 0. Como num4 es una variable de tipo double, muestra el 0 como 0.0
		double num4;
		num4 = 1 / 3;
		System.out.println(num4);
		
		//La forma de solucionarlo es como se ve debajo
		double num5;
		num5 = 1.0 / 3.0;
		System.out.println(num5);
		
		//También podríamos solucionarlo realizando un casting
		double num6;
		num6 = (double) 1 / 3;
		System.out.println(num6);
	}

}
