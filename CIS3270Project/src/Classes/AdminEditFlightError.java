package Classes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminEditFlightError extends JFrame {
	public AdminEditFlightError(){
		
		JPanel p1 = new JPanel();
		p1.add(new JLabel("Conflicts in the edit, Close This Window And Try Again"));
		add(p1, BorderLayout.NORTH);
		
		
		
		
}

public static void main(String[] args){
	AdminEditFlightError frame = new AdminEditFlightError();
	frame.setTitle("Current Flights");
	frame.setSize(500, 500);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}
}