package ejercicios.herencia.empleado.main;

import java.util.Scanner;

import ejercicios.herencia.empleado.empleados.Gerente;
import ejercicios.herencia.empleado.empleados.Empleado;
import ejercicios.herencia.empleado.empresa.Departamento;
import ejercicios.herencia.empleado.empresa.Empresa;
import ejercicios.herencia.empleado.empleados.EmpleadoTemporal;

public class Main {

	static private Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("¿Cuál es el nombre de tu empresa?");
		Empresa empresa = new Empresa(scan.nextLine());

		int opcion;
		do {

			opcion = mostrarMenu();
			scan.nextLine();

			switch (opcion) {
			case 1 -> {
				System.out.println("Introduce el nombre del departamento");
				Departamento d = new Departamento(scan.nextLine());
				empresa.addDepartamento(d);
			}
			case 2 -> {
				System.out.println("Introduce el nombre del departamento");
				String nombreDepartamento = scan.nextLine();
				Empleado e = new Empleado();
				System.out.println("Introduce el nombre del empleado");
				e.setNombre(scan.nextLine());
				System.out.println("Introduce le fecha de inicio de contrato. Formato dd-mm-aaaa");
				e.setFecha(scan.nextLine());
				System.out.println("¿Cuál es el salario del empleado?");
				e.setSalario(scan.nextDouble());
				System.out.println("""
						¿Qué tipo de empleado quieres añadir? Introduce número
						1. Normal
						2. Gerente
						3. Temporal
						""");
				int tipoEmpleado = scan.nextInt();
				scan.nextLine();
				switch (tipoEmpleado) {
				case 1 -> {
					System.out.println(empresa.addEmpleadoADepartamento(e, nombreDepartamento));
				}
				case 2 -> {
					System.out.println("¿Cuál es el bonus del gerente?");
					((Gerente) e).setBonus(scan.nextDouble()); // Da error al hacer el casting
					System.out.println(empresa.addEmpleadoADepartamento(e, nombreDepartamento));
				}
				case 3 -> {
					System.out.println("¿Cual es la fecha de finalización del contrato? Formato dd-mm-aaaa");
					((EmpleadoTemporal) e).setFechaFinContrato(scan.nextLine()); // Da error al hacer el casting
					System.out.println(empresa.addEmpleadoADepartamento(e, nombreDepartamento));
				}
				default -> {
					System.err.println("La opción introducida no es válida");
				}
				}
			}
			case 3 -> { // Aquí se ve una forma de contemplar el caso de que no se hayan añadido aún
						// empleados
				if (empresa.getSalarioEmpresa() == 0) {
					System.err.println("Aún no se han añadido empleados ni departamentos a la empresa");
				} else {
					System.out.printf("El salario total de la empresa es de %.2f €%n", empresa.getSalarioEmpresa());
				}
			}
			case 4 -> { // Esta es otra forma de gestionar el caso de que no hayan añadido aún
						// empleados, controlándolo directamente en el método de empresa
				System.out.println(empresa.departamentoMayorGasto());
			}
			case 0 -> {
				System.out.println("Finalizando el programa...");
			}
			default -> {
				System.err.println("La opción introducida no es válida");
			}
			}

		} while (opcion != 0);

	}

	public static int mostrarMenu() {
		System.out.println("""
				Bienvenido

				¿Qué opción deseas realizar?
				1. Crear un departamento
				2. Incorporar empleado a departamento
				3. Mostrar salario total de la empresa
				4. Mostrar el departamento con el salario total más alto
				0. Finalizar el programa
				""");
		return scan.nextInt();
	}
}
