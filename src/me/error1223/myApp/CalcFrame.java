package me.error1223.myApp;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.event.*;

public class CalcFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton b[] = new JButton[10];
	private JButton op[] = new JButton[6];

	//main input textfield
	private static JTextField tf;

	//operators and operands
	private String in0, in1, in2;
	/**
	 * Create the frame.
	 */
	public CalcFrame() {
		in0 = in1 = in2 = "";
        try {
            // set look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
		//frame settings
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
        setTitle("Calculator");
        setLocationRelativeTo(null);
		setResizable(false);
        
        //panel settings
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);

		//text field
		tf = new JTextField();
		tf.setEditable(false);
		tf.setBounds(10, 10, 280, 40);
		contentPane.add(tf);

		int counter = 1;
		int x = 12;
		int y = 50; 
		//grid set logic
		for(int i = 9; i >= 0; i--){
			b[i] = new JButton(i + "");

			b[i].setBorder(new LineBorder(null));
			b[i].setBackground(Color.white);
			b[i].setOpaque(true);
			b[i].setBounds(x, y, 70, 50);
			b[i].setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			contentPane.add(b[i]);
			b[i].addActionListener(this);
			x += 70;
			if(counter % 3 == 0){
				x -= 210;
				y += 50;
			}
			counter++;
		}

		op[0] = new JButton("C");
		op[1] = new JButton("+");
		op[2] = new JButton("−");
		op[3] = new JButton("×");
		op[4] = new JButton("÷");
		op[5] = new JButton("=");

		int x1 = 225;
		int y1 = 50;
		//grid set logic
		for(int a = 0; a <= 5; a++){
			op[a].setBorder(new LineBorder(null));
			op[a].setBackground(Color.white);
			op[a].setOpaque(true);
			op[a].setBounds(x1, y1, 60, 35);
			op[a].setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			op[a].addActionListener(this);
			contentPane.add(op[a]);
			y1 += 35;
		}

		JButton decimal = new JButton(".");
		decimal.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e){

	}

}
