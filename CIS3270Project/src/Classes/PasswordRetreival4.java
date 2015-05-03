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

public class PasswordRetreival4 extends JFrame{
	public PasswordRetreival4(){
		//Error for all password retrieval pages
		JPanel p1 = new JPanel();
		p1.add(new JLabel("Error, please try again"));
		add(p1, BorderLayout.NORTH);
	}
	public static void main(String[] args){
		PasswordRetreival4 frame = new PasswordRetreival4();
		frame.setTitle("Password Retreival");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}