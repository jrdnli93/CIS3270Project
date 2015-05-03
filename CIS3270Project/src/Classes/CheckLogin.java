package Classes;

import java.sql.*;
import java.util.*;

public class CheckLogin {

	public static boolean checkLogin (String a, String b) {
		
		SQLStatements s = new SQLStatements();
		
		ArrayList<String> result = null;
		
		try {

			
			result = s.select("select password from accountinfo where username = '" + a + "'");
			
			if (b.equals(result.get(0))) {
				System.out.println("Login successful");
				return true;
			}
			System.out.println("Username/Password combination not found");
			return false;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Username/Password combination not found");
			return false;
			
		} catch (Exception e) {
			System.out.println("Username/Password combination not found");
			return false;
		}
		
	}
}
