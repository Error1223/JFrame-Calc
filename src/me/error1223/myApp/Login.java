package me.error1223.myApp;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;



public class Login extends JFrame {

	private JPanel contentPane;
	public static JTextField usernameField;
	public static JTextField passwordField;
	public static JLabel errorMessage;
	public static JButton enterButton;

	/**
	 * Create the frame.
	 */
	public Login() {
		
		//JFrame settings
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
        setSize(550, 280);
        setTitle("Login");
        setLocationRelativeTo(null);
        
        //panel settings
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel welcomeLabel = new JLabel("Welcome");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(welcomeLabel);
		welcomeLabel.setBounds(83, 42, 101, 16);
		welcomeLabel.setForeground(Color.WHITE);
		
		enterButton = new JButton("Enter");
        enterButton.addActionListener(new FrameListener());
		enterButton.setBounds(165, 183, 89, 29);
		enterButton.setBorder(null);
		enterButton.setBackground(Color.white);
		contentPane.add(enterButton);
		
		JLabel userLabel = new JLabel("Username:");
		userLabel.setForeground(Color.WHITE);
		userLabel.setBounds(32, 96, 66, 16);
		contentPane.add(userLabel);
		
		JLabel passLabel = new JLabel("Password:");
		passLabel.setForeground(Color.WHITE);
		passLabel.setBounds(33, 124, 65, 16);
		contentPane.add(passLabel);
		
		usernameField = new JTextField();
		usernameField.setBounds(107, 91, 140, 26);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(107, 119, 140, 26);
			
		errorMessage = new JLabel("Wrong, please try again");
		errorMessage.setForeground(Color.RED);
		errorMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		errorMessage.setBounds(107, 144, 148, 16);
		errorMessage.setVisible(false);
		contentPane.add(errorMessage);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
	}
}
