package capacidad_int;

public class Capacidad_int {

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		
		//Definimos una variable de tipo int con el número máximo que puede ser contenido en 31 bits, que es la capacidad de int. En Java, SIEMPRE
		//se dedica uno de los bits (el de mayor peso, que es el de más a la izquierda) para almacenar el signo del número. Es por eso, que en el caso
		//de un int, el valor mayor es 2^31 = 2147483647 y el valor menor es -2^31 = -2147483647. Si el bit de mayor peso es 0, el número es positivo,
		//mientras que si es 1, el número es negativo.
		int edadTocha1;
		edadTocha1 = 2147483647;
		System.out.println(edadTocha1);
		
		
		//Definimos una variable de tipo int con un número mayor al máximo que puede ser contenido en 31 bits, que es la capacidad de int. Por tanto, al correrlo, daría error. Descomentar las 3 líneas de debajo para comprobarlo
		//int edadTocha2;
		//edadTocha2 = 2147483648;
		//System.out.println(edadTocha2);
		
		
		//Definimos una variable de tipo long con un número mayor al máximo que puede ser contenido en 31 bits, que es la capacidad de int. La forma correcta de asignar el dato a la variable es poniendo una L justo a continuación del número; si no hacemos esto,
		//la máquina virtual dará error al correr, pues por defecto usa un contenedor de 32 bits (31 bits más el signo), y este número no cabe en 31 bits. Para evitar eso, ponemos la mencionada L
		long edadTocha3;
		edadTocha3 = 2147483648L;
		System.out.println(edadTocha3);
		
		
		//Como se mencionó en el anterior comentario, si nos olvidamos de poner la L, la máquina virtual dará error al correr. Descomentar las 3 líneas de debajo para comprobarlo
		//long edadTocha4;
		//edadTocha4 = 21474836478;
		//System.out.println(edadTocha4);
		
		
		//Otro posible escenario, sería que declaremos una variable de tipo long, y al asignarla, pongamos un número entero que cabe en 31 bits, pero no pongamos la L a continuación del número. Cuando ejecutemos el código, la máquina virtual no generará
		//ningún error y todo funcionará sin problema. Lo que pasa es que conceptualmente, está mal hecho.
		long edadTocha5;
		edadTocha5 = 2147483647;
		System.out.println(edadTocha5);
	}

}
