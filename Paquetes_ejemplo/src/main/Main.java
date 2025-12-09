package main;

import modelo.Alumno;

public class Main {

	public static void main(String[] args) {
		Alumno a = new Alumno("12", 7, "76");
		
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
		
//		Y con el método getter que hemos creado, podemos modificar la propiedad
		a.setNif("66");
	}

}
