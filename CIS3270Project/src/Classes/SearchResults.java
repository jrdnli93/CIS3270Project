package Classes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SearchResults extends JFrame {
	public SearchResults(){
		JButton addFlight = new JButton("Add Flight");
		JButton	searchAgain = new JButton("Search Again");
		JButton cHome = new JButton("Return to Home Page");
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.add(new JLabel("The following flights are available"));
		//need to display flight information requested
		//also need to enter method of adding flight to users account
		//display text "no results" if no flights are available
		p2.add(addFlight);
		p2.add(searchAgain);
		p2.add(cHome);
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.SOUTH);

//1.NEEDS TO HAVE TWO OPTIONS THIS IS ONE, WHEN FLIGHTS ARE ADDED
		addFlight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SearchAdd sAdd = new SearchAdd();
				sAdd.setSize(500, 500);
				sAdd.setLocationRelativeTo(null);
				sAdd.setVisible(true);
				dispose();
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
				SearchFlight sResult = new SearchFlight();
				sResult.setSize(500, 500);
				sResult.setLocationRelativeTo(null);
				sResult.setVisible(true);
				dispose();
			}
		});
		
		cHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CustomerHome sResult = new CustomerHome();
				sResult.setSize(500, 500);
				sResult.setLocationRelativeTo(null);
				sResult.setVisible(true);
				dispose();
			}
		});
		
}

public static void main(String[] args){
	SearchResults frame = new SearchResults();
	frame.setTitle("Search Results");
	frame.setSize(500, 500);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}
}