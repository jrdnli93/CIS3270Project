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

public class SearchResults extends JFrame {
	public SearchResults(String depart, String arrive, final Users u){
		JButton addFlight = new JButton("Add Flight");
		JButton	searchAgain = new JButton("Search Again");
		JButton cHome = new JButton("Return to Home Page");
		
		final String[] departCityState = depart.split("[,]");
		final String[] arrivalCityState = arrive.split("[,]");
		
		JPanel p1 = new JPanel();
		final JPanel p2 = new JPanel();
		final JPanel p3 = new JPanel();
		p1.add(new JLabel("The following flights are available"));
		//need to display flight information requested
		//also need to enter method of adding flight to users account
		//display text "no results" if no flights are available
		p2.add(addFlight);
		p2.add(searchAgain);
		p2.add(cHome);
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.SOUTH);
		add(p3, BorderLayout.CENTER);
		
		final SQLStatements s = new SQLStatements();
		
		final JCheckBox[] jcb = new JCheckBox[30];
		
		final String[] flightnumber = new String[jcb.length];
		
		try {
			
			ArrayList<String> results = s.select("select * from flights");
			Object[] r = results.toArray();
			
			
			for (int i = 0; i < r.length; i++) {
				
				flightnumber[i] = results.get(i).toString();
				System.out.println(flightnumber[i]);
				p3.add(jcb[i] = new JCheckBox(s.select("select flightnumber from flights where departcity = '" + departCityState[0] + "' and arrivalcity = '" + arrivalCityState[0] + "'") + " " +
						s.select("select departcity from flights where departcity = '" + departCityState[0] + "' and arrivalcity = '" + arrivalCityState[0] + "'") + " " +
						s.select("select departstate from flights where departcity = '" + departCityState[0] + "' and arrivalcity = '" + arrivalCityState[0] + "'") + " " +
						s.select("select arrivalcity from flights where departcity = '" + departCityState[0] + "' and arrivalcity = '" + arrivalCityState[0] + "'") + " " + 
						s.select("select arrivalstate from flights where departcity = '" + departCityState[0] + "' and arrivalcity = '" + arrivalCityState[0] + "'") + " " + 
						s.select("select departtime from flights where departcity = '" + departCityState[0] + "' and arrivalcity = '" + arrivalCityState[0] + "'") + " " +
						s.select("select arrivaltime from flights where departcity = '" + departCityState[0] + "' and arrivalcity = '" + arrivalCityState[0] + "'") + " " +
						s.select("select seatsavailable from flights where departcity = '" + departCityState[0] + "' and arrivalcity = '" + arrivalCityState[0] + "'") + " " +
						s.select("select totalseats from flights where departcity = '" + departCityState[0] + "' and arrivalcity = '" + arrivalCityState[0] + "'") + " " +
						s.select("select price from flights where departcity = '" + departCityState[0] + "' and arrivalcity = '" + arrivalCityState[0] + "'")
						
						)
		
				);
			}
		} catch (Exception e) {
			
		}

//1.NEEDS TO HAVE TWO OPTIONS THIS IS ONE, WHEN FLIGHTS ARE ADDED
		addFlight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				for (int i = 0; i < jcb.length; i++) {
					
					
						
							try {
								if(jcb[i].isSelected()) {
								s.update("insert into customerflights (flightnumber, username) values (" + flightnumber[i] + " ,'" + u.getUsername() + "')");
								
								
									
								AdminAddConfirm frame = new AdminAddConfirm(u);
								frame.setSize(500, 500);
								frame.setLocationRelativeTo(null);
								frame.setVisible(true);
								dispose();
								
								}
							} catch (ClassNotFoundException | SQLException e1) {
								
								
							} catch (Exception e2) {
								
							}
							
							
					}
				}
						
						
					
		});

			
				
				
			
		
			
	

		
/*2.THIS IS THE SECOND CHOICE
 * THIS CODE WILL SHOW A WINDOW TO INDICATE NOTHING WAS ADDED
 * 		addFlight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SearchFlightEmpty sAdd = new SearchFlightEmpty();
				sAdd.setSize(500, 500);
				sAdd.setLocationRelativeTo(null);
				sAdd.setVisible(true);
			}
		});
 * 
 */
		
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
				if (((Customers)u).isAdmin()) {

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
	SearchResults frame = new SearchResults("","",u);
	frame.setTitle("Search Results");
	frame.setSize(600, 600);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}
}