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

public class SearchAdd extends JFrame{
	public SearchAdd(final Users u){
		JButton searchAgain = new JButton("Search Again");
		JButton cHome = new JButton("Customer Home");
		JPanel p1 = new JPanel();
		p1.add(new JLabel("The Flight Was Added To Your Account"));
		add(p1, BorderLayout.NORTH);
		
		JPanel p2 = new JPanel();
		p2.add(searchAgain);
		p2.add(cHome);
		add(p2, BorderLayout.SOUTH);
		
		searchAgain.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SearchFlight sResult = new SearchFlight(u);
				sResult.setSize(500, 500);
				sResult.setLocationRelativeTo(null);
				sResult.setVisible(true);
				dispose();
			}
		});
		
		cHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Checks c = new Checks();
				if (c.isAdmin(u.getUsername())) {
					AdminHome sResult = new AdminHome(u);
					sResult.setSize(500, 500);
					sResult.setLocationRelativeTo(null);
					sResult.setVisible(true);
					dispose();

				}
				else {
					CustomerHome sResult = new CustomerHome(u);
					sResult.setSize(500, 500);
					sResult.setLocationRelativeTo(null);
					sResult.setVisible(true);
					dispose();

				}
				
			}
		});
	}
	public static void main(String[] args){
		Users u = new Customers();
		SearchAdd frame = new SearchAdd(u);
		frame.setTitle("Password Retreival");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
