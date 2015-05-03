package Classes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewDelete extends JFrame {
	public ViewDelete(){
		JButton delFlight = new JButton("Delete Flight");
		JButton cHome = new JButton("Home Page");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.add(new JLabel("These are your flights"));
		p2.add(delFlight);
		p2.add(cHome);
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.SOUTH);
		
		cHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CustomerHome sResult = new CustomerHome();
				sResult.setSize(500, 500);
				sResult.setLocationRelativeTo(null);
				sResult.setVisible(true);
				dispose();
			}
		});
		
		//Add action to delete content here
		delFlight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ViewDeleteConfirm frame = new ViewDeleteConfirm();
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		
}

public static void main(String[] args){
	ViewDelete frame = new ViewDelete();
	frame.setTitle("Current Flights");
	frame.setSize(500, 500);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}
}