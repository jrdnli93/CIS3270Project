package Classes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PasswordRetreival extends JFrame{
	public PasswordRetreival(){
		//First password retrieval menu (Username/Social Security Number
		JLabel userName = new JLabel("Username");
		JLabel ssNum = new JLabel("Social Security Number");
		
		JTextField uName = new JTextField();
		JTextField ssn = new JTextField();
		
		JButton bOK = new JButton("OK");
		JButton mMenu = new JButton("Main Menu");
		
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
				PasswordRetreival2 login = new PasswordRetreival2();
				login.setSize(500, 500);
				login.setLocationRelativeTo(null);
				login.setVisible(true);
				dispose();
				
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