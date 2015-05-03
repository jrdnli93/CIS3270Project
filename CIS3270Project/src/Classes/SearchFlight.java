package Classes;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SearchFlight extends JFrame{
	public SearchFlight(){
		JComboBox depart = new JComboBox(new String[]{"California", "Georgia", "Hawaii", "New York", "Texas"});
		JComboBox arrive = new JComboBox(new String[]{"California", "Georgia", "Hawaii", "New York", "Texas"});
		JButton bOK = new JButton("OK");
		JButton cHome = new JButton("Return to Home Page");
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4,1));
		p1.add(new JLabel("Choose Departure City"));
		p1.add(depart);
		p1.add(new JLabel("Choose Arrival City"));
		p1.add(arrive);
		add(p1, BorderLayout.NORTH);
		
		JPanel p2 = new JPanel();
		p2.add(bOK);
		add(p2, BorderLayout.CENTER);
		
		JPanel p3 = new JPanel();
		p3.add(cHome);
		add(p3, BorderLayout.SOUTH);
		
		bOK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SearchResults sResult = new SearchResults();
				sResult.setSize(500, 500);
				sResult.setLocationRelativeTo(null);
				sResult.setVisible(true);
				dispose();
			}
		});
//NEED TO HAVE OPTION TO RETURN EITHER TO CUSTOMER OR ADMIN HOME
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
		SearchFlight frame = new SearchFlight();
		frame.setTitle("Flight Search");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
