import java.awt.Color;

import javax.swing.*;
public class Frame extends JFrame{
	
	Frame(){
		//settings for the frame
		this.setTitle("Team Project");
		this.setSize(800, 600);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(0x123456));
	}
}
