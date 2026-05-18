package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import model.Libro;

public class Biblioteca {
	private static File file = new File("data/catalogoLibros.dat");
	private static Map<String, Libro> libros = new TreeMap<>();

	public static void main(String[] args) {
		System.out.println("Lectura de fichero");
		System.out.println();
		lectura();
		System.out.println("Libros de terror");
		List<Libro> librosTerror = filtroTerror();
		if (librosTerror != null) {
			for (Libro l : librosTerror) {
				System.out.println(l);
			}
		} else {
			System.err.println("No hay libros de terror");
		}
		
		System.out.println();
		System.out.println(autoresDiferentes());
		System.out.println();
		
		System.out.println(librosMasDeUnAutor() + " libros han sido escritos por más de 1 autor");
		

	}
	
	public static void lectura() {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] campos = line.split(";");
				String isbn = campos[0];
			    String titulo = campos[1];
			    String[] autoresUnformated = campos[2].split(",");
			    List<String> autores = new ArrayList<>();
			    for (String s : autoresUnformated) {
			    	autores.add(s);
			    }
			    int anioPublicacion = Integer.parseInt(campos[3]);
			    String genero = campos[4];
			    String estante = campos[5];
			    double precioSugerido = Double.parseDouble(campos[6]);
				libros.put(isbn, new Libro(isbn, titulo, autores, anioPublicacion, genero, estante, precioSugerido));
			}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
			e.printStackTrace();
		} catch (IOException e1) {
			System.err.println("Error de IO");
			e1.printStackTrace();
		}
	}
	
	public static List<Libro> filtroTerror() {
		List<Libro> librosTerror = new ArrayList<>();
		Collection<Libro> aux = libros.values();
		for (Libro l : aux) {
			if (l.getGenero().equalsIgnoreCase("Terror")) {
				librosTerror.add(l);
			}
		}
		if (librosTerror.size() == 0) {
			librosTerror = null;
		}
		return librosTerror;
	}
	
	public static String autoresDiferentes() {
		String result = "";
		Set<String> autoresSet = new TreeSet<>();
		Collection<Libro> auxLibros = libros.values();
		for (Libro l : auxLibros) {
			autoresSet.addAll(l.getAutores());
		}
		result += "Número de autores diferentes: " + autoresSet.size() + "\n";
		for (String s : autoresSet) {
			result += s + "\n";
		}
		return result;
	}
	
	public static int librosMasDeUnAutor() {
		int contador = 0;
		Collection<Libro> auxLibros = libros.values();
		for (Libro l : auxLibros) {
			if (l.getAutores().size() > 1) {
				contador++;
			}
		}
		return contador;
	}

}
