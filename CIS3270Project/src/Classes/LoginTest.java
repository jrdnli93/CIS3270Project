package Classes;
import java.util.Scanner;
import java.sql.*;

public class LoginTest {

	public static void main (String[] args) throws SQLException, ClassNotFoundException{
		Scanner input = new Scanner(System.in);
		
		String tempUserName = input.next();
		
		String tempPassword = input.next();
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/3270project", "root", "annakAn95ta");
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery("select username from accountinfo where username = '" + tempUserName + "'");
		
		while (resultSet.next()) {
			if (resultSet.getString(1).equals(tempUserName)) {
				System.out.println("Valid Username");
				resultSet = statement.executeQuery("select password from accountinfo where username = '" + tempUserName + "'");
				while (resultSet.next()) {
					if (resultSet.getString(1).equals(tempPassword)) {
						System.out.println("Login successful");
					}
					else {
						System.out.println("Invalid password");
					}
				}	
			}
			//why don't you work??
			else {
				System.out.println("Invalid username");
			}
		}
		
		connection.close();
		
		
		
	}
}
