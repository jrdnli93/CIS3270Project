package Classes;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PasswordRetreival3 extends JFrame{
	public PasswordRetreival3(){
	
	//display password
	JLabel passwordText = new JLabel("Your password is: PASSWORD HERE");
	//display password
	
	JButton mMenu = new JButton("Main Menu");
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	p1.setLayout(new GridLayout(1, 1));
	p1.add(passwordText);
	p2.add(mMenu);
	
	add(p1, BorderLayout.NORTH);
	add(p2, BorderLayout.SOUTH);

	//this is the popup for clicking OK, Currently it is for a successful 
	
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
		PasswordRetreival3 frame = new PasswordRetreival3();
		frame.setTitle("Password Retreival");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
	}