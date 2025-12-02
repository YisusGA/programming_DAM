package entidades;

public class Alumno {

	//Atributos == propiedades == campos == variables. Las propiedades son las variables que hemos usado hasta ahora
	String nif, nombre;
	int edad;
	//Si quisiera añadir por ejemplo los padres de un alumno, lo añado simplemente en la clase Alumno y ya puedo usar esa propiedad en todas las
	//aplicaciones que usen la clase Alumno, sin necesidad de ir cambiando todos los programas
	
	Matricula matricula; //Esta sería la forma de relacionar la clase Matricula con la clase Alumno. Una matrícula no tiene sentido de existencia en
	//la realidad si no va asociada a un alumno. Por tanto, dentro de la clase Alumno, podemos meterle un tipo de dato objeto (Matrícula) para que
	//ahora pertenezca a él también. Y la variable que creamos para ese tipo de dato objeto la podemos llamar como queramos, aunque lo ideal es que sea
	//un nombre representativo (en este caso, la hemos llamado matricula, que es lo que más sentido tiene)
	
	//Métodos: códigos que los objetos alumno, creados en tiempo de ejecucion, pueden llamar
	
	//Lo de debajo es un método que se limita a mostrar por consola algo, no devuelve ningún valor. Como no devuevle ningún valor, ponemos el void
	void esMayorEdad() { //De momento, los paréntesis se quedan vacíos, pero ya los llenaremos
		//El código que hagamos aquí tiene acceso directamente a todas las propiedades del objeto que lo llama. En este caso, tiene acceso a las 
		//propiedades de Alumno.
		if (edad >= 18) {
			System.out.println("Es mayor de edad");
		} else {
			System.out.println("Es menor de edad");
		}
	}
}
