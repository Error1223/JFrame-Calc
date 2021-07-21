package me.error1223.myApp;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main extends JFrame{
	public static Login frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				frame = new Login();
				frame.getRootPane().setDefaultButton(Login.enterButton);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
