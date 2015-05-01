package Classes;
import java.sql.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class RegistrationTest {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		
		String username = JOptionPane.showInputDialog("Enter username:");
		
		String password = JOptionPane.showInputDialog("Enter password:");
		
		String firstName = JOptionPane.showInputDialog("Enter First name:");
		
		String middleInitial = JOptionPane.showInputDialog("Enter Middle Initial:");
		
		String lastName = JOptionPane.showInputDialog("Enter last name:");
		
		String address = JOptionPane.showInputDialog("Enter Address:");
		
		String city = JOptionPane.showInputDialog("Enter City");
		
		String state = JOptionPane.showInputDialog("Enter State:");
		
		String zipcode = JOptionPane.showInputDialog("Enter zipcode:");
		
		String email = JOptionPane.showInputDialog("Enter email:");
		
		String SSN = JOptionPane.showInputDialog("Enter SSN:");
		
		String securityQuestion = JOptionPane.showInputDialog("Enter Security Question:");
		
		String securityAnswer = JOptionPane.showInputDialog("Enter Security Answer:");
		
		//add to action listener
		//checks username and SSN
		Checks c = new Checks();
		SQLStatements s = new SQLStatements();
		boolean usernameCheck, SSNcheck, emailCheck;
		
		if (usernameCheck = c.usernameAvailable(username)) {
			System.out.println("Username available");
		}
		else {
			System.out.println("Username already taken");
		}
		
		if (SSNcheck = c.checkSSN(SSN)) {
			System.out.println("SSN valid");
		}
		else {
			System.out.println("SSN not valid");
		}
		
		if (emailCheck = c.checkEmail(email)) {
			System.out.println("Email valid");
		}
		else {
			System.out.println("Email already taken");
		}
		
		if (emailCheck == true && SSNcheck == true && emailCheck == true) {
			try {
				//updates database after check
				s.update("insert into accountinfo (username, password) values ('" + username + "', '" + password + "')");
				s.update("insert into user (username, password, firstname, middleinitial, lastname, address, city, state, zipcode, email, ssn, securityquestion, securityanswer) values ('" + username + "', '" + password + "', '" + firstName + "', '" + middleInitial + "', '" + lastName + "', '" + address + "', '" + city + "', '" + state + "', '" + zipcode + "', '" + email + "', '" + SSN + "', '" + securityQuestion + "', '" + securityAnswer + "')");
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("error");
				
			}
		}
		else {
			
		}		
	
	}
}
