import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class GUI{

	public GUI() {
		
	}
	
	public static void main(String[] args) {
		
		Frame pjFrame = new Frame();
		OptionsPanel panel1 = new OptionsPanel();
		pjFrame.setLayout(null);
		pjFrame.add(panel1);
		pjFrame.repaint();
		
	}

}
