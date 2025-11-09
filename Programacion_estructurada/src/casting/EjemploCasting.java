package casting;

public class EjemploCasting {

	public static void main(String[] args) {
		int num1 = 4;
		//Esto es un tipo de casting que ya hemos visto, la promoción automática. Promociona el 4 a 4.0 y luego suma
		double dec1 = num1 + 4.5;
		System.out.println(dec1);
		
		//Esto sería un casting para convertir a entero un decimal. Elimina la parte decimal, no redondea.
		//Hay que tener cuidado, porque nos estamos cargando información del número decimal. Tenemos que 
		//estar muy seguros de que queremos hacer esto.
		int num2 = (int) (num1 + 4.5);
		//Si no hubiéramos puesto el casting a int, habría dado error, pues no se puede convertir un double a un int. Descomentar la línea de debajo para comprobarlo
		//int num2 = num1 + 4.5;
		System.out.println(num2);	
	}

}
