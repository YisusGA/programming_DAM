package es.damdaw1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.damdaw1.modelo.Mascota;
import es.damdaw1.modelo.Persona;

public class PersonaDAO {

	// Podemos aprovechar que el método executeUpdate devuelve el número de filas
	// afectadas de la tabla para devolver ese int
	public static int insertPersona(Persona persona) {
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
//				sentencia.executeUpdate("INSERT INTO personas(nombre,edad) " + "VALUES ('" + persona.getNombre() + "',"
//						+ persona.getEdad() + ")");
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

	public Persona getPersona(Integer id) {

		Persona persona = null;

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebadam1", "root", "1234");
				Statement sentencia = con.createStatement()) {

			ResultSet registros = sentencia.executeQuery("SELECT * FROM personas WHERE id = " + id);

			while (registros.next()) {

				String nombre = registros.getString("nombre");
				Integer edad = registros.getInt("edad");
				persona = new Persona(id, edad, nombre);
				PreparedStatement ps = con.prepareStatement("SELECT * FROM mascotas WHERE propietario_id = ?");
				ps.setInt(1, id);
				List<Mascota> mascotas = new ArrayList<>();
				ResultSet masc = ps.executeQuery();
				while (masc.next()) {
					Mascota m = new Mascota(masc.getInt(id), masc.getString("nombre"), masc.getDate("prox_vacuna"));
					mascotas.add(m);
					m.setPropietario(persona);

				}
				persona.setMascotas(mascotas);

			}

		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

		return persona;
	}

	public List<Persona> getPersonas() {

		return null;
	}

}
