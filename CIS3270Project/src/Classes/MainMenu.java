package Classes;
import java.awt.*;
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
	}
	
	public static void main(String[] args){
		MainMenu frame = new MainMenu();
		frame.setTitle("Main Menu");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
