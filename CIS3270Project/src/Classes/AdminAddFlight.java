package Classes;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
//Admins options to add new flight to database
public class AdminAddFlight extends JFrame{
	public AdminAddFlight(final Users u){
		final JComboBox depart = new JComboBox(new String[]{"Los Angeles,CA", "Atlanta,GA", "Honolulu,HI", "New York,NY", "Austin,TX"});
		final JComboBox arrive = new JComboBox(new String[]{"Los Angeles,CA", "Atlanta,GA", "Honolulu,HI", "New York,NY", "Austin,TX"});
		final JTextField seats = new JTextField(3);
		final JTextField price = new JTextField(4);
		
		final JComboBox month = new JComboBox(new String[]{"Jan", "Feb", "March", "April", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"});
		final JComboBox daySD = new JComboBox(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"});
		final JComboBox dayDD = new JComboBox(new String[]{"0", "1", "2", "3"});
		final JComboBox year = new JComboBox(new String[]{"2015", "2016", "2017", "2018", "2019", "2020"});
		final JComboBox hourD = new JComboBox(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"});
		final JComboBox minuteD = new JComboBox(new String[]{"30", "00"});
		final JComboBox amPMD = new JComboBox(new String[]{"am", "pm"});
		final JComboBox TZD = new JComboBox(new String[]{"Eastern", "Central", "Pacific", "Hawaii"});
		final JComboBox hourA = new JComboBox(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"});
		final JComboBox minuteA = new JComboBox(new String[]{"30", "00"});
		final JComboBox amPMA = new JComboBox(new String[]{"am", "pm"});
		final JComboBox TZA = new JComboBox(new String[]{"Eastern", "Central", "Pacific", "Hawaii"});
		
		JButton aHome = new JButton("Home Menu");
		JButton addFlight = new JButton("Add Flight");
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4, 2));
		p1.add(new JLabel("State of Departure"));
		p1.add(depart);
		p1.add(new JLabel("State of Destination"));
		p1.add(arrive);
		p1.add(new JLabel("Total seats available"));
		p1.add(seats);
		p1.add(new JLabel("Price per seat"));
		p1.add(price);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(3, 4));
		p2.add(new JLabel("Departure Time"));
		p2.add(hourD);
		p2.add(minuteD);
		p2.add(amPMD);
		p2.add(TZD);
		p2.add(new JLabel("Arrival Time"));
		p2.add(hourA);
		p2.add(minuteA);
		p2.add(amPMA);
		p2.add(TZA);
		p2.add(new JLabel("Date of Flight"));
		p2.add(month);
		p2.add(dayDD);
		p2.add(daySD);
		p2.add(year);
		
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		
		JPanel p3 = new JPanel();
		p3.add(aHome);
		p3.add(addFlight);
		add(p3, BorderLayout.SOUTH);
		
		aHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AdminHome frame = new AdminHome(u);
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
		
		//current execution is to add flight, need to add edit/delete flight info
		addFlight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SQLStatements s = new SQLStatements();
				String[] departCityState = depart.getSelectedItem().toString().split("[,]");
				String[] arrivalCityState = arrive.getSelectedItem().toString().split("[,]");
				String departTime = hourD.getSelectedItem() + ":" + minuteD.getSelectedItem() + " " + amPMD.getSelectedItem() + " " + TZD.getSelectedItem();
				String arriveTime = hourA.getSelectedItem() + ":" + minuteA.getSelectedItem() + " " + amPMA.getSelectedItem() + " " + TZA.getSelectedItem();
				String date = month.getSelectedItem() + "/" + daySD.getSelectedItem() + dayDD.getSelectedItem() + "/" + year.getSelectedItem();
				
				
				if (depart.getSelectedItem().equals(arrive.getSelectedItem()) || (seats.getText().equals("") == true) || (price.getText().equals("") == true)) {
					AdminAddError frame = new AdminAddError();
					frame.setSize(500, 500);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}
				else {
					try {
						s.update("insert into flights (departcity, departstate, arrivalcity, arrivalstate, departtime, arrivaltime, flightdate, price, totalseats) values('" + departCityState[0] + "', '" + departCityState[1] + "', '" + arrivalCityState[0] + "', '" + arrivalCityState[1] + "', '" + departTime + "', '" + arriveTime + "', '" + date + "', '" + price.getText() + "', " + seats.getText() +")");
					} catch (ClassNotFoundException | SQLException e1) {
						
					}
					AdminAddConfirm frame = new AdminAddConfirm(u);
					frame.setSize(500, 500);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					dispose();
				}
				
				
			}
		});
	}
	
	public static void main(String[] args){
		Users u = new Customers();
		AdminAddFlight frame = new AdminAddFlight(u);
		frame.setTitle("Flight Addition");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
