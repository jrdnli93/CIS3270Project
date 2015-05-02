package Classes;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import projectCIS3270.ConfirmReg;
import Classes.MainMenu.RegListener;

public class RegistrationInfo extends JFrame{
	public RegistrationInfo(){

		JLabel fName = new JLabel("First Name");
		JLabel lName = new JLabel("Last Name");
		JLabel address = new JLabel("Address");
		JLabel zip = new JLabel("Zip Code");
		JLabel state = new JLabel("State");
		JLabel username = new JLabel("Username");
		JLabel password = new JLabel("Password");
		JLabel email = new JLabel("Email");
		JLabel ssn = new JLabel("Social Security Number");
		JLabel secQuestion = new JLabel("Security Question");
		JLabel secAnswer = new JLabel("Security Answer");
		JLabel adminCode = new JLabel("adminCode");
		JButton mainMenu = new JButton("Main Menu");
		JButton bOK = new JButton("OK");
		
		
		
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(12, 2));
		p1.add(fName);
		p1.add(new JTextField(10));
		p1.add(lName);
		p1.add(new JTextField(10));
		p1.add(address);
		p1.add(new JTextField(10));
		p1.add(zip);
		p1.add(new JTextField(10));
		p1.add(state);
		p1.add(new JTextField(10));
		p1.add(username);
		p1.add(new JTextField(10));
		p1.add(password);
		p1.add(new JTextField(10));
		p1.add(email);
		p1.add(new JTextField(10));
		p1.add(ssn);
		p1.add(new JTextField(10));
		p1.add(secQuestion);
		p1.add(new JTextField(10));
		p1.add(secAnswer);
		p1.add(new JTextField(10));
		p1.add(adminCode);
		p1.add(new JTextField(10));
		add(p1, BorderLayout.NORTH);
		
		JPanel p2 = new JPanel();
		p2.add(mainMenu);
		p2.add(bOK);
		add(p2, BorderLayout.SOUTH);
		RegListener listener1 = new RegListener();
		mainMenu.addActionListener(listener1);
		
		bOK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ConfirmReg cReg = new ConfirmReg();
				cReg.setSize(500, 500);
				cReg.setLocationRelativeTo(null);
				cReg.setVisible(true);
				//addded content should be added herre			}
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


