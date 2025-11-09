package edad;

public class Promocion_automatica {
	public static void main (String[] args) {
		int edad;
		edad = 78;
		long edadTocha;
		//Podemos asignar a una variable el valor de otra variable, siempre que sea del mismo tipo
		edadTocha = edad;
		System.out.println(edadTocha);
		edad = 79;
		//Al cambiar el valor de la variable edad, del que edadTocha tomó su valor, no cambia el valor de edadTocha, pues ambas variables no están vinculadas, sino que edadTocha tomó puntualmente el valor de edad cuando la asignamos
		System.out.println(edadTocha);
		//Como se observa, podemos asignar a una variable de tipo long el valor de una variable de tipo int, pues la VM hará promoción automática y añadirá tanto 0 como sea necesarios para llenar los 64 bits. Lo inverso no podría hacerse
	}

}
