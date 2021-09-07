package Application;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.awt.*;
import java.net.URL;

public class Window {
	public Window() {
		JFrame frame = new JFrame("Java Game Launcher");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		JButton playButton = new JButton("PLay");
		playButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("Checking for updates");
					Updater.checkForUpdate(new URL("https://drive.google.com/uc?export=download&id=1mB2yIO1QL89jzHciTxWDpZGLolkFhhhM"));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (Launcher.status=="ready") {
					System.out.println("Launching");
					
				}
			}
		});
		JTextArea aboutSection = new JTextArea();
		aboutSection.append("Author: Aiden Cebula\nVersion: 1.0\n");
		aboutSection.setEditable(false);
		
		panel.add(playButton);
		
		frame.getContentPane().add(BorderLayout.CENTER, aboutSection);
		frame.getContentPane().add(BorderLayout.SOUTH, panel);
		
		frame.setVisible(true);
	}
}
