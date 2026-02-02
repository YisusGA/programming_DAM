package colecciones.arrayList;

public class Main {

	public static void main(String[] args) {

		// String[] nombres = new String[???]

		// Yo creo esta caja y voy haciendo cosas con ella
		MiArrayListChuloConStrings nombres = new MiArrayListChuloConStrings();

		nombres.add("Luis");
		nombres.add("Ana");

		// Queremos tener la posibilidad de recorrer la colección para acceder a
		// elementos de la colección

		String nombre = nombres.get(0);
		System.out.println(nombre);

		for (int i = 0; i < nombres.size(); i++) {
			System.out.println(nombres.get(i));
		}

		nombres.delete(2);
		System.out.println("********************************");
		MiArrayChulo<String> cajaCadenas = new MiArrayChulo<String>(); // Aquí es donde creo un objeto de mi clase
																		// MiArrayChulo y le digo del tipo que es
																		// (String en este caso)

		MiArrayChulo<Alumno> cajaAlumnos = new MiArrayChulo<Alumno>(); // Aquí es donde creo un objeto de mi clase
																		// MiArrayChulo y le digo del tipo que es
																		// (Alumno en este caso)

		cajaAlumnos.add(new Alumno("Carlos", 10));
		cajaAlumnos.add(new Alumno("Ana", 5));
		for (int i = 0; i < cajaAlumnos.size(); i++) {
			System.out.println(cajaAlumnos.get(i));
		}

		// Sólo podemos añadir datos del tipo que se ha creado
		// cajaAlumnos.add("Luis");

		// Para los datos primitivos, hay que usar el Wrapper
		MiArrayChulo<Integer> cajaNotas = new MiArrayChulo<>();

		cajaNotas.add(6);

		// Double f = new Double(1.6); //Aunque esto es correcto, no hace falta
		// hacerlo, de hecho, está deprecado
		Double d1 = 1.6; // Promociona el dato 1.6 a dato objeto. Ys tiene métodos
		double d2 = 3.6; // Este no tiene métodos
		d1 = d2; // Se pueden asignar entre sí
		d2 = d1;

		MiArrayChulo caja = new MiArrayChulo(); // Me deja crear el objeto sin declarar el tipo (usar la clase SIN
												// PARAMETRIZARLA), porque asume que es Object, pues toda clase hereda
												// de Object en última instancia. Esto es problemático,
												// porque tendría que meter luego un montón de instanceof y de castings,
												// dependiendo de qué tipo de dato meta luego. Nos sale un aviso a la
												// izquierda advirtiendo de esto
		caja.add("jgh");
		caja.add(new Alumno("Pepe", 10));

		Object o = caja.get(0);

	}

}
