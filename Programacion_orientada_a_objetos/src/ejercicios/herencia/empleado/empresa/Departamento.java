package ejercicios.herencia.empleado.empresa;

import ejercicios.herencia.empleado.empleados.Empleado;

public class Departamento {
	private String nombre = "";
	private Empleado[] empleados = {new Empleado("Luis", 5, "enero"), new Empleado("Jimmy", 42, "febrero")};
	
//	empleados = new Empleado[1];
	
	public void addEmpleado (Empleado e) {
		if (empleados == null) {
			empleados = new Empleado[1];
			empleados[0] = e;
		}
	}
	
}
