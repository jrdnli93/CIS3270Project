package Classes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class LoginInfo extends JFrame{
	public LoginInfo(){
		
		final JTextField userText = new JTextField();
		final JTextField passText = new JTextField();
		final JLabel username = new JLabel("Username");
		final JLabel password = new JLabel("Password");
		final JLabel fPassword = new JLabel("Forgot Password?");
		final JLabel nMember = new JLabel("Not a member?");
		final JButton mainMenu = new JButton("Main Menu");
		final JButton bOK = new JButton("OK");
		final JButton register = new JButton("Register");	
		final JButton pRetrieval = new JButton("Password Retrieval");
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		p1.setLayout(new GridLayout(2, 2));
		p1.add(username);
		p1.add(userText);
		p1.add(password);
		p1.add(passText);
		p2.add(mainMenu);
		p2.add(bOK);
		p3.add(nMember);
		p3.add(register);
		p3.add(fPassword);
		p3.add(pRetrieval);
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);
		
		mainMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MainMenu mMenu = new MainMenu();
				mMenu.setSize(500, 500);
				mMenu.setLocationRelativeTo(null);
				mMenu.setVisible(true);
				dispose();
			}
		});
		register.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				RegistrationInfo reg = new RegistrationInfo();
				reg.setSize(500, 500);
				reg.setLocationRelativeTo(null);
				reg.setVisible(true);
				dispose();
			}
		});
		pRetrieval.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				PasswordRetreival pRet = new PasswordRetreival();
				pRet.setSize(500, 500);
				pRet.setLocationRelativeTo(null);
				pRet.setVisible(true);
				dispose();
			}
		});
		bOK.addActionListener(new ActionListener(){
				
			
			
				public void actionPerformed(ActionEvent e){
					SQLStatements s = new SQLStatements();
					
					if (CheckLogin.checkLogin(userText.getText(), passText.getText())) {
						//Access database to get relevant information so you don't have to use SQL anymore
						Users u = new Customers();
						((Customers)u).setUsername(userText.getText());
						((Customers)u).setPassword(passText.getText());
						try {
							((Customers)u).setFirstName((s.select("select firstname from user where username = '" + userText.getText() + "'").get(0)));
							((Customers)u).setMiddleInitial((s.select("select middleinitial from user where username = '" + userText.getText() + "'").get(0)));
							((Customers)u).setLastName((s.select("select lastname from user where username = '" + userText.getText() + "'").get(0)));
							((Customers)u).setAddress((s.select("select address from user where username = '" + userText.getText() + "'").get(0)));
							((Customers)u).setCity((s.select("select city from user where username = '" + userText.getText() + "'").get(0)));
							((Customers)u).setState((s.select("select state from user where username = '" + userText.getText() + "'").get(0)));
							((Customers)u).setZipCode((s.select("select zipcode from user where username = '" + userText.getText() + "'").get(0)));
							((Customers)u).seteMail((s.select("select email from user where username = '" + userText.getText() + "'").get(0)));
							((Customers)u).setSSN((s.select("select ssn from user where username = '" + userText.getText() + "'").get(0)));
							((Customers)u).setSecurityQuestion((s.select("select securityquestion from user where username = '" + userText.getText() + "'").get(0)));
							((Customers)u).setSecurityAnswer((s.select("select securityanswer from user where username = '" + userText.getText() + "'").get(0)));
							
							if (s.select("select admin from user where username = '" + userText.getText() + "'").get(0).equals("1")) {
								((Customers)u).setAdmin(true);
							}
							else {
								((Customers)u).setAdmin(false);
							}
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
							
						
						
						
					
							CustomerHome cHome = new CustomerHome(u);
							cHome.setSize(500, 500);
							cHome.setLocationRelativeTo(null);
							cHome.setVisible(true);
							dispose();
					}
						
					
					else {
						LoginError lError = new LoginError();
						lError.setSize(500, 500);
						lError.setLocationRelativeTo(null);
						lError.setVisible(true);
						dispose();
					}
				
				}
			
		});
		
		
	}
	
	public static void main(String[] args){
		LoginInfo frame = new LoginInfo();
		frame.setTitle("Login Info");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}