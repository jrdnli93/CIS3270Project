package Classes;
import java.sql.*;

public class SimpleJdbc {

	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/3270project", "root", "annakAn95ta");
		System.out.println("Database connected");
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery("select username from customerflights where flightnumber = '00001'");
		
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1));
			
		}
		connection.close();
	}
}
