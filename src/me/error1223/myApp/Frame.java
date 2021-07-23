package me.error1223.myApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Frame extends JFrame implements ActionListener{
    private final int WINDOW_WIDTH = 300;
    private final int WINDOW_HEIGHT = 300;
    private JPanel panel;
    public static JTextField res = new JTextField();
    public static JButton b[] = new JButton[10];
    public static JButton op[] = new JButton[6];

    public Frame() {
        //default frame settings
        setTitle("Calculator");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        buildPanel();
        add(panel);

        setVisible(true);
    }

    private void buildPanel(){
        //panel settings
        panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(null);

        //Main screen for calculations
		res.setBounds(10, 10, 280, 40);
		panel.add(res);

        //number buttons
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
			panel.add(b[i]);
			b[i].addActionListener(this);
			x += 70;
			if(counter % 3 == 0){
				x -= 210;
				y += 50;
			}
			counter++;
		}

        //operation buttons
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
			panel.add(op[a]);
			y1 += 35;
		}

        //decimal point butotn
		JButton decimal = new JButton(".");
		decimal.addActionListener(this);
    }




    double n1, n2, result;
    int operation;

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton trig =(JButton)e.getSource();

        // C
        if(trig == op[0]){
            n1 = n2 = result = 0;
            res.setText("");
            resetColor();
        }

        //get operation
        for(int i = 1; i<=4; i++){
            if(trig == op[i]){
                if(res.getText().isEmpty()){
                    n1 = 0;
                }else{
                    n1 = Double.parseDouble(res.getText());
                }
                operation = i;
                res.setText("");
                //button animation
                op[i].setBackground(Color.GRAY);
            }
        }

        //get numbers
        for (int a = 0; a < 10; a++) {
           if(trig == b[a]){
               String num = res.getText();
               num += a;
               res.setText(num);
           } 
        }

        // = 
        if(trig == op[5] && !(res.getText().isEmpty())){
            resetColor();
            //calculate
            if(res.getText().isEmpty()){
                n2 = 0;
            }else{
                n2 = Double.parseDouble(res.getText());
            }
            switch (operation){
                case 1: result = n1+n2; break;
                case 2: result = n1-n2; break;
                case 3: result = n1*n2; break;
                case 4: result = n1/n2; break;
            }
            res.setText(""+ Double.toString(result));

        }
    }

    //button colro animate
    void resetColor(){
        for (int l = 1; l <= 4; l++) {
            op[l].setBackground(Color.WHITE);
        } 
    } 
}
