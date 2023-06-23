package dev.mouse.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
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
}
