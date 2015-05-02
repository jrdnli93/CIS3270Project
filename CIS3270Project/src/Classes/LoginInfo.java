package Classes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import projectCIS3270.CustomerHome;
import projectCIS3270.MainMenu;
import projectCIS3270.PasswordRetreival;
import projectCIS3270.RegistrationInfo;

public class LoginInfo extends JFrame{
	public LoginInfo(){
		
		JTextField userText = new JTextField();
		JTextField passText = new JTextField();
		JLabel username = new JLabel("Username");
		JLabel password = new JLabel("Password");
		JLabel fPassword = new JLabel("Forgot Password?");
		JLabel nMember = new JLabel("Not a member?");
		JButton mainMenu = new JButton("Main Menu");
		JButton bOK = new JButton("OK");
		JButton register = new JButton("Register");	
		JButton pRetrieval = new JButton("Password Retrieval");
		
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
				CustomerHome cHome = new CustomerHome();
				cHome.setSize(500, 500);
				cHome.setLocationRelativeTo(null);
				cHome.setVisible(true);
				dispose();
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