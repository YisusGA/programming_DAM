package main;

import modelo.Alumno;
import utilidades.Utilidades;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Alumno a = new Alumno("Pedro", 7, "76");
		
//		No puedo llamar a la propiedad id porque no es pública
//		a.id = 24;
		
		//Llamamos a un método público de la clase Alumno
		System.out.println(a.idSobreCien());
		
//		No podemos consultar la propiedad nif de la clase Alumno porque es privada
//		System.out.println(a.nif);
		
		//En nuestro método main, para consultar el nif, tenemos que consultarla con el método getter que creamos en la clase Alumno
		//No podemos modificar la propiedad porque es privada
//		a.nif = "55";
		
		//Pero sí puedo consultarla
		System.out.println(a.getNif());
		
//		Y con el método setter que hemos creado, podemos modificar la propiedad
		a.setNif("66");
		
		Utilidades u = new Utilidades(); //Instanciamos utilidades en la instancia u
		System.out.println("Qué carácter quieres comprobar");
		u.caracter = scan.nextLine().charAt(0); //Leemos el valor de la propiedad caracter de la instancia u, instancia de la clase Utilidades
		System.out.println(u.empiezaPor(a)); //Usamos el método empiezaPor de la clase Utilidades para comprobar si el nombre del alumno a coincide
		                                     //con el caracter que hemos leído, y devolvemos un true o false. Como el método tiene como parámetro de 
		                                     //entrada la instancia del alumno (aunque luego usa su nombre), tenemos que poner entre los paréntesis la
		                                     //instancia del Alumno que hemos creado en este método main
		scan.close();
	}

}
