package Classes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
					
					if (CheckLogin.checkLogin(userText.getText(), passText.getText())) {
					
					CustomerHome cHome = new CustomerHome();
					cHome.setSize(500, 500);
					cHome.setLocationRelativeTo(null);
					cHome.setVisible(true);
					dispose();
					}
					else {
						RegistrationError rError = new RegistrationError();
						rError.setSize(500, 500);
						rError.setLocationRelativeTo(null);
						rError.setVisible(true);
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