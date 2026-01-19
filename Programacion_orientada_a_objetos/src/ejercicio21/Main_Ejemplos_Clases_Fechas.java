package ejercicio21;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalDate;

public class Main_Ejemplos_Clases_Fechas {

	public static void main(String[] args) throws ParseException {

		Scanner scan = new Scanner(System.in);
		Empleado emp = new Empleado();
		emp.setNif("1111");
		emp.setNombre("Ana");
		emp.setSueldo(2000);

		String pattern = "dd-MM-yyyy";
		SimpleDateFormat formater = new SimpleDateFormat(pattern);

		System.out.println("Introduzca fecha contrato(dd-mm-yyyy)");
		String fechaString = scan.nextLine();
		Date fecha = formater.parse(fechaString);
		emp.setFechaContrato(fecha);

		System.out.println("Introduzca fecha contrato(dd-mm-yyyy)");
		fechaString = scan.nextLine();
		String[] trozos = fechaString.split("-");
		int anyo = Integer.parseInt(trozos[2]);
		int mes = Integer.parseInt(trozos[1]);
		int dia = Integer.parseInt(trozos[0]);

		LocalDate fecha2 = LocalDate.of(anyo, mes, dia);

		System.out.println(emp.getFechaContrato());
		System.out.println(fecha2);

		System.out.println(fecha2.getDayOfWeek());

	}

}
