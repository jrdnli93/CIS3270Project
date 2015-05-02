package projectCIS3270;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConfirmReg extends JFrame {
	public ConfirmReg(){
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.add(new JLabel("Success! You have registered with the following information"));
		//need to display ALL information entered
		//also display status of customer or admin
		p2.add(new JButton("Main Menu"));
		p2.add(new JButton("Login"));
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.SOUTH);
		
		
}

public static void main(String[] args){
	ConfirmReg frame = new ConfirmReg();
	frame.setTitle("Verify Information");
	frame.setSize(500, 500);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}
}