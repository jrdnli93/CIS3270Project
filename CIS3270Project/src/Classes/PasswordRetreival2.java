package Classes;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PasswordRetreival2 extends JFrame{
	public PasswordRetreival2(final Users u){
	//Second password retreival page (Security Question)

		
		
	final JLabel sQuestion = new JLabel(((Customers)u).getSecurityQuestion());
	//answer to question goes here
	final JTextField answer = new JTextField();
	//answer to question goes here
	
	JButton bOK = new JButton("OK");
	JButton mMenu = new JButton("Main Menu");
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	p1.setLayout(new GridLayout(1, 1));
	p1.add(sQuestion);
	p1.add(answer);
	p2.add(bOK);
	p2.add(mMenu);
	
	add(p1, BorderLayout.NORTH);
	add(p2, BorderLayout.SOUTH);

	//this is the popup for clicking OK, Currently it is for a successful 
	
	bOK.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if (((Customers)u).getSecurityAnswer().equals(answer.getText())) {
				PasswordRetreival3 frame = new PasswordRetreival3(u);
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
			else {
				PasswordRetreival4 frame = new PasswordRetreival4();
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
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
	Users u = new Customers();
	
	PasswordRetreival2 frame = new PasswordRetreival2(u);
	frame.setTitle("Password Retreival");
	frame.setSize(500, 500);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}
}