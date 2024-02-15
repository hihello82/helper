package assistantapp;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ButtonFrame extends JFrame implements ActionListener{
	
		JButton button;
		JTextField textField;
		JTextField displayTextField;
		
		Color borderColorLight = new Color(0, 0, 0);
		Color borderColorDark = new Color(255, 255, 255);
		
		Color backgroundColorLight = new Color(238, 238, 238);
		Color backgroundColorDark = new Color(17, 17, 17);
	
		ButtonFrame(boolean lightMode){
		
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
			
			// USER INPUT
			textField = new RoundTextField(15);
			textField.setBounds(50, 605, 350, 40);
			
			displayTextField = new RoundTextField(15);
			displayTextField.setBounds(50, 25, 400, 555);
			
			// APPERANCE SETTINGS (there's prolly a way to optimise this but im lazy)
			
			if(!lightMode) {
				textField.setBorder(BorderFactory.createLineBorder(borderColorDark));
				displayTextField.setBorder(BorderFactory.createLineBorder(borderColorDark));
				this.setBackground(backgroundColorDark);
				System.out.println("dark mode");
			} else {
				textField.setBorder(BorderFactory.createLineBorder(borderColorLight));
				displayTextField.setBorder(BorderFactory.createLineBorder(borderColorLight));
				this.setBackground(backgroundColorLight);
			}
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // the X button works
			//this.setLayout(null);
			this.setResizable(false);
			this.setSize(500, 700); // gives the FRAme some size
			this.setVisible(true); // makes the frame visible
			this.add(button); // adds button to the frame
			this.add(textField); // adds user input textfield to frame
			this.add(displayTextField); // adds the responsedisplay to frame
	}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==button) {
				System.out.println("clicked");
			}			
		}
}
