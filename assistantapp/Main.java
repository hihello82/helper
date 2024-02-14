package assistantapp;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener{

	JTextField textField = new JTextField(20);
	JButton button = new JButton();
	
	public static void main(String[] args) {
			
		ButtonFrame frame = new ButtonFrame(); 
		// this implements the other class in your project NOT some random shit dumbass
		// by calling this it makes a frame according to the frame i made in the other class 
		
		// FRAME SETUP
//		frame.setLayout(new FlowLayout());
//		frame.setSize(new Dimension(3024, 1964));
//		frame.setTitle("Helper App");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(500, 500);
//		frame.setVisible(true);
//		frame.getContentPane().setBackground(Color.gray);
		
		// PANEL SETUP??
		
		
		// BUTTON SETUP
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			System.out.println("clicked");
		}		
	}
}
