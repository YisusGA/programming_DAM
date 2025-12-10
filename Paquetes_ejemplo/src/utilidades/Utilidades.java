package utilidades;

import modelo.especiales.AlumnoCiego;

public class Utilidades {
	public char caracter;
	//El nombre de la clase Alumno es en verdad modelo.Alumno (paquete.Clase)
	public boolean empiezaPor(modelo.Alumno o) { //El parámetro de entrada es una instancia de Alumno, con todas sus propiedades
//		La propiedad nif de la clase Alumno no es accesible porque no le hemos puesto el modificador public en la clase modelo.Alumno
//		System.out.println(o.nif);
		return o.nombre.charAt(0) == caracter; //De todas las propiedades de la instancia de Alumno, usamos el nombre para buscar el char en posición 0
	}
	//Puedo usar el nombre corto de la clase porque he importado la clase al principio del código
	//CIUDADO: si tuviera también una clase AlumnoCiego dentro del paquete utilidades, la JVM va a entender que AlumnoCiego se refiere a la clase que hay
	//dentro de su mismo paquete. La forma de solucionar esto sería no hacer import y llamar a la clase AlumnoCiego con su nombre completo:
	//modelo.especiales.AlumnoCiego
	public String getGrado(AlumnoCiego a) {
		return a.grado;
	}

}
