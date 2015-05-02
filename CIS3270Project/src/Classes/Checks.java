package Classes;

import java.sql.SQLException;
import java.util.ArrayList;

public class Checks {

	//Returns false if username is not 8-16. Returns true if within 8-16
	public boolean usernameLength (String username) {
		if (username.length() < 8 || username.length() > 16 ) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
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
		
		if (ssn.length() != 9) {
			return false;
		}
		
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
	
	//checks if has @domain.com
	public boolean emailFormat (String email) {
		
		String[] s = email.split("[@]");
		
		if (s.length > 2) {
			return false;
		}
		
		
		
	}
	
	//checks if email is available
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
	//Returns false if zipcode is not 5 digits
	public boolean checkZipcode (String zipcode) {
		if (zipcode.length() != 5) {
			return false;
		}
		else {
			return true;
		}
	}
	
}
