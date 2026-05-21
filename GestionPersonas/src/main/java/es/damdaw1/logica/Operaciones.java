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

	// La forma de hacerlo sería insertPersona2(Persona persona). Aquí está separado
	// por bloques para que sea más didáctico
	public static boolean insertPersona(Persona persona) {

		// 1. CREAR CONEXIÓN CON LA BASE DE DATOS
		// Cuidado: el import debe ser del paquete java.sql
		Connection con = null;
		try {
			// Parámetros: url con la dirección de la BBDD(API, connector, IP:puerto,
			// nombreBBDD), usuario y contraseña
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pruebadam1", "root", "1234");
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

		// 2. EJECUTAR SENTENCIAS SQL
		try {
			// Cuidado: el import debe ser del paquete java.sql
			Statement sentencia = con.createStatement();
			// El id no lo ponemos, porque en la BBDD hemos puesto que el id se genere de
			// forma autoincremental
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

	// Podemos aprovechar que el método executeUpdate devuelve el número de filas
	// afectadas de la tabla para devolver ese int
	public static int insertPersona2(Persona persona) {
		int personasInsertadas = 0;

		// CON TRY-WITH-RESOURCES:
		// Parámetros: url con la dirección de la BBDD(API, connector, IP:puerto,
		// nombreBBDD), usuario y contraseña
		// Como ya vimos, podemos usar los recursos de esta forma dentro de un try, y
		// así no tenemos que cerrarlos luego, pues se cierran automáticamente al
		// terminar. Podemos poner varios recursos dentro de los paréntesis del try,
		// separados por punto y coma
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebadam1", "root", "1234");
				Statement sentencia = con.createStatement()) {

			// Statement sentencia = con.createStatement();

			// El id no lo ponemos, porque en la BBDD hemos puesto que el id se genere de
			// forma autoincremental
			// Como vimos en BBDD, los varchar van entre comillas simples, y todo lo demás
			// (int en este caso) va sin comillas
			String insert = String.format("INSERT INTO personas(nombre,edad) VALUES ('%s',%d)", persona.getNombre(),
					persona.getEdad());
			// El método executeUpdate se usa para hacer INSERT, UPDATE y DELETE (las
			// operaciones DML)
			personasInsertadas = sentencia.executeUpdate(insert);
			// Así es como lo hizo Noelia, pero es más sencillo de la forma que lo he hecho
			// yo encima, porque puedo escribir con un formato
//			sentencia.executeUpdate("INSERT INTO personas(nombre,edad) " + "VALUES ('" + persona.getNombre() + "',"
//					+ persona.getEdad() + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return personasInsertadas;
	}

	public static int deletePersona(Integer id) {
		int personasEliminadas = 0;
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebadam1", "root", "1234");
				Statement sentencia = con.createStatement()) {
			String delete = String.format("DELETE FROM personas WHERE id=%d", id);
			personasEliminadas = sentencia.executeUpdate(delete);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personasEliminadas;
	}

	public static int updatePersona(Persona p) {
		// ACTUALIZARÍA LA PERSONA CON ID = p.id CON LOS VALORES p.nombre y p.edad
		int personasActualizadas = 0;
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebadam1", "root", "1234");
				Statement sentencia = con.createStatement()) {
			String update = String.format("UPDATE personas SET nombre='%s', edad=%d WHERE id='%d'", p.getNombre(),
					p.getEdad(), p.getId());
			personasActualizadas = sentencia.executeUpdate(update);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return personasActualizadas;
	}

	public static Persona getPersona(Integer id) {

		Persona persona = null;

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebadam1", "root", "1234");
				Statement sentencia = con.createStatement()) {

			// Aquí sólo va a devolver un registro, pues estamos buscando por id. Pero
			// dependiendo de la consulta,
			// podría devolver varios registros. Por ello, almacenamos el resultado de la
			// consulta en un ResultSet
			ResultSet registros = sentencia.executeQuery("SELECT * FROM personas WHERE id = " + id);

			// El método .next() de ResultSet avanza una posición en la consulta y devuelve
			// true si hay regitro,
			// o false si ya no hay más registros
			while (registros.next()) {

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

	// Esta versión es susceptible de que alguien haga una inyección SQL, pues
	// pueden pasarte como String pepe' OR '1' = '1, y consiguen la base de
	// datos entera, pues la condición a la derecha del OR siempre es cierta
	public static List<Persona> getPersonasByNombre(String nombre) {

		List<Persona> personas = new ArrayList<>();

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebadam1", "root", "1234");
				Statement sentencia = con.createStatement()) {

			String query = String.format("SELECT * FROM personas WHERE nombre= '%s'", nombre);
			ResultSet registros = sentencia.executeQuery(query);

			while (registros.next()) {
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

	// VERSIÓN SEGURA
	public static List<Persona> getPersonasByNombre2(String nombre) {

		List<Persona> personas = new ArrayList<>();

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebadam1", "root", "1234")) {

			// Aquí está la clave: Le decimos que sólo podemos pasar un parámetro,
			// admitiendo sólo un valor para nombre, para que no puedan pasarnos el OR y
			// hacer la inyección SQL. Para ello, usamos PreparedStatement, para decirle el
			// tipo de sentencia que vamos a usar, y así sólo admita lo que decimos que
			// admita
			PreparedStatement ps = con.prepareStatement("SELECT * FROM personas WHERE nombre = ?");
			ps.setString(1, nombre);

			ResultSet registros = ps.executeQuery();

			while (registros.next()) {
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

	public static List<Persona> getPersonasMayoresEdadByNombre(String nombre) {

		List<Persona> personas = new ArrayList<>();

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebadam1", "root", "1234")) {

			PreparedStatement ps = con.prepareStatement("SELECT * FROM personas WHERE nombre = ? AND edad >= ?");
			// Como en la consulta hacen falta 2 parámetros, pasamos los 2 y especificamos
			// la posición en la que va cada uno
			ps.setString(1, nombre);
			ps.setInt(2, 18);

			ResultSet registros = ps.executeQuery();

			while (registros.next()) {
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
