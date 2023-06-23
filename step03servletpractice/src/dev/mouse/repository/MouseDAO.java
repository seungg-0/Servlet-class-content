package dev.mouse.repository;

import java.io.BufferedReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import dev.mouse.domain.Mouse;
import dev.mouse.util.DBUtil;

public class MouseDAO {
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	public List<Mouse> findAll() throws ClassNotFoundException{
		final String selectQuery = "SELECT * FROM Mouse";
		List<Mouse> mice = new ArrayList<>();
		
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectQuery);

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String country = resultSet.getString("country");
				String address = resultSet.getString("address");
				
				mice.add(new Mouse(id, name, country, address));
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mice;
	}
	

	public void add(Mouse newMouse) throws ClassNotFoundException {
		int id = newMouse.getId();
		String name = newMouse.getName();
		String country = newMouse.getCountry();
		String address = newMouse.getAddress();
		
		try(Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO Mouse (id, name, country, address) VALUES(?, ?, ?, ?)")){
				statement.setInt(1,  id);
				statement.setString(2,  name);
				statement.setString(3,  country);
				statement.setString(4,  address);
				statement.executeUpdate();		
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

