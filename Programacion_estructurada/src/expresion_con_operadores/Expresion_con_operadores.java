package expresion_con_operadores;

public class Expresion_con_operadores {

	public static void main(String[] args) {
		int num1 = 34;
		int num2;
		num2 = num1 + 12;
		System.out.println(num2);
		
		int num3 = 34;
		int num4;
		num4 = num3 + 12;
		long num5 = 7899999999L;
		//La línea de debajo dará error de compilador, pues el resultado de la operación es un número que no cabe en 32 bits, que es el tipo de variable que es num3
		//num3 = num4 + num5;
		//Esto de debajo sí que está permitido, pues el resultado es un valor que cabe en 64 bits, que es el tipo de variable que es num5
		num5 = num3 + 7;
		
		//Con esto de debajo, convertiríamos una letra mayúscula a minúscula, pues -32 es la distancia de una minúscula respecto a su mayúscula correspondiente en una tabla ASCII. El problema es que el resultado de la operación es de tipo int,
		//y el compilador nos dará error porque no puede convertir int a char
		//char letra1 = 'a';
		//char letraMay1;
		//letraMay1 = letra1 - 32;
		
		//Esto solucionaría el problema, pues ahora la variable letraMay2 es de tipo int. El problema sería que letraMay2, al ser de tipo int, nos mostrará un número
		char letra2 = 'a';
		int letraMay2;
		letraMay2 = letra2 - 32;
		System.out.println(letraMay2);
		//Si queremos que nos muestre una letra, tenemos que poner lo siguiente en el método print. Esto se llama hacer CASTING, y también puede emplearse para mostrar el valor entero de una variable de tipo char (poniendo int en lugar de char)
		System.out.println((char)letraMay2);

	}

}
