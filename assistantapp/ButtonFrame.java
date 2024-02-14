package assistantapp;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ButtonFrame extends JFrame implements ActionListener{
	
		JButton button;
	
		ButtonFrame(){
			
			button = new JButton(); 
			button.setBounds(200, 100, 100, 50); // gives it some size
			
			button.addActionListener(this); // yeah i'm him
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // the X button works
			//this.setLayout(null);
			this.setSize(500, 700); // gives the FRAme some size
			this.setVisible(true); // makes the frame visible
			this.add(button); // adds button to the frame
	}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==button) {
				System.out.println("clicked");
			}
			
		}
}
