package empleados;

import hospital.Turnos;

public class Enfermero extends Empleado {
	// En cambio, en este caso, sí que tiene todo el sentido meter esta propiedad de
	// la clase enum en la clase Enfermero, pues Turno es una propiedad que aoporta
	// datos sobre Enfermero, no es algo que se use para "instanciar un tipo
	// concreto de enfermero"
	Turnos turno;

	public Enfermero(String nombre, String dni, double salario, Turnos turno) {
		super(nombre, dni, salario);
		this.turno = turno;
	}

	public Enfermero() {
	}

	public Turnos getTurno() {
		return turno;
	}

	public void setTurno(Turnos turno) {
		this.turno = turno;
	}

	@Override
	public double calcularSalario() {
		if (this.turno == Turnos.NOCHE) { // Ver explicación de esto en los apuntes del cuaderno, en el día 21/01/2026
			return this.salario * 1.2;
		}
		return this.salario;
	}

	@Override
	public String mostrarDatos() {
		return "Empleado [nombre=" + nombre + ", dni=" + dni + ", salario base=" + salario + ", turno=" + turno.name()
				+ "]";
	}

}
