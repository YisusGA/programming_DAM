package variables_char;

public class Variables_char {

	public static void main(String[] args) {
		char c;
		c = 'h';
		System.out.println(c);
		c = '1';
		System.out.println(c);
		//Al ir entre comillas dobles, imprime literalmente lo que hay entre las comilllas dobles
		System.out.println("c");
		
		//En los 2 casos de debajo, se imprime en la consola lo mismo, es decir, una A
		char ascii01;
		ascii01 = 'A';
		System.out.println(ascii01);
		ascii01 = 65;
		System.out.println(ascii01);
		//En el caso de debajo, no imprime el caracter ASCII al que se corresponde el 6, pues el 6 va entre comillas simples. Por tanto, está tratando el 6 como un caracter que almacena dentro de la variable ascii02. Por tanto, imprime un 6
		char ascii02;
		ascii02 = '6';
		System.out.println(ascii02);
		//El caso de debajo daría error de compilación, pues estamos intentando almacenar 2 caracteres dentro de la variable de tipo char, que sólo puede almacenar 1 caracter
		//char ascii03;
		//ascii03 = '66';
		//System.out.println(ascii03);
		
		//Asignar una variable en la misma sentencia donde se declara se llama inicializar una variable. Posteriormente, se le puede asignar otro valor
		int n1 = 90;
		System.out.println(n1);
		n1 = 95;
		System.out.println(n1);
		
		//Esto da error porque n podría ser demasiado grande, y la variable caracter es de tipo char, y sólo podemos asignarle números que entren en la tabla ASCII. Daría error incluso aunque la variable n2 fuera de tipo byte o short
		//int n2 = 90;
		//char caracter = 'J';
		//caracter = n2;
		
		//Esto sí que estaría permitido
		int n3 = 90;
		char caracter1;
		caracter1 = 90;
		
		
		int n2 = 90;
		char caracter2 = 'J';
		n2 = caracter2;
		//Esto imprime una J porque la VM sabe que caracter2 es una variable de tipo char, y lo que más puede interesarnos es mostrar el caracter
		System.out.println(caracter2);
		//Esto imprime un 74 porque la VM sabe que n2 es una variable de tipo int, y lo que más puede interesarnos es mostrar el número ASCII al que se corresponde el caracter J del que toma su valor
		System.out.println(n2);
	}

}
