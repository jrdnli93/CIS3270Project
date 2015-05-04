package Classes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminEFSuccess extends JFrame {
	public AdminEFSuccess(final Users u){
		
		JButton aHome = new JButton("Home Menu");
		
		JPanel p1 = new JPanel();
		p1.add(new JLabel("The Content Has Been Edited"));
		add(p1, BorderLayout.NORTH);
		
		JPanel p2 = new JPanel();
		p2.add(aHome);
		add(p2, BorderLayout.SOUTH);
		
		aHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AdminHome frame = new AdminHome(u);
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
}

public static void main(String[] args){
	Users u = new Customers();
	AdminEFSuccess frame = new AdminEFSuccess(u);
	frame.setTitle("Registration Error");
	frame.setSize(500, 500);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}
}
