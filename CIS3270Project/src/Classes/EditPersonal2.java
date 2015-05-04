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

public class EditPersonal2 extends JFrame{
	public EditPersonal2(final Users u){
		JButton cHome = new JButton("Home Page");
		JPanel p1 = new JPanel();
		p1.add(new JLabel("Your Changes Have Been Saved"));
		add(p1, BorderLayout.NORTH);
		
		JPanel p2 = new JPanel();
		p2.add(cHome);
		add(p2, BorderLayout.SOUTH);
		

//NEED TO BE ABLE TO RETURN TO CUSTOMER PAGE OR ADMIN PAGE
		cHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				
				if (((Customers)u).isAdmin()) {
					AdminHome frame = new AdminHome(u);
					frame.setSize(500, 500);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					dispose();
				}
				else {
					CustomerHome frame = new CustomerHome(u);
					frame.setSize(500, 500);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					dispose();
				}
				
				
//CURRENT STATUS IS CUSTOMER HOME, NEED TO ADD ADMIN ROUTE
			}
		});
	}
	public static void main(String[] args){
		Users u = new Customers();
		EditPersonal2 frame = new EditPersonal2(u);
		frame.setTitle("Password Retreival");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
