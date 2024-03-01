package assistantapp;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ButtonFrame extends JFrame implements ActionListener{
	
		JButton button;
		JTextField textField;
		static JTextArea displayTextField = new JTextArea("Answer will display here.");
		
		JScrollPane scroll = new JScrollPane(displayTextField, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		public static boolean processing = false;
		
		String command = "";
	
		ButtonFrame(){
			
			button = new JButton(); 
			
			button.setBounds(400, 270, 50, 50); // gives it some size
			
			button.setText("Send");
			button.setFocusable(false);
			
			button.setHorizontalTextPosition(JButton.CENTER);
			button.setVerticalTextPosition(JButton.CENTER);
			
			button.addActionListener(this); // yeah i'm him
			
			textField = new RoundTextField(15);
			textField.setBounds(50, 275, 350, 40);
			textField.setFocusable(true);
			
			scroll.setBounds(50, 25, 400, 225);
			displayTextField.setFocusable(false);
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // the X button works
			this.setLayout(null);
			this.setResizable(false);
			this.setSize(500, 350); // gives the FRAme some size
			this.add(button); // adds button to the frame
			this.add(textField); // adds user input textfield to frame
			this.add(scroll);
			
			this.setVisible(true); // makes the frame visible
			
	}
		
		public static void displayResponse(String response) {
			displayTextField.setText(response);
		}

		void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER && !processing) {
				System.out.println("enter pressed");
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
			
			if(textField.getText().equals("")) {
				displayTextField.setText("You must enter a question!");
				processing = false;
			} else Chance.calcChance(command);
		}
}
