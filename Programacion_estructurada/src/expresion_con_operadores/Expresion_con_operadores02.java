package expresion_con_operadores;

public class Expresion_con_operadores02 {

	public static void main(String[] args) {
		
		int n1 = 7;
		int n2 = 8;
		int n3 = 12;
		n1 = (n3-120*n2)/n3;
		System.out.println(n1);
		
		//Lo de debajo da error porque se opera con la variable n6, que es de tipo long, para calcular el valor de la variable n4, que es de tipo int. No se puede convertir de long a int
		//int n4 = 7;
		//int n5 = 8;
		//long n6 = 12;
		//n4 = (n6-120*n5)/n6;
		//System.out.println(n4);
		
		//Se soluciona declarando n4 como variable de tipo long
		long n4 = 7;
		int n5 = 8;
		long n6 = 12;
		n4 = (n6-120*n5)/n6;
		System.out.println(n4);
	}

}
