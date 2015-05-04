package Classes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminDelError extends JFrame {
	public AdminDelError(){
		
		JPanel p1 = new JPanel();
		p1.add(new JLabel("No Info To Delete, Close This Window And Try Again"));
		add(p1, BorderLayout.NORTH);
		
		
		
		
}

public static void main(String[] args){
	AdminDelError frame = new AdminDelError();
	frame.setTitle("Current Flights");
	frame.setSize(500, 500);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}
}