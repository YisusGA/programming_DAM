package interfaz;

// Esta etiqueta no es obligatoria, pero es una buena práctica ponerla. 
// Además, va a hacer que si yo meto dentro de la clase más de un método
// vacío, el compilador me muestre un error
@FunctionalInterface
public interface Operar {

	int operar(int op1, int op2);

}
