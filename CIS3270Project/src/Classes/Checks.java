package Classes;

import java.sql.SQLException;
import java.util.ArrayList;

public class Checks {

	//returns true if username is not taken
	public boolean usernameAvailable (String username) {
		
		SQLStatements s = new SQLStatements();
		
		try {
			ArrayList<String> result = new ArrayList<String>();
			result = s.select("select username from accountinfo where username ='" + username + "'");
			result.get(0);
			return false;
			
		} catch (ClassNotFoundException | SQLException e) {
			return true;
			
		} catch (Exception e) {
			return true;
		}
		
	}
	//Returns true if ssn available, returns false is snn is not 9 digits or is not available
	public boolean checkSSN (String ssn) {
		
		SQLStatements s = new SQLStatements();
		
		try {
			ArrayList<String> result = new ArrayList<String>();
			result = s.select("select ssn from user where ssn ='" + ssn + "'");
			result.get(0);
			return false;
			
		} catch (ClassNotFoundException | SQLException e) {
			return true;
			
		} catch (Exception e) {
			return true;
		}
	}
	public boolean checkEmail (String email) {
		SQLStatements s = new SQLStatements();
		
		try {
			ArrayList<String> result = new ArrayList<String>();
			result = s.select("select email from user where email ='" + email + "'");
			result.get(0);
			return false;
			
		} catch (ClassNotFoundException | SQLException e) {
			return true;
			
		} catch (Exception e) {
			return true;
		}
	}
	//Password 8-16, returns false if outside of range, returns true if inside range
	public boolean checkPassword(String password) {
		if (password.length() < 8 || password.length() > 16) {
			return false;
		}
		else {
			return true;
		}
	}
}
