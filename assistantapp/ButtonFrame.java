package assistantapp;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ButtonFrame extends JFrame implements ActionListener{
	
		JButton button;
		JTextField textField;
	
		ButtonFrame(){
			
			button = new JButton(); 
			
			button.setBounds(400, 600, 50, 50); // gives it some size
			
			button.setText("Send");
			button.setFocusable(false);
			
			button.setHorizontalTextPosition(JButton.CENTER);
			button.setVerticalTextPosition(JButton.CENTER);
			
			button.addActionListener(this); // yeah i'm him
			
			/*  ALTERNATE:
			 *  
			 *  button.addActionListener(e -> (action));
			 *  button.addActionListener(e -> System.out.println("clicked");
			 */
			
			textField = new RoundTextField(15);
			textField.setBounds(50, 605, 350, 40);
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // the X button works
			//this.setLayout(null);
			this.setResizable(false);
			this.setSize(500, 700); // gives the FRAme some size
			this.setVisible(true); // makes the frame visible
			this.add(button); // adds button to the frame
			this.add(textField);
	}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==button) {
				System.out.println("clicked");
			}			
		}
}
