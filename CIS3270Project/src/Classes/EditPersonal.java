package Classes;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EditPersonal extends JFrame{
	public EditPersonal(){
		JButton cHome = new JButton("Home Page");
		JButton bOK = new JButton("OK");
		
		JPanel p1 = new JPanel();
		p1.add(new JLabel("You May Edit The Following Information"));
		add(p1, BorderLayout.NORTH);
		
		JPanel p2 = new JPanel();
		p2.add(cHome);
		p2.add(bOK);
		add(p2, BorderLayout.SOUTH);
		//current customer information needs to be autofilled
		//NOTICE! SSN & admin code are not present
		cHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CustomerHome sResult = new CustomerHome();
				sResult.setSize(500, 500);
				sResult.setLocationRelativeTo(null);
				sResult.setVisible(true);
				dispose();
			}
		});
		
		bOK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				EditPersonal2 frame = new EditPersonal2();
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
	
	}
	
	public static void main(String[] args){
		EditPersonal frame = new EditPersonal();
		frame.setTitle("Edit Information");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}