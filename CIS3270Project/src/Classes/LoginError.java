package Classes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginError extends JFrame{

	public LoginError () {
		JButton back = new JButton("Previous Screen");
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.add(new JLabel("Error: The following information needs to be changed"));
		p2.add(back);
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//RETURN TO PREVIOUS SCREEEN. This will be were to add previous content
				LoginInfo rInfo = new LoginInfo();
				rInfo.setSize(500, 500);
				rInfo.setLocationRelativeTo(null);
				rInfo.setVisible(true);
				dispose();
			}
		});

	}
	public static void main(String[] args){
		RegistrationError frame = new RegistrationError();
		frame.setTitle("Registration Error");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}