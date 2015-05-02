package Classes;

import java.awt.*;

import javax.swing.*;

public class LoginInfo extends JFrame{
	public LoginInfo(){
		
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
		p1.add(username);
		p1.add(new JTextField(10));
		p1.add(password);
		p1.add(new JTextField(10));
		p2.add(mainMenu);
		p2.add(bOK);
		p3.add(nMember);
		p3.add(register);
		p3.add(fPassword);
		p3.add(pRetrieval);
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);
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