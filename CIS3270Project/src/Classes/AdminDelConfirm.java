package Classes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminDelConfirm extends JFrame {
	public AdminDelConfirm(){
		JPanel p1 = new JPanel();
		p1.add(new JLabel("Flight was deleted, close this window to continue"));
		add(p1, BorderLayout.NORTH);
}

public static void main(String[] args){
	AdminDelConfirm frame = new AdminDelConfirm();
	frame.setTitle("Registration Error");
	frame.setSize(500, 500);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}
}
