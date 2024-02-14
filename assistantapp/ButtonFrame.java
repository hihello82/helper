package assistantapp;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ButtonFrame extends JFrame implements ActionListener{
	
		JButton button;
	
		ButtonFrame(){
			button = new JButton();
			button.setBounds(200, 100, 100, 50);
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(null);
			this.setSize(100, 100);
			this.setVisible(true);
			this.add(button);
	}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==button) {
				System.out.println("clicked");
			}
			
		}
}
