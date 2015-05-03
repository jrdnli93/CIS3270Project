package Classes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class MainMenu extends JFrame{
	public MainMenu(){

		JButton register = new JButton("Register");
		JButton login = new JButton("Login");
		JButton eProgram = new JButton("Exit Program");
		JPanel p1 = new JPanel();
		p1.add(register);
		p1.add(login);
		p1.add(eProgram);
		add(p1, BorderLayout.SOUTH);
		RegListener listener1 = new RegListener();
		register.addActionListener(listener1);
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				LoginInfo login = new LoginInfo();
				login.setSize(500, 500);
				login.setLocationRelativeTo(null);
				login.setVisible(true);
				dispose();
			}
		});
		eProgram.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args){
		MainMenu frame = new MainMenu();
		frame.setTitle("Main Menu");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	class RegListener implements ActionListener{ 
		@Override 
		public void actionPerformed(ActionEvent e) {
			RegistrationInfo confirm = new RegistrationInfo();
			confirm.setSize(500, 500); 
			confirm.setLocationRelativeTo(null);
			confirm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			confirm.setVisible(true);
			dispose();
		}
	}
}