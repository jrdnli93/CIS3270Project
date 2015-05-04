package Classes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewDeleteConfirm extends JFrame {
	public ViewDeleteConfirm(){
		
		JPanel p1 = new JPanel();
		p1.add(new JLabel("Flight Deleted, Close This Window To Continue"));
		add(p1, BorderLayout.NORTH);
		
		
		
		
}

public static void main(String[] args){
	ViewDeleteConfirm frame = new ViewDeleteConfirm();
	frame.setTitle("Current Flights");
	frame.setSize(500, 500);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}
}