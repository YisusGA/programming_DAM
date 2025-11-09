package ejemplos_logicos;
import java.util.Scanner;

public class OperadorDobleSimple {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce edad del padre");
		int edadPadre = scan.nextInt();
		System.out.println("Introduce edad del hijo");
		int edadHijo = scan.nextInt();
		boolean cond = edadPadre >= 18 && edadPadre % edadHijo == 0;
		System.out.println("La condición es: " + cond);
		
		int edadPadre2, edadHijo2;
		//En este ejemplo, es crítico si ponemos && o &. Si ponemos &&, puede que no llegue a hacer la asignación de la edad del hijo.
		//Si ponemos &, le fuerzas a evaluar ambas condiciones, y tiene que hacer la asignación de la edad del hijo
		//En el ejemplo de debajo con &&, si introducimos como edadPadre2 un 15, automáticamente dará false sin realizar la evaluación
		//del segundo booleano (y no hará la asignación de le edadHijo2, por lo que no nos pedirá introducir la edadHijo2), dado que 
		//el primer booleano ya es false y automáticamente el booleano cond2 ya es false
		
		//En el caso de que introduzcamos 40 como edadPadre2, el primer booleano es verdadero, y necesita evaluar el segundo booleano
		//para determinar si es verdadero o no. En este caso, nos pedirá introducir la edadHijo2. Si introducimos 20, el segundo booleano
		//será verdadero y por tanto, el booleano cond2 será verdadero, al ser los 2 booleanos en su interior verdaderos
		System.out.println("Introduce otra vez la edad del padre y a continuación la edad del hijo");
		boolean cond2 = (edadPadre2 = scan.nextInt()) >= 18 && edadPadre % (edadHijo2 = scan.nextInt()) == 0;
		System.out.println("La condición 2 es: " + cond2);
		
		//Otro ejemplo sacado del word de resumen
		
		//Esto primero nos dará false, pues al evaluar el primer booleano, el resultado es false y no sigue evaluando el segundo booleano
        int x1 = 0;
        int y1 = 2;
        boolean b1 = ( x1 != 0 ) && ( ( y1 / x1 ) != 0 );
        System.out.println("La variable b1 es: " + b1);
        //Sin embargo, si ponemos un & en lugar de &&, le forzamos a evaluar el segundo booleano. Y descubre que el segundo booleano
        //no puede resolverse dado que su resultado genera una indeterminación. Por tanto, nos dará un error al ejecutarlo
        int x2 = 0;
        int y2 = 2;
        boolean b2 = ( x2 != 0 ) & ( ( y2 / x2 ) != 0 );
        System.out.println("La variable b2 es: "+ b2);
	}

}
