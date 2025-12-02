package entidades;

class Main {

	//Este es el método main: este es el método al que llama la JVM cuando arranca la aplicación. Es el punto de arranque de la aplicación
	public static void main(String[] args) {
		
		//Instanciar un objeto alumno:
		Alumno alumno1 = new Alumno(); //alumno1 es una variable de tipo objeto, pues es una instancia de la clase Alumno. Por tanto, lo que se guarda
		                               //en la variable alumno1 es la dirección de memoria que apunta a los datos que vaya a tener esa variable tipo
		                               //objeto (mirando la clase Alumno, sería el nif, el nombre y la edad). En el momento de instanciarlo, apunta a 
		                               //una dirección de memoria para almacenar 2 String (nif y nombre) y un int (edad).
		
		//alumno1 es una variable de tipo objeto con 3 campos: nif, nombre y edad
		alumno1.nif = "123456789";
		alumno1.nombre = "Yisus";
		alumno1.edad = 32;
		
		//Instanciasr otro alumno, que usa la misma plantilla (clase) que el alumno anterior
		Alumno alumno2 = new Alumno();
		alumno2.nif = "567891234";
		alumno2.nombre = "Pedro";
		alumno2.edad = 30;
		
		//PRACTICAMOS CON EJEMPLOS
		
		//¿Qué alumno es mayor?
		if (alumno1.edad > alumno2.edad) {
			System.out.println("Es mayor el primero");
		} else if (alumno1.edad > alumno2.edad) {
			System.out.println("Es mayor el segundo");
		} else {
			System.out.println("Tienen la misma edad");
		}
		
		//Asignar al primer alumno el nombre del segundo
		alumno1.nombre = alumno2.nombre;
		
		//Array de alumnos. Tener en cuenta que ahora mi tipo de dato Alumno
		int arraySize = 100;
		Alumno[] alumnos = new Alumno [arraySize];
		for (int i = 0; i < alumnos.length; i++) {
			alumnos[i] = new Alumno();
		}
		for (int i = 0; i < alumnos.length; i++) {
			alumnos[i].edad = (int) (Math.random() * 100);
		}
		
		//Imprimimos el array. El tipo de dato debe ser de tipo Alumno, de la misma manera que antes poníamos int i : whatever o String i : whatever
		System.out.print("Edades: ");
		for (Alumno a : alumnos) {
			System.out.print(a.edad + ", "); //Tenemos que poner la propiedad que queremos mostrar, en este caso, la edad. En un futuro, veremos cómo
			                                 //aplanar la variable para que nos sepa mostrar todas las propiedades de la variable
		}
		
		System.out.println();
		System.out.print("Nombres: ");
		for (Alumno a : alumnos) {
			System.out.print(a.nombre + ", ");
		}
	}

}
