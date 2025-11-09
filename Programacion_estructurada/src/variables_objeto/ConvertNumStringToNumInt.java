package variables_objeto;

public class ConvertNumStringToNumInt {

	public static void main(String[] args) {
		String c = "5";
		//Esto de debajo, nos da error, porque no podemos hacer operaciones aritméticas con un dato tipo String
		//int n3 = c * 3;
		
		//Pero podemos convertir un dato tipo String que sea un número, a un dato tipo numérico (byte, short, int, long).
		//CUIDAD, esto sólo puede hacerse con un dato tipo String, no con un char
		int n = Integer.parseInt(c);
		//Y ahora sí podemos operar con él
		n *= 2;
		System.out.println(n);

	}

}
