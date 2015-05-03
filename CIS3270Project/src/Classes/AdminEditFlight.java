package Classes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminEditFlight extends JFrame {
	public AdminEditFlight(){
		
		JButton bOK = new JButton("OK");
		JButton aHome = new JButton("Home Menu");
		
		JPanel p1 = new JPanel();
		p1.add(new JLabel("Edit the contents of the flight"));
		add(p1, BorderLayout.NORTH);
		
		JPanel p2 = new JPanel();
		p2.add(aHome);
		p2.add(bOK);
		add(p2, BorderLayout.SOUTH);
		
		bOK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AdminEFSuccess frame = new AdminEFSuccess();
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
		aHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AdminHome frame = new AdminHome();
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
}

public static void main(String[] args){
	AdminEditFlight frame = new AdminEditFlight();
	frame.setTitle("Registration Error");
	frame.setSize(500, 500);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}
}
