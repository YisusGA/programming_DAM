package entidades;

public class Main2 {

	public static void main(String[] args) {
		Alumno alumno = new Alumno(); //Instancio la clase Alumno
		alumno.nif = "324";
		alumno.nombre = "Pepe";
		alumno.edad = 56;
		alumno.matricula = new Matricula(); //Primero tengo que instanciar la clase Matricula que está como propiedad dentro de la clase Alumno
		
		alumno.matricula.codigo = 43;
		alumno.matricula.descripcion = "dam";
		alumno.matricula.cantidad = 76.5689;
		System.out.printf("Has pagado %.2f %n", alumno.matricula.cantidad);
		
		//Quiero ver so el alumno es mayor de edad
		alumno.esMayorEdad(); //Este método va a trabajar con este objeto en concreto, que es objeto de la clase Alumno
		
		Alumno alumno2 = new Alumno();
		alumno2.edad = 12;
		alumno2.esMayorEdad(); //Se usan los datos de alumno2 para ejecutar el método esMayorEdad
	}

}
