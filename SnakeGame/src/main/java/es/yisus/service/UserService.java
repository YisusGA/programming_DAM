package es.yisus.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.yisus.dao.UserDAO;
import es.yisus.dbcontext.DBContext;
import es.yisus.modelo.User;

public class UserService {
	
	/**
	 * 
	 * @param nickname the username
	 * @return the user with provided nickname, or null if it wasn't  found
	 * @throws SQLException
	 */
	public static User getUserByNickname(String nickname) throws SQLException {
		User retrievedUser = null;
		try (Connection con = DBContext.getConnection();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE nickname = ?")) {
			ps.setString(1, nickname);
			try (ResultSet registros = ps.executeQuery()) {
				// Cómo mucho va a devolver 1 porque el id es único, no hace falta un bucle
				// while
				if (registros.next()) {
					retrievedUser = new User(registros.getInt("id"), registros.getString("nickname"));
				}
			}
		}
		return retrievedUser;
	}
	
	public static User getOrCreateUser(String nickname) throws SQLException {
	    // Primero buscamos si el usuario ya existe en la BD
	    try (Connection con = DBContext.getConnection();
	         PreparedStatement ps = con.prepareStatement("SELECT id FROM users WHERE nickname = ?")) {
	        ps.setString(1, nickname);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                // Si existe, lo recuperamos con el ID que ya tenía
	                return new User(rs.getInt("id"), nickname);
	            }
	        }
	    }

	    // Si no existe, lo insertamos de cero
	    User newUser = new User(nickname);
	    UserDAO.insertUser(newUser); // Tu método actual que le asigna el ID autogenerado
	    return newUser;
	}


}
