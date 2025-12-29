package entidades;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Alumno alumno1 = new Alumno(); //Instancio la clase Alumno
		alumno1.nif = "324";
		alumno1.nombre = "Pepe";
		alumno1.edad = 56;
		alumno1.matricula = new Matricula(); //Primero tengo que instanciar la clase Matricula que está como propiedad dentro de la clase Alumno
		
		alumno1.matricula.codigo = 43;
		alumno1.matricula.descripcion = "dam";
		alumno1.matricula.cantidad = 76.5689;
		System.out.printf("Has pagado %.2f %n", alumno1.matricula.cantidad);
		
		//Quiero ver si el alumno es mayor de edad
		alumno1.esMayorEdad(); //Este método va a trabajar con este objeto en concreto, que es objeto de la clase Alumno
		
		Alumno alumno2 = new Alumno();
		alumno2.edad = 12;
		alumno2.esMayorEdad(); //Se usan los datos de alumno2 para ejecutar el método esMayorEdad
		
		//Quiero mostrar el código de matrícula de alumno1
		int codigoAlumno = alumno1.getCodigoMatricula();
		System.out.println("El código de matrícula es: " + codigoAlumno);
		//Si queremos simplemente mostrar el valor, podríamos directamente poner lo siguiente
		//System.out.println("El código de matrícula es: " + alumno2.getCodigoMatricula());
		
		//Queremos mostrar el precio de la matrícula del ALUMNO alumno1 con el IVA:
		System.out.println("Qué IVA aplica");
		int iva = scan.nextInt();
		//Podrías poner:
		//double precioAlumno1 = alumno1.matricula.cantidadConIVA(scan.nextInt());
		double precioAlumno1 = alumno1.matricula.cantidadConIVA(iva);
		System.out.println("El precio es: " + precioAlumno1);
	}

}
