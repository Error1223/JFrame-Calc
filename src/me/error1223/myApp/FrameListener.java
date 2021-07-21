package me.error1223.myApp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameListener implements ActionListener{
	public static CalcFrame cframe;
	@Override
	public void actionPerformed(ActionEvent e) {
		String username = Login.usernameField.getText();
		String password = Login.passwordField.getText();
		
		if(username.equals("Error1223") && password.equals("daytona")) {
			Main.frame.setVisible(false);
			Main.frame.dispose();
			//start main frame
			EventQueue.invokeLater(() -> {
				try {
					cframe = new CalcFrame();
					cframe.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
		}else {
			Login.errorMessage.setVisible(true);
		}
		
	}

}
