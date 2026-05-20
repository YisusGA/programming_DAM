package es.damdaw1.logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.damdaw1.modelo.Persona;

public class Operaciones {

	public static boolean insertPersona(Persona persona) {

		// 1. CREAR CONEXIÓN CON LA BASE DE DATOS
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pruebadam1", "root", "1234");
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

		// 2. EJECUTAR SENTENCIAS SQL
		try {
			Statement sentencia = con.createStatement();
			sentencia.executeUpdate("INSERT INTO personas(nombre,edad) " + "VALUES ('" + persona.getNombre() + "',"
					+ persona.getEdad() + ")");
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

		// 3. CERRAR CONEXIÓN
		try {
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

		return true;
	}

	public static boolean insertPersona2(Persona persona) {

		// CON TRY-WITH-RESOURCES:
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebadam1", "root", "1234");
				Statement sentencia = con.createStatement()){
			
			//Statement sentencia = con.createStatement();
			sentencia.executeUpdate("INSERT INTO personas(nombre,edad) " + "VALUES ('" + persona.getNombre() + "',"
					+ persona.getEdad() + ")");
			
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	public boolean deletePersona(Integer id) {
		//ELIMINARÍA DE LA TABLA LA PERSONA CON ID = id
		return true;
	}
	
	public boolean updatePersona(Persona p) {
		//ACTUALIZARÍA LA PERSONA CON ID = p.id CON LOS VALORES p.nombre y p.edad
		return true;
	}
	
	public static Persona getPersona(Integer id) {
		
		Persona persona = null;
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebadam1", "root", "1234");
				Statement sentencia = con.createStatement()){
			
			ResultSet registros 
				= sentencia.executeQuery("SELECT * FROM personas WHERE id = "+id);
			
			
			
			while(registros.next()) {
				
				
				String nombre = registros.getString("nombre");
				Integer edad = registros.getInt("edad");
				persona = new Persona(id, edad, nombre);
			}
			
			
			
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
		
		return persona;
	}
	
	public static List<Persona> getPersonasByNombre(String nombre){

		List<Persona> personas = new ArrayList<>();
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebadam1", "root", "1234");
				Statement sentencia = con.createStatement()){
			
			ResultSet registros 
				= sentencia.executeQuery("SELECT * FROM personas WHERE nombre = '"+nombre+"'");
			
			while(registros.next()) {
				Integer id = registros.getInt("id");				
				String nom = registros.getString("nombre");
				Integer edad = registros.getInt("edad");
				Persona persona = new Persona(id, edad, nom);
				personas.add(persona);
			}
						
			
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
		
		return personas;
	}
	
	//VERSIÓN SEGURA:
	public static List<Persona> getPersonasByNombre2(String nombre){

		List<Persona> personas = new ArrayList<>();
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebadam1", "root", "1234")
				){
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM personas WHERE nombre = ?");
			ps.setString(1,nombre);
			
			ResultSet registros 
				= ps.executeQuery();
			
			while(registros.next()) {
				Integer id = registros.getInt("id");				
				String nom = registros.getString("nombre");
				Integer edad = registros.getInt("edad");
				Persona persona = new Persona(id, edad, nom);
				personas.add(persona);
			}
						
			
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
		
		return personas;
	}
	
	public static List<Persona >getPersonasMayoresEdadByNombre(String nombre) {
		
		List<Persona> personas = new ArrayList<>();
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebadam1", "root", "1234")
				){
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM personas WHERE nombre = ? AND edad >= ?");
			ps.setString(1,nombre);
			ps.setInt(2, 18);
			
			ResultSet registros 
				= ps.executeQuery();
			
			while(registros.next()) {
				Integer id = registros.getInt("id");				
				String nom = registros.getString("nombre");
				Integer edad = registros.getInt("edad");
				Persona persona = new Persona(id, edad, nom);
				personas.add(persona);
			}
						
			
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
		
		return personas;
	}
	

}
