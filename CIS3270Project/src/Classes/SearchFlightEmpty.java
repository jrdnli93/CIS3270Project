package Classes;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchFlightEmpty extends JFrame{
	public SearchFlightEmpty(){
		JPanel p1 = new JPanel();
		p1.add(new JLabel("No Flights Were Added, Close the window and try again"));
		add(p1, BorderLayout.NORTH);
		
	}
	
	public static void main(String[] args){
		SearchFlightEmpty frame = new SearchFlightEmpty();
		frame.setTitle("Password Retreival");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
