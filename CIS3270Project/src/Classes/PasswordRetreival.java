package Classes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PasswordRetreival extends JFrame{
	public PasswordRetreival(){

		JTextField uName = new JTextField();
		JTextField sQuestion = new JTextField();
		JButton bOK = new JButton("OK");
		JButton mMenu = new JButton("Main Menu");
		final JPanel p1 = new JPanel();
		final JPanel p2 = new JPanel();
		final JPanel p3 = new JPanel();
		final JPanel p4 = new JPanel();
		p1.setLayout(new GridLayout(2, 2));
		p1.add(new JLabel("Username"));
		p1.add(uName);
		p1.add(new JLabel("Security Question"));
		p1.add(sQuestion);
		p2.add(mMenu);
		p3.add(bOK);
		p4.add(new JLabel("Success"));
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.EAST);
		add(p3, BorderLayout.CENTER);
		add(p4, BorderLayout.SOUTH);
		p4.setVisible(false);
	
		//this is the popup for clicking OK, Currently it is for a successful 
		bOK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				PasswordRetreival check = new PasswordRetreival();
					p1.setVisible(false);
					p2.setVisible(true);
					p3.setVisible(false);
					p4.setVisible(true);	
			}
		});
		mMenu.addActionListener(new ActionListener(){
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
		PasswordRetreival frame = new PasswordRetreival();
		frame.setTitle("Password Retreival");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
