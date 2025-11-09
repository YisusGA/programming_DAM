package operadores_de_bits;

public class OperadoresBits {

	public static void main(String[] args) {
		int n1 = 5 * 2;
		//Esto es lo mismo que multiplicar por 2, porque transforma el 5 a binario y le mete un 0 por la derecha 
		//y desplaza todos los bits 1 posición a la izquierda, descartando el bit de más a la izquierda. Esto hace que todos los 1 del número binario 
		//aumenten su potencia en 2^1. Por tanto, es lo mismo que multiplicar el número por 2. Si en lugar de 1 a la derecha de << ponemos un número x,
		//el número de desplazamientos será igual a x, y meterá tantos 0 como valga x. Si x = 2, serán 2 desplazamientos, o lo mismo que multiplicar 
		//por 4; si x = 3, serán 3 desplazamientos, o lo mismo que multiplicar por 8. Y así sucesivamente. Este operador siempre mete ceros a la derecha
		int n2 = 5 << 1;
		System.out.println("1: " + n1);
		System.out.println("2: " + n2);
		//Hay que tener cuidado, pues se puede modificar el signo. En el caso de debajo, es 2^31 con el signo cambiado. Esto es así porque el 1, que
		//inicialmente estaba en la posición 1 (2^0 = 1), pasa a la posición 32, que es la posición de más a la izquiera de un número de 32 bits, que
		//es lo que almacena un int. Por lo tanto, el signo cambia a negativo. Y como está en la posición 32, esto es -2^31 = -2147483648
		int n3 = 1 << 31;
		System.out.println("3: " + n3);
		//No ocurre esto si desplazamos 30 posiciones. Esto sería +2^30, pues el 1 pasa a estar en posición 31, 
		//y la posición 32 sigue siendo un 0 (número positivo)
		int n4 = 1 << 30;
		System.out.println("4: " + n4);
		//Y si desplazamos 32 posiciones, el 1 vuelve a dar la vuelta a la posición de inicio. Y el bit de mayor peso sigue siendo 0, por lo que el
		//número se queda inalterado y sigue siendo +1
		int n5 = 1 << 32;
		System.out.println("5: " + n5);
		
		//De forma similar, si queremos desplazar a la derecha (o lo que es lo mismo, dividir por potencias de 2), usamos el operador binario >>.
		//Este operador desplaza el conjunto de bit a la derecha  y agrega a la izquierda los bits que faltan según el bit de signo, o sea el más significativo. 
		//Si se encuentra con un número positivo (el bit de signo vale 0 ), entonces agrega ceros, en cambio si el número es negativo (el bit de signo vale 1), 
		//entonces agrega unos. Este proceso, denominado extensión de signo mantiene el signo del número como si se tratara de una 
		//división. Por esto se lo conoce como desplazamiento con signo. Esencialmente, en Java, siempre que un número binario comience por 0, será
		//positivo, según el complemento a dos. De forma contraria, si comienza por 1, será negativo, según el complemento a dos. En Java, el bit de mayor peso
		//(el de más a la izquierda) siempre se utiliza para almacenar el signo del número.
		//Ver el word de operadores y el de signos en java para entenderlo bien
		int n6 = 64 / 2;
		int n7 = 64 >> 1;
		System.out.println("6: " + n6);
		System.out.println("7: " + n7);
		int n8 = -1 / 2;
		int n9 = -1 >> 2;
		//Como vemos, el número se mantiene inmutable. Ver mejor la explicación del word para entenderlo.
		System.out.println("8: " + n8);
		System.out.println("9: " + n9);
		//No es lo mismo si hacemos un desplazamiento a la derecha usando >>> en lugar de >>. En el caso de >>>, introduce x desplazamientos a la derecha,
		//pero introduciendo siempre 0. Esto hace que el número sea siempre positivo. Este operador se llama operador de desplazamiento a la derecha sin signo.
		//Este operador suele ser más adecuado que el >> cuando queremos manipular los bits mismos, no su representación numérica
		int n10 = -1 >>> 2;
		System.out.println("10: " + n10);
		//Ver el word para entender este número tan extraño que sale como resultado

	}

}
