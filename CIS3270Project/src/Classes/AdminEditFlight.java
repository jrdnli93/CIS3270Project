package Classes;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminEditFlight extends JFrame {
	public AdminEditFlight(final Users u, final String flightnumber){
		
		JButton bOK = new JButton("Edit Flight");
		JButton aHome = new JButton("Home Menu");
		
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
		p3.add(bOK);
		add(p3, BorderLayout.SOUTH);
		
		
		
		SQLStatements s = new SQLStatements();
		
		Flights f = new Flights();
		
		/*try {
			f.setFlightNumber(s.select("select flightnumber from flights where flightnumber = " + flightnumber).toString().replaceAll("[[]]", ""));
			f.setDepartCity(s.select("select departcity from flights where flightnumber = " + flightnumber).toString().replaceAll("[[]]", ""));
			f.setDepartState(s.select("select departstate from flights where flightnumber = " + flightnumber).toString().replaceAll("[[]]", ""));
			f.setArriveCity(s.select("select arrivalcity from flights where flightnumber = " + flightnumber).toString().replaceAll("[[]]", ""));
			f.setArriveState(s.select("select arrivalstate from flights where flightnumber = " + flightnumber).toString().replaceAll("[[]]", ""));
			f.setDepartTime(s.select("select departtime from flights where flightnumber = " + flightnumber).toString().replaceAll("[[]]", ""));
			f.setArrivalTime(s.select("select arrivaltime from flights where flightnumber = " + flightnumber).toString().replaceAll("[[]]", ""));
			f.setDate(s.select("select flightdate from flights where flightnumber = " + flightnumber).toString().replaceAll("[[]]", ""));
			f.setPrice(s.select("select price from flights where flightnumber = " + flightnumber).toString().replaceAll("[[]]", ""));
			f.setBookedPassengers(Integer.parseInt(s.select("select seatsavailable from flights where flightnumber = " + flightnumber).toString().replaceAll("[[]]", "")));
			f.setMaxPassengers(Integer.parseInt(s.select("select departstate from flights where flightnumber = " + flightnumber).toString().replaceAll("[[]]", "")));
		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		*/
		
		
/*		p1.add(new JLabel("Edit the contents of the flight"));
		add(p1, BorderLayout.NORTH);
		
		
		p2.add(aHome);
		p2.add(bOK);
		add(p2, BorderLayout.SOUTH);
*/		
		bOK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SQLStatements s = new SQLStatements();
				String[] departCityState = depart.getSelectedItem().toString().split("[,]");
				String[] arrivalCityState = arrive.getSelectedItem().toString().split("[,]");
				String departTime = hourD.getSelectedItem() + ":" + minuteD.getSelectedItem() + " " + amPMD.getSelectedItem() + " " + TZD.getSelectedItem();
				String arriveTime = hourA.getSelectedItem() + ":" + minuteA.getSelectedItem() + " " + amPMA.getSelectedItem() + " " + TZA.getSelectedItem();
				String date = month.getSelectedItem() + "/" + daySD.getSelectedItem() + dayDD.getSelectedItem() + "/" + year.getSelectedItem();
				if (depart.getSelectedItem().equals(arrive.getSelectedItem()) || (seats.getText().equals("") == true) || (price.getText().equals("") == true)) {
					AdminEditFlightError frame = new AdminEditFlightError();
					frame.setSize(500, 500);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}
				else {
				
					try {
						s.update("update flights set departcity = '" + departCityState[0] + "' where flightnumber = " + flightnumber);
						s.update("update flights set departstate = '" + departCityState[1] + "' where flightnumber = " + flightnumber);
						s.update("update flights set arrivalcity = '" + arrivalCityState[0] + "' where flightnumber = " + flightnumber);
						s.update("update flights set arrivalstate = '" + arrivalCityState[1] + "' where flightnumber = " + flightnumber);
						s.update("update flights set departtime = '" + departTime + "' where flightnumber = " + flightnumber);
						s.update("update flights set arrivaltime = '" + arriveTime + "' where flightnumber = " + flightnumber);
						s.update("update flights set flightdate = '" + date + "' where flightnumber = " + flightnumber);
						s.update("update flights set price = '" + price.getText() + "' where flightnumber = " + flightnumber);
						s.update("update flights set totalseats = '" + seats.getText() + "' where flightnumber = " + flightnumber);
					
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				AdminEFSuccess frame = new AdminEFSuccess(u);
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
		aHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AdminHome frame = new AdminHome(u);
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
}

public static void main(String[] args){
	Users u = new Customers();
	AdminEditFlight frame = new AdminEditFlight(u,"1");
	frame.setTitle("Registration Error");
	frame.setSize(500, 500);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}
}
