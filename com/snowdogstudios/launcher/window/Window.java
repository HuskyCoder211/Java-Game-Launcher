package com.snowdogstudios.launcher.window;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.awt.*;
import java.net.URL;
import com.snowdogstudios.launcher.Launcher;
import com.snowdogstudios.launcher.updater.Updater;

public class Window {
	public Window() {
		JFrame frame = new JFrame("Java Game Launcher");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		JButton playButton = new JButton("PLay");
		playButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (Launcher.status=="ready") {
					System.out.println("Attempting Launch");
					Launcher.launch();
				}
			}
		});
		
		JButton updateButton = new JButton("update");
		updateButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					Updater.checkForUpdate();
					Updater.downloadUpdate();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JTextArea aboutSection = new JTextArea();
		aboutSection.append("Author: Aiden Cebula\nVersion: 1.0\n");
		aboutSection.setEditable(false);
		
		//panel.add(BorderLayout.WEST, updateButton);
		panel.add(playButton);
		
		frame.getContentPane().add(BorderLayout.CENTER, aboutSection);
		frame.getContentPane().add(BorderLayout.SOUTH, panel);
		
		frame.setVisible(true);
	}
}
