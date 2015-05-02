package Classes;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SplashScreen extends JWindow{

	private int duration = 0;
	
	public SplashScreen(int duration){
		this.duration = duration;
		
		JPanel panel = (JPanel) getContentPane();
		ImageIcon img = new ImageIcon("img/PeterSplash.jpg");

		panel.add(new JLabel(img),BorderLayout.CENTER);
		setSize(img.getIconWidth(), img.getIconHeight());
		setLocationRelativeTo(null);
		setVisible(true);
		
		try{
			Thread.sleep(duration);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		setVisible(false);
		app();
	}
	
	public void app(){
		MainMenu start = new MainMenu();
		start.setTitle("Main Menu");
		start.setSize(500, 500);
		start.setLocationRelativeTo(null);
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start.setVisible(true);	
		
		
	}
	
	public static void main(String[] args){
		new SplashScreen(4000);
	}
}
