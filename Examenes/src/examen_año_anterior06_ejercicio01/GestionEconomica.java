package examen_año_anterior06_ejercicio01;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GestionEconomica {
	static Set<ApunteEconomico> apuntes = new HashSet<>();
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int numApuntes = 2;
		for (int i = 0; i < numApuntes; i++) {
			crearApunte();
		}

		System.out.println("Introduce código de apunte a buscar");
		int code = scan.nextInt();
		ApunteEconomico ap = buscarApunte(code);
		if (ap != null) {
			System.out.println("El apunte encontrado es:");
			System.out.println(ap);
		} else {
			System.err.println("No existe un apunte con ese código");
		}

		System.out.println("Introduce el año para buscar el importe total");
		int year = scan.nextInt();
		System.out.println(importeTotalFacturas(year));

	}

	public static void crearApunte() {
		ApunteEconomico apunte = null;
		int year;
		int ser;
		Seriales serial;
		Integer code;
		do {
			System.out.println("Introduce el año del código de apunte económico (4 primeras cifras)");
			year = scan.nextInt();
			System.out.println("Introduce el código serial de apunte económico (cifras de la 5 en adelante)");
			ser = scan.nextInt();
			serial = new Seriales(ser);
			code = ApunteEconomico.generarCode(year, serial);
			if (code == null) {
				System.err.println("El serial debe ser un código único");
			}
		} while (code == null);
		System.out.println("Introduce el importe del apunte");
		double importe = scan.nextDouble();
		scan.nextLine(); // Descartamos línea vacía
		System.out.println("Introduce el concepto del apunte económico");
		String concepto = scan.nextLine();
		TipoApunte tipo;
		do {
			System.out.println("Introduce un tipo de apunte válido: FACTURA, GASTO");
			String input = scan.nextLine();
			tipo = TipoApunte.devolverTipo(input);
		} while (tipo == null);
		switch (tipo) {
		case FACTURA -> {
			System.out.println("Introduce el emisor de la factura");
			String emisor = scan.nextLine();
			System.out.println("Introduce el id de la factura");
			int id = scan.nextInt();
			scan.nextLine();
			apunte = new Factura(code, importe, concepto, tipo, id, emisor);
			System.out.println("Factura añadida");
		}
		case GASTO -> {
			System.out.println("Introdude la fecha: aaaa-mm-dd");
			LocalDate fecha = LocalDate.parse(scan.nextLine());
			System.out.println("Introduce el dni del emisor");
			String dni = scan.nextLine();
			apunte = new GastoEmpresarial(code, importe, concepto, tipo, fecha, dni);
		}
		}
		apuntes.add(apunte);
	}

	public static ApunteEconomico buscarApunte(int code) {
		ApunteEconomico ap = null;
		for (ApunteEconomico i : apuntes) {
			if (i.getCode() == code) {
				ap = i;
			}
		}
		return ap;
	}

	public static int importeTotalFacturas(int year) {
		int importe = 0;
		for (ApunteEconomico i : apuntes) {
			if (i.getEjercicioActual() == year) {
				importe += i.getImporte();
			}
		}
		return importe;
	}

}
