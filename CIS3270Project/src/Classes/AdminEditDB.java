package Classes;
//This is the screen for the Admin to choose to Add or Edit/Delete flight
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminEditDB extends JFrame{
	public AdminEditDB(){

		JButton aHome = new JButton("Home Menu");
		JButton delete = new JButton("Delete");
		JButton edit = new JButton("Edit");
		
		JPanel p1 = new JPanel();
		p1.add(new JLabel("Flight Schedule: Choose Whether To Edit Or Delete"));
		add(p1, BorderLayout.NORTH);
		
		JPanel p2 = new JPanel();
		p2.add(aHome);
		p2.add(delete);
		p2.add(edit);
		add(p2, BorderLayout.SOUTH);
		
		//delete needs to have action to delet flight selected
		aHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AdminHome frame = new AdminHome();
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
//1. if-else needed - if flights are actually deleted this action will occur		
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AdminDelConfirm frame = new AdminDelConfirm();
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

/*2. This is the second option - a window will pop up to let Admin Know nothing was deleted
 * 				AdminDelError frame = new AdminDelError();
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
 */
			}
		});

//1. if-else needed - if flights is chosen to edit this action will occur				
		edit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AdminEditFlight frame = new AdminEditFlight();
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();

/*2. This is the second option - a window will pop up to let Admin Know nothing
 * was chosen to edit
 * 			AdminDelError frame = new AdminDelError();
			frame.setSize(500, 500);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
*/
			}
		});

	}	
	public static void main(String[] args){
		AdminEditDB frame = new AdminEditDB();
		frame.setTitle("Edit Options");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
