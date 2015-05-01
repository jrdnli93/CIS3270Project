package Classes;
import java.util.Scanner;
import java.sql.*;

public class LoginTest {

	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		
		String tempUserName = input.next();
		
		String tempPassword = input.next();
		
		CheckLogin c = new CheckLogin();
		
		//checks login 
		c.checkLogin(tempUserName, tempPassword);
	
	}	
}
