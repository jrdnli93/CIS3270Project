package Classes;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class EditPersonal extends JFrame{
	public EditPersonal(final Users u){
		//ADD CHECKS
		final JTextField fName = new JTextField(((Customers)u).getFirstName());
		final JTextField mInitial = new JTextField(((Customers)u).getMiddleInitial());
		final JTextField lName = new JTextField(((Customers)u).getLastName());
		final JTextField address = new JTextField(((Customers)u).getAddress());
		final JTextField city =  new JTextField(((Customers)u).getCity());
		final JTextField state = new JTextField(((Customers)u).getState());
		final JTextField zip = new JTextField(((Customers)u).getZipCode());
		final JTextField password = new JTextField(((Customers)u).getPassword());
		final JTextField email = new JTextField(((Customers)u).geteMail());
		final JTextField secQuestion = new JTextField(((Customers)u).getSecurityQuestion());
		final JTextField secAnswer = new JTextField(((Customers)u).getSecurityAnswer());

		
		JButton cHome = new JButton("Home Page");
		JButton bOK = new JButton("OK");
		
		JPanel p1 = new JPanel();
		JPanel p3 = new JPanel();
		add(p1, BorderLayout.NORTH);
		p3.add(new JLabel("You May Edit The Following Information"));
		p1.setLayout(new GridLayout(12, 2));
		p1.add(new JLabel("First Name"));
		p1.add(fName);
		p1.add(new JLabel("Middle Initial"));
		p1.add(mInitial);
		p1.add(new JLabel("Last name"));
		p1.add(lName);
		p1.add(new JLabel("Street Address"));
		p1.add(address);
		p1.add(new JLabel("City"));
		p1.add(city);
		p1.add(new JLabel("State"));
		p1.add(state);
		p1.add(new JLabel("Zip Code"));
		p1.add(zip);
		p1.add(new JLabel("Password"));
		p1.add(password);
		p1.add(new JLabel("Email"));
		p1.add(email);
		p1.add(new JLabel("Security Question"));
		p1.add(secQuestion);
		p1.add(new JLabel("Security Answer"));
		p1.add(secAnswer);
		add(p1, BorderLayout.CENTER);
		
		
		
		JPanel p2 = new JPanel();
		p2.add(cHome);
		p2.add(bOK);
		add(p2, BorderLayout.SOUTH);
		//current customer information needs to be autofilled
		//NOTICE! SSN & admin code are not present
		cHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				if (((Customers)u).isAdmin()) {
					AdminHome sResult = new AdminHome(u);
					sResult.setSize(500, 500);
					sResult.setLocationRelativeTo(null);
					sResult.setVisible(true);
					dispose();
				}
				else {
					CustomerHome sResult = new CustomerHome(u);
					sResult.setSize(500, 500);
					sResult.setLocationRelativeTo(null);
					sResult.setVisible(true);
					dispose();
				}
				
				
			}
		});
		
		bOK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Add checks
				
				//Update Information
				SQLStatements s = new SQLStatements();
				
				try {
					s.update("update accountinfo set password = '" + password.getText() + "' where username = '" + ((Customers)u).getUsername() + "'");
					s.update("update user set firstname = '" + fName.getText() + "' where username = '" + ((Customers)u).getUsername() + "'");
					s.update("update user set middleInitial = '" + mInitial.getText() + "' where username = '" + ((Customers)u).getUsername() + "'");
					s.update("update user set lastname = '" + lName.getText() + "' where username = '" + ((Customers)u).getUsername() + "'");
					s.update("update user set address = '" + address.getText() + "' where username = '" + ((Customers)u).getUsername() + "'");
					s.update("update user set city = '" + city.getText() + "' where username = '" + ((Customers)u).getUsername() + "'");
					s.update("update user set state = '" + state.getText() + "' where username = '" + ((Customers)u).getUsername() + "'");
					s.update("update user set zipcode = '" + zip.getText() + "' where username = '" + ((Customers)u).getUsername() + "'");
					s.update("update user set email = '" + email.getText() + "' where username = '" + ((Customers)u).getUsername() + "'");
					s.update("update user set securityquestion = '" + secQuestion.getText() + "' where username = '" + ((Customers)u).getUsername() + "'");
					s.update("update user set securityanswer = '" + secAnswer.getText() + "' where username = '" + ((Customers)u).getUsername() + "'");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				EditPersonal2 frame = new EditPersonal2(u);
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
	
	}
	
	public static void main(String[] args){
		Users u = new Customers();
		EditPersonal frame = new EditPersonal(u);
		frame.setTitle("Edit Information");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}