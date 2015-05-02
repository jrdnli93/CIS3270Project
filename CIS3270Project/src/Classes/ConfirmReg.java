package Classes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import projectCIS3270.MainMenu;

public class ConfirmReg extends JFrame {
	public ConfirmReg(){
		JButton MainMenu = new JButton("Main Menu");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.add(new JLabel("Success! You have registered with the following information"));
		p1.add(new JLabel("Please login in the Main Menu"));
		//need to display ALL information entered
		//also display status of customer or admin
		p2.add(MainMenu);
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.SOUTH);
		MainMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MainMenu mMenu = new MainMenu();
				mMenu.setSize(500, 500);
				mMenu.setLocationRelativeTo(null);
				mMenu.setVisible(true);
				dispose();
			}
		});
		
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