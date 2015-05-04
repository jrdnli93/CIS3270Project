package Classes;
//This is the screen for the Admin to choose to Add or Edit/Delete flight
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import org.ietf.jgss.MessageProp;

public class AdminEditDB extends JFrame{
	public AdminEditDB(final Users u){

		
		
		JButton aHome = new JButton("Home Menu");
		JButton delete = new JButton("Delete");
		JButton edit = new JButton("Edit");
		
		JPanel p1 = new JPanel();
		p1.add(new JLabel("Flight Schedule: Choose Whether To Edit Or Delete"));
		add(p1, BorderLayout.NORTH);
		
		
		JPanel p3 = new JPanel();
		
		
		SQLStatements s = new SQLStatements();
		
		
		add(p3, BorderLayout.CENTER);
		try {
			ArrayList<String> results = s.select("select * from flights");
			Object[] r = results.toArray();
			JCheckBox[] jcb = new JCheckBox[30];
			for (int i = 0; i < r.length; i++) {
				System.out.println(results.get(i));
				
				p3.add(jcb[0] = new JCheckBox(s.select("select flightnumber from flights where flightnumber = " + results.get(i)) + " " +
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
				
				
				/*s.select("select flightnumber from flights where flightnumber = " + results.get(i)) + " " +
				s.select("select departcity from flights where flightnumber = " + results.get(i)) + " " +
				s.select("select departstate from flights where flightnumber = " + results.get(i)) + " " +
				s.select("select arrivalcity from flights where flightnumber = " + results.get(i)) + " " +
				s.select("select city from flights where flightnumber = '" + results.get(i)) + " " +
				s.select("select departtime from flights where flightnumber = " + results.get(i)) + " " +
				s.select("select arrivetime from flights where flightnumber = " + results.get(i)) + " " +
				s.select("select seatsavailable from flights where flightnumber = " + results.get(i)) + " " +
				s.select("select totalseats from flights where flightnumber = " + results.get(i))
				*/
				
			}
		} catch (ClassNotFoundException | SQLException e1) {
			System.out.println("SQL ERROR");
		} catch (Exception e) {
			System.out.println("ARRAYLIST ERROR");
		}
		JPanel p2 = new JPanel();
		p2.add(aHome);
		p2.add(delete);
		p2.add(edit);
		add(p2, BorderLayout.SOUTH);
		
		
		//delete needs to have action to delet flight selected
		aHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AdminHome frame = new AdminHome(u);
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
//1. if-else needed - if flights are actually deleted this action will occur		
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AdminDelConfirm frame = new AdminDelConfirm();
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

/*2. This is the second option - a window will pop up to let Admin Know nothing was deleted
 * 				AdminDelError frame = new AdminDelError();
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
 */
			}
		});

//1. if-else needed - if flights is chosen to edit this action will occur				
		edit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AdminEditFlight frame = new AdminEditFlight();
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();

/*2. This is the second option - a window will pop up to let Admin Know nothing
 * was chosen to edit
 * 			AdminDelError frame = new AdminDelError();
			frame.setSize(500, 500);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
*/
			}
		});

	}	
	public static void main(String[] args){
		Users u = new Customers();
		AdminEditDB frame = new AdminEditDB(u);
		frame.setTitle("Edit Options");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
