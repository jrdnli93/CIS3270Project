package Classes;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CustomerHome extends JFrame{
	public CustomerHome(final Users u){
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.add(new JButton("Search flight system"));
		p1.add(new JButton("View/Delete Registered Flights"));
		p2.add(new JButton("Edit Personal Information"));
		p2.add(new JButton("Logout"));
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		
	}

	public static void main(String[] args){
		CustomerHome frame = new CustomerHome();
		frame.setTitle("Customer Page");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
