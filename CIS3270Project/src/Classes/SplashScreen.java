package Classes;
import javax.swing.*;

import java.awt.*;

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
		MainMenu start = new MainMenu();
		start.setTitle("Main Menu");
		start.setSize(500, 500);
		start.setLocationRelativeTo(null);
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start.setVisible(true);
	}
	
	public void app(){
		JFrame window = new JFrame("Application");
		window.add(new JLabel("App goes here"));
		window.setSize(300, 300);
		window.setLocationRelativeTo(null);
		window.setVisible(true);		
	}
	public static void main(String[] args){
		new SplashScreen(4000);
	}
}
