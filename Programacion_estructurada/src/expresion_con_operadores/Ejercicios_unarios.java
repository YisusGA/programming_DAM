package expresion_con_operadores;

public class Ejercicios_unarios {

	public static void main(String[] args) {
		int a = 5, b = 8, c = 12, d = 3;
		int resultado1 = ++a + b-- - --c + d++ * a-- - ++b + c++ / --d;
		System.out.println("Resultado1: " + resultado1);
		
		int x = 7, y = 4, z = 10, w = 2;
		int resultado2 = --x * y++ + ++z - w-- + x++ / --y - ++w * z-- + y-- % ++x;
		System.out.println("Resultado2: " + resultado2);
	}

}
