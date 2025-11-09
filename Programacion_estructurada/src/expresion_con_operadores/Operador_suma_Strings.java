package expresion_con_operadores;

public class Operador_suma_Strings {

	public static void main(String[] args) {
		String nombre = "Yisus ";
		String apellido = "Gómez";
		String nombreCompleto = nombre + apellido;
		System.out.println("Mi nombre es: " + nombreCompleto);
		
		//Concatenar cadena con otra cosa
		int num1 = 6;
		String nombre2 = nombre + num1;
		System.out.println("Prueba concatenar cadena con número: " + nombre2);
		//Mismo ejemplo con decimales
		double num2 = 6.3;
		String nombre3 = nombre + num2;
		System.out.println("Prueba 2 concatenar cadena con número: " + nombre3);
		
		//MUY IMPORTANTE, si concatenamos una cadena con números que luego van con el operador + también,
		//todo se convierte a String y se concatena. PERO ES FUNDAMENTAL que lo primero de todo sea el String.
		//Si ponemos el String, por ejemplo, al final, primero realizará las operaciones aritméticas y luego
		//convertirá eso a String y lo concatenará con el String del final
		String s1 = "Hola" + 1 + 2 + 3;
		String s2 = 1 + 2 + 3 + "Hola";
		System.out.println("String al principio: " + s1);
		System.out.println("String al final: " + s2);
		
		//Si queremos concatenar números como Strings pero no queremos meter ningún String, podemos meter un String vacío
		String s3 = "" + 1 + 2 + 3;
		String s4 = 1 + 2 + 3 + "";
		System.out.println("String vacía al principio: " + s3);
		System.out.println("String vacía al final: " + s4);

	}

}
