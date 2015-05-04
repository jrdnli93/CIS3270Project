package Classes;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import Classes.MainMenu.RegListener;

public class RegistrationInfo extends JFrame{
	public RegistrationInfo(){

		final JTextField fName = new JTextField();
		final JTextField mInitial = new JTextField();
		final JTextField lName = new JTextField();
		final JTextField address = new JTextField();
		final JTextField city =  new JTextField();
		final JTextField state = new JTextField();
		final JTextField zip = new JTextField();
		final JTextField username = new JTextField();
		final JTextField password = new JTextField();
		final JTextField email = new JTextField();
		final JTextField ssn = new JTextField();
		final JTextField secQuestion = new JTextField();
		final JTextField secAnswer = new JTextField();
		final JTextField adminCode = new JTextField();
		final JButton mainMenu = new JButton("Main Menu");
		final JButton bOK = new JButton("OK");
		
		
		
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(15, 2));
		p1.add(new JLabel("First Name"));
		p1.add(fName);
		p1.add(new JLabel("Middle Initial"));
		p1.add(mInitial);
		p1.add(new JLabel("Last name"));
		p1.add(lName);
		p1.add(new JLabel("Street Address"));
		p1.add(address);
		p1.add(new JLabel("City"));
		p1.add(city);
		p1.add(new JLabel("State"));
		p1.add(state);
		p1.add(new JLabel("Zip Code"));
		p1.add(zip);
		p1.add(new JLabel("Username"));
		p1.add(username);
		p1.add(new JLabel("Password"));
		p1.add(password);
		p1.add(new JLabel("Email"));
		p1.add(email);
		p1.add(new JLabel("Social Security Number"));
		p1.add(ssn);
		p1.add(new JLabel("Security Question"));
		p1.add(secQuestion);
		p1.add(new JLabel("Security Answer"));
		p1.add(secAnswer);
		p1.add(new JLabel("Admin Code(Optional)"));
		p1.add(adminCode);
		add(p1, BorderLayout.NORTH);
		
		JPanel p2 = new JPanel();
		p2.add(mainMenu);
		p2.add(bOK);
		add(p2, BorderLayout.SOUTH);
		RegListener listener1 = new RegListener();
		mainMenu.addActionListener(listener1);
		
		bOK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Checks c = new Checks();
				SQLStatements s = new SQLStatements();
				boolean usernameCheck, SSNcheck, emailCheck;
				
				int admin = 0;
				
				if (c.checkAdminCode(adminCode.getText())) {
					admin = 1;
				}
				
				//SHOW IN A JFrame
				if (usernameCheck = c.usernameAvailable(username.getText())) {
					
				}
				else {
					
				}
				
				if (SSNcheck = c.checkSSN(ssn.getText())) {
					
				}
				else {
					
				}
				
				if (emailCheck = c.checkEmail(email.getText())) {
					
				}
				else {
					
				}
				
				if (usernameCheck == true && SSNcheck == true && emailCheck == true) {
					try {
						
						//updates database after check
						s.update("insert into accountinfo (username, password) values ('" + username.getText() + "', '" + password.getText() + "')");
						//not working
						s.update("insert into user (username, password, firstname, middleinitial, lastname, address, city, state, zipcode, email, ssn, securityquestion, securityanswer, admin) values ('" + username.getText() + "', '" + password.getText() + "', '" + fName.getText() + "', '" + mInitial.getText() + "', '" + lName.getText() + "', '" + address.getText() + "', '" + city.getText() + "', '" + state.getText() + "', '" + zip.getText() + "', '" + email.getText() + "', '" + ssn.getText() + "', '" + secQuestion.getText() + "', '" + secAnswer.getText() + "', " + admin + ")");
						ConfirmReg cReg = new ConfirmReg();
						cReg.setSize(500, 500);
						cReg.setLocationRelativeTo(null);
						cReg.setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						
						
					}
				}
				else {
					RegistrationError rError = new RegistrationError();
					rError.setSize(500, 500);
					rError.setLocationRelativeTo(null);
					rError.setVisible(true);
				}
				
			
				
				
				
				//addded content should be added herre			

			}
		});
		
	}
	
	public static void main(String[] args){
		RegistrationInfo frame = new RegistrationInfo();
		frame.setTitle("Registration Info");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	class RegListener implements ActionListener{ 
		@Override 
		public void actionPerformed(ActionEvent e) {
			MainMenu confirm = new MainMenu();
			confirm.setTitle("Registration Info");
			confirm.setSize(500, 500);
			confirm.setLocationRelativeTo(null);
			confirm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			confirm.setVisible(true);
			
			
		}
	}

}



