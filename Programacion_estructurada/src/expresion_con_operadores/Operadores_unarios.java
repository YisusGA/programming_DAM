package expresion_con_operadores;

public class Operadores_unarios {

	public static void main(String[] args) {
		int contador = 0;
		contador++;
		//Es lo mismo que hacer:
		//contador = contador + 1
		//contador += 1
		//También podría poner ++contador y daría igual la posición del ++ en este caso concreto
		System.out.println("Contador 1: " + contador);
		
		int contador2 = 0;
		contador2--;
		//Es lo mismo que hacer:
		//contador2 = contador2 - 1
		//contador2 -= 1
		//También podría poner --contador y daría igual la posición del -- en este caso concreto
		System.out.println("Contador 2: " + contador2);
		
		//Podemos usar el incremento/decremento dentro de otras expresiones
		//En este caso, el orden del ++ o -- influye y mucho
		
		//Cuando se pone el incremento ++ después, primero realiza la operación aritmética
		//y luego incrementa el dato de la variable para futuros usos
		int contador3 = 0;
		int num1 = contador3++ + 3;
		System.out.println("num1: " + num1);
		System.out.println("Contador 3: " + contador3);
		//Cuando se pone el incremento ++ antes, primero incrementa el valor de la variable 
		//y luego realiza la operación aritmética
		int contador4 = 0;
		int num2 = ++contador4 + 3;
		System.out.println("num2: " + num2);
		System.out.println("Contador 4: " + contador4);

	}

}
