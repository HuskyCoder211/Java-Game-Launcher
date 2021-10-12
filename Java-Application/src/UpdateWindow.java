package Application;

import javax.swing.*;
import java.awt.BorderLayout;

public class UpdateWindow {
	public static JFrame updateWindow;
	
	public static void create() {
		updateWindow = new JFrame("Game Updating");
		updateWindow.setSize(300, 150);
		
		JPanel panel = new JPanel();
		
		JTextArea about = new JTextArea();
		about.setEditable(false);
		about.append("Updating, please be patient.");
		
		panel.add(about);
		
		updateWindow.getContentPane().add(BorderLayout.CENTER, panel);
		
		updateWindow.setVisible(true);
	}
	
	public static void close() {
		updateWindow.dispose();
	}
}
