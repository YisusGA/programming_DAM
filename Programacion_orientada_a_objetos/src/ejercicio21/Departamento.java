package ejercicio21;

public class Departamento {
	
	private String nombre;
	private Empleado director;
	private Empleado[] empleados = new Empleado[0];
	
	public String getNombre() {
		return nombre;
	}
	public Empleado getDirector() {
		return director;
	}
	public Empleado[] getEmpleados() {
		return empleados;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDirector(Empleado director) {
		this.director = director;
	}
	public void setEmpleados(Empleado[] empleados) {
		this.empleados = empleados;
	}
	
	public void agregarEmpleado(Empleado emp) {
		
//		if(empleados == null) {
//			empleados = new Empleado[1];
//			empleados[0] = emp;
//			return;
//		}
		
		Empleado[] aux 
			= new Empleado[empleados.length+1];
		for(int i=0;i<empleados.length;i++) {
			aux[i] = empleados[i];
		}
		aux[aux.length-1] = emp;
		empleados = aux;
		
		
		
	}
	
	

}
