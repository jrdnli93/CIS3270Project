package Classes;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CustomerHome extends JFrame{
	public CustomerHome(final Users u){
		JButton searchFlight = new JButton("Search flight System");
		JButton editFlight = new JButton("View/Delete Registered Flights");
		JButton editPersonal = new JButton("Edit Personal Information");
		JButton mMenu =new JButton("Logout");
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.add(searchFlight);
		p1.add(editFlight);
		p2.add(editPersonal);
		p2.add(mMenu);
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		
		searchFlight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SearchFlight frame = new SearchFlight();
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});

		editFlight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ViewDelete frame = new ViewDelete();
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});

		
		editPersonal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				EditPersonal frame = new EditPersonal(u);
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
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
		CustomerHome frame = new CustomerHome(u);
		frame.setTitle("Customer Page");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
