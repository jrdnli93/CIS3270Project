package Classes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewDelete extends JFrame {
	public ViewDelete(final Users u){
		JButton delFlight = new JButton("Delete Flight");
		JButton cHome = new JButton("Home Page");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.add(new JLabel("These are your flights"));
		p2.add(delFlight);
		p2.add(cHome);
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.SOUTH);
		
		JPanel p3 = new JPanel();
		
		
		final SQLStatements s = new SQLStatements();
		
		final JCheckBox[] jcb = new JCheckBox[30];
		
		final String[] flightnumber = new String[jcb.length];
		
		add(p3, BorderLayout.CENTER);
		
		
		
		try {
			
			ArrayList<String> results = s.select("select flightnumber from customerflights where username = '" + u.getUsername() + "'");	
			Object[] r = results.toArray();
			
			
			for (int i = 0; i < r.length; i++) {
				
				flightnumber[i] = results.get(i).toString();
				p3.add(jcb[i] = new JCheckBox(s.select("select flightnumber from flights where flightnumber = " + results.get(i)) + " " +
						s.select("select departcity from flights where flightnumber = " + results.get(i)) + " " +
						s.select("select departstate from flights where flightnumber = " + results.get(i)) + " " +
						s.select("select arrivalcity from flights where flightnumber = " + results.get(i)) + " " + 
						s.select("select arrivalstate from flights where flightnumber = " + results.get(i)) + " " + 
						s.select("select departtime from flights where flightnumber = " + results.get(i)) + " " +
						s.select("select arrivaltime from flights where flightnumber = " + results.get(i)) + " " +
						s.select("select seatsavailable from flights where flightnumber = " + results.get(i)) + " " +
						s.select("select totalseats from flights where flightnumber = " + results.get(i))
						
						)
						
					);
			}
		} catch (Exception e) {
			System.out.println("error");
		}
		
		
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
		
		//Add action to delete content here
		delFlight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				for (int i = 0; i < flightnumber.length; i++)
					try {
						s.update("delete from customerflights where username = '" + u.getUsername() + "' and flightnumber = " + flightnumber[i]);
					} catch (ClassNotFoundException | SQLException e1) {
						System.out.println("1");
					} catch (Exception e2) {
						
					}
					
				
				ViewDeleteConfirm frame = new ViewDeleteConfirm();
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
			}
		});
		
}

public static void main(String[] args){
	Users u = new Customers();
	ViewDelete frame = new ViewDelete(u);
	frame.setTitle("Current Flights");
	frame.setSize(500, 500);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}
}