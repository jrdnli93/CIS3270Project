package Classes;

import java.sql.*;
import java.util.ArrayList;


public class SQLStatements {
	
	public ArrayList<String> select (String a) throws SQLException, ClassNotFoundException{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/3270project", "root", "annakAn95ta");
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(a);
		
		ArrayList<String> resultsArrayList = new ArrayList<String>();
		
		while (resultSet.next()) {
			int i = 1;
			resultsArrayList.add(resultSet.getString(i));
			i++;
			
		}
		
		connection.close();
		
		return resultsArrayList;
	}
	
	public void update(String a) throws SQLException, ClassNotFoundException{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/3270project", "root", "annakAn95ta");
		
		Statement statement = connection.createStatement();
		
		int result = statement.executeUpdate(a);
		
		connection.close();
		
		
		
	}

}
