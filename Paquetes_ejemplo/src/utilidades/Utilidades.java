package utilidades;

import modelo.especiales.AlumnoCiego;

class Utilidades {
	char caracter;
	//El nombre de la clase Alumno es en verdad modelo.Alumno (paquete.Clase)
	boolean empiezaPor(modelo.Alumno o) {
//		La propiedad nif de la clase Alumno no es accesible porque no le hemos puesto el modificador public en la clase modelo.Alumno
//		System.out.println(o.nif);
		return o.nombre.charAt(0) == caracter;
	}
	//Puedo usar el nombre corto de la clase porque he importado la clase al principio del código
	//CIUDADO: si tuviera también una clase AlumnoCiego dentro del paquete utilidades, la JVM va a entender que AlumnoCiego se refiere a la clase que hay
	//dentro de su mismo paquete. La forma de solucionar esto sería no hacer import y llamar a la clase AlumnoCiego con su nombre completo:
	//modelo.especiales.AlumnoCiego
	String getGrado(AlumnoCiego a) {
		return a.grado;
	}

}
