package me.error1223.myApp;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main extends JFrame{

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				new Frame();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
