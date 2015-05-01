package Classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Test {


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		SQLStatements s = new SQLStatements();

		String statement = JOptionPane.showInputDialog("Enter SQL Statement:");
		
		ArrayList<String> results = null;
		
		ResultSet resultSet = null;
		
		int result = 0;
		try {
			//Tests if SQL statements work
			results = s.select(statement);
			System.out.println(results.get(0));
			//Tests if username check works
			Checks c = new Checks();
			System.out.println(c.usernameAvailable("exampleacct123"));
			//Tests if ssn check works
			System.out.println(c.checkSSN("555555555"));
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Not valid");
		}
		
	}
}

