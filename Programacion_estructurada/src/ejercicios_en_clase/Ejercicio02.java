package ejercicios_en_clase;
import java.util.Scanner;
public class Ejercicio02 {

	public static void main(String[] args) {
		//Dime tu nota del examen y nota del examen recuperación (-1 si no te presentaste). Estás aprobado si aprobaste el primer examen 
		//o si la media de tu primer examen y recuperación es mayor o igual a 5. Si tenías que recuperar y no lo hiciste, te aviso.
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce la nota del examen. Pon los decimales con coma");
		double notaEx = scan.nextDouble();
		System.out.println("Introduce la nota del examen de recuperación");
		double notaRec = scan.nextDouble();
		String mensaje = notaEx >= 5 || ((notaEx + notaRec) / 2) >=5 ? "Has aprobado" : notaRec == -1 ? "Has suspenido y no te presentaste a la recu" : "Has suspendido";
		System.out.println(mensaje);
		scan.close();

	}

}
