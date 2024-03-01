package assistantapp;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ButtonFrame extends JFrame implements ActionListener{
	
		JButton button;
		JTextField textField;
		static JTextArea displayTextField;
		Container c = this.getContentPane();
		public static boolean processing = false;
		
		String command = "";
	
		ButtonFrame(){
		
			c.setLayout(null);
						
			button = new JButton(); 
			
			button.setBounds(400, 270, 50, 50); // gives it some size
			
			button.setText("Send");
			button.setFocusable(false);
			
			button.setHorizontalTextPosition(JButton.CENTER);
			button.setVerticalTextPosition(JButton.CENTER);
			
			button.addActionListener(this); // yeah i'm him
			
			textField = new RoundTextField(15);
			textField.setBounds(50, 275, 350, 40);
			
			displayTextField = new JTextArea();
			displayTextField.setLineWrap(true);
			displayTextField.setBounds(50, 25, 400, 225);
			displayTextField.enable(false);
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // the X button works
			//this.setLayout(null);
			this.setResizable(false);
			this.setSize(500, 350); // gives the FRAme some size
			this.setVisible(true); // makes the frame visible
			this.add(button); // adds button to the frame
			this.add(textField); // adds user input textfield to frame
			
			c.setVisible(true);
			c.add(displayTextField); // adds the responsedisplay to frame
			displayTextField.setText(" ");
	}
		
		public static void displayResponse(String response) {
			displayTextField.setText(response);
		}

		void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER && !processing) {
				giveCommand();
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==button && !processing) {
				giveCommand();
			}			
		}
		
		void giveCommand() {
			processing = true;
			command = textField.getText();
			textField.setText("");
			Chance.calcChance(command);
		}
}
