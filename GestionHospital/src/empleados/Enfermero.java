package empleados;

import hospital.Turnos;

public class Enfermero extends Empleado {
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
		return "Empleado [nombre=" + nombre + ", dni=" + dni + ", salario base=" + salario + ", turno=" + turno.name() + "]";
	}

}
