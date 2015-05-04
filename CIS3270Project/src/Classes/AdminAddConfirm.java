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

public class AdminAddConfirm extends JFrame{
	public AdminAddConfirm(final Users u){
	
	JLabel success = new JLabel("Flight Successfully Added");
		
	JButton aHome = new JButton("Main Menu");
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	p1.setLayout(new GridLayout(1, 1));
	p1.add(success);
	p2.add(aHome);
	
	add(p1, BorderLayout.NORTH);
	add(p2, BorderLayout.SOUTH);

	//this is the popup for clicking OK, Currently it is for a successful 
	
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
		AdminAddConfirm frame = new AdminAddConfirm(u);
		frame.setTitle("Flight added");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
	}
