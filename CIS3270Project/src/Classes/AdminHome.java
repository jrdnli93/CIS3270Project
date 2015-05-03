package Classes;
//This is the Admins main page layout
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminHome extends JFrame{
	public AdminHome(){
		/* All options EXCEPT FOR EDIT DB AND LOGOFF will go to options that are current
		 * redirect to customer home page, need to find out how to maintain
		 * admin status
		 */
		JButton searchFlight = new JButton("Search flight System");
		JButton editFlight = new JButton("View/Delete Registered Flights");
		JButton addFlightDB = new JButton("Add Flight To Database");
		JButton editFlightDB = new JButton("Edit/Delete Flight From Database");
		JButton editPersonal = new JButton("Edit Personal Information");
		JButton mMenu =new JButton("Logout");
		
		
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.add(searchFlight);
		p1.add(editFlight);
		p1.add(addFlightDB);
		p1.add(editFlightDB);
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
				EditPersonal frame = new EditPersonal();
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
		
		//Goes to Main Menu - NEEDS TO EXIT OUT OF ADMIN ARRAY
		mMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MainMenu frame = new MainMenu();
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
		
		addFlightDB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AdminAddFlight frame = new AdminAddFlight();
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
		
		editFlightDB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AdminEditDB frame = new AdminEditDB();
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
		
	}

	public static void main(String[] args){
		AdminHome frame = new AdminHome();
		frame.setTitle("Customer Page");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
