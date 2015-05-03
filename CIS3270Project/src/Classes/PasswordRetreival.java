package Classes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class PasswordRetreival extends JFrame{
	public PasswordRetreival(){
		//First password retrieval menu (Username/Social Security Number
		final JLabel userName = new JLabel("Username");
		final JLabel ssNum = new JLabel("Social Security Number");
		
		final JTextField uName = new JTextField();
		final JTextField ssn = new JTextField();
		
		final JButton bOK = new JButton("OK");
		final JButton mMenu = new JButton("Main Menu");
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.setLayout(new GridLayout(2, 2));
		p1.add(userName);
		p1.add(uName);
		p1.add(ssNum);
		p1.add(ssn);
		p2.add(bOK);
		p2.add(mMenu);

		
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.SOUTH);
		
		bOK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Checks c = new Checks();
				SQLStatements s = new SQLStatements();
				//checks username and social security number
				//if username and social security number are true
				if (c.passwordRetrieval(uName.getText(), ssn.getText())) {
					//add isAdmin method
					Users user;
					if (c.isAdmin(uName.getText())) {
						user =  new Admins();
						((Admins)user).setUsername(uName.getText());
						((Admins)user).setSSN(ssn.getText());
					}
					else {
						user = new Customers();
						((Customers)user).setUsername(uName.getText());
						((Customers)user).setSSN(ssn.getText());
						try {
							((Customers)user).setSecurityQuestion(s.select("select securityquestion from user where username = '" + uName.getText() + "'").get(0));
							((Customers)user).setSecurityAnswer(s.select("select securityanswer from user where username = '" + uName.getText() + "'").get(0));
							((Customers)user).setPassword(s.select("select password from user where username = '" + uName.getText() + "'").get(0));
						} catch (ClassNotFoundException | SQLException e1) {
							System.out.println("error");
						}
					}
					PasswordRetreival2 login = new PasswordRetreival2(user);
					login.setSize(500, 500);
					login.setLocationRelativeTo(null);
					login.setVisible(true);
					dispose();
				}
				else {
					PasswordRetreival4 login = new PasswordRetreival4();
					login.setSize(500, 500);
					login.setLocationRelativeTo(null);
					login.setVisible(true);
					
				}
				
				
				/*
				THIS WOULD BE THE CODE FOR THE ERROR WHEN THE INPUT
				ISNT RIGHT
				PasswordRetreival2 login = new PasswordRetreival2();
				login.setSize(500, 500);
				login.setLocationRelativeTo(null);
				login.setVisible(true);
				
				*/
		
			}
		});

		mMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MainMenu frame = new MainMenu();
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
	}
		
		public static void main(String[] args){
			PasswordRetreival frame1 = new PasswordRetreival();
			frame1.setTitle("Password Retreival");
			frame1.setSize(500, 500);
			frame1.setLocationRelativeTo(null);
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1.setVisible(true);
	}
}