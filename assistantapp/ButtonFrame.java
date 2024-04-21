package assistantapp;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ButtonFrame extends JFrame implements ActionListener{
	
		JButton button;
		JTextField textField;
		static JTextArea displayTextField = new JTextArea("Answer will display here.\n\nType in your question in the text box below."); // displays text to give instructions to the user on what to do, also tells user where the output will be
		
		JScrollPane scroll = new JScrollPane(displayTextField, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		public static boolean processing = false;
		
		String command = "";
	
		ButtonFrame(){ // class definition for the frame
			
			button = new JButton(); 
			
			button.setBounds(400, 270, 50, 50); // gives it some size
			
			button.setText("Send");
			button.setFocusable(false);
			
			button.setHorizontalTextPosition(JButton.CENTER);
			button.setVerticalTextPosition(JButton.CENTER);
			
			button.addActionListener(this); // so program can check when it's pressed
			
			textField = new RoundTextField(15);
			textField.setBounds(50, 275, 350, 40);
			textField.setFocusable(true);
			
			scroll.setBounds(50, 25, 400, 225);
			displayTextField.setFocusable(false);
			displayTextField.setLineWrap(true);
			displayTextField.setWrapStyleWord(true);
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // the X button works
			this.setLayout(null);
			this.setResizable(false);
			this.setSize(500, 350); // gives the frame some size
			this.add(button); // adds button to the frame
			this.add(textField); // adds user input textfield to frame
			this.add(scroll);
			
			this.setVisible(true); // makes the frame visible
			
	} 
		
		public static void displayResponse(String response) {
			displayTextField.setText(response); // displays response to the display text field
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==button && !processing) { // checks to see if button is pressed and there's no ongoing command
				giveCommand(); // sends command 
			}			
		}
		
		void giveCommand() {
			processing = true; // makes sure that no more questions can be asked while this one is processing
			command = textField.getText(); 
			
			if(textField.getText().equals("")) { // makes sure there is a question being asked
				displayTextField.setText("You must enter a question!");
				processing = false;
			} else Chance.calcChance(command); // passes the command onto the chance calculator
			textField.setText(""); // resets the text box
		}
}
