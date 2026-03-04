package ejercicio05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import teclado.Teclado2;

public class Main {
	private static Map<String, Double> listaProductos = new HashMap<>();

	public static void main(String[] args) {
		int opcionElegida;
		double precio;
		String codigo;

		do {
			opcionElegida = mostrarMenu();

			switch (opcionElegida) {
			case 1 -> {
				if (listaProductos != null) {
					System.out.println("Introduce el códido del producto:");
					codigo = Teclado2.leerCadena();
					System.out.println("Introduce el precio del producto:");
					precio = Teclado2.leerDecimal();
					Double result = guardarProducto(codigo, precio);
					if (result == null) {
						System.out.println("Producto añadido");
					} else {
						System.out.println("El producto anterior se ha sustituido");
					}
				}
			}
			case 2 -> {
				if (listaProductos != null && listaProductos.size() > 0) {
					System.out.println("Introduce el códido del producto del que quieres cambiar el precio:");
					codigo = Teclado2.leerCadena();
					System.out.println("Introduce el nuevo precio del producto:");
					precio = Teclado2.leerDecimal();
					if (modificarPrecio(codigo, precio)) {
						System.out.println("Precio modificado con éxito");
					} else {
						System.err.println("No se ha encontrado un producto con el código especificado");
					}
				} else {
					System.err.println("No hay productos en la tienda");
				}

			}
			case 3 -> {
				if (listaProductos != null && listaProductos.size() > 0) {
					System.out.println(mostrarProductos());
				} else {
					System.err.println("No hay productos en la tienda");
				}
			}
			case 4 -> {
				if (listaProductos != null && listaProductos.size() > 0) {
					System.out.println("Introduce el códido del producto que quieres eliminar:");
					codigo = Teclado2.leerCadena();
					if (eliminarProducto(codigo)) {
						System.out.println("Producto eliminado con éxito");
					} else {
						System.err.println("No se ha encontrado un producto con el código especificado");
					}
				} else {
					System.err.println("No hay productos en la tienda");
				}
			}
			case 0 -> {
				System.out.println("Saliendo del programa...");
			}
			default -> {
				System.out.println("Tienes que introducir una opcion valida");
			}
			}
		} while (opcionElegida != 0);

	}

	public static int mostrarMenu() {
		System.out.println("""
				Bienvenido a Yisus Alimentación
				Introduce el numero de la opción que quieras:
				1. Introducir producto
				2. Modificar precio
				3. Mostrar todos los productos
				4. Eliminar producto
				0. Salir del menú
				""");
		return Teclado2.leerEntero();
	}

	public static Double guardarProducto(String codigo, double precio) {
		return listaProductos.put(codigo, precio);
	}

	public static boolean modificarPrecio(String codigo, double precio) {
		boolean modificado = false;
		if (listaProductos.replace(codigo, precio) != null) {
			modificado = true;
		}
		return modificado;
	}

	public static String mostrarProductos() {
		Set<Map.Entry<String, Double>> setProductos = listaProductos.entrySet();
		String result = "";
		for (Map.Entry<String, Double> entry : setProductos) {
			result += "Código de producto: " + entry.getKey() + " Precio del producto: " + entry.getValue() + "\n";
		}
		return result;
	}

	public static boolean eliminarProducto(String codigo) {
		boolean eliminado = false;
		if (listaProductos.remove(codigo) != null) {
			eliminado = true;
		}
		return eliminado;
	}

}
