package assistantapp;
import java.awt.*;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		test("hi");

		JFrame frame = new ButtonFrame();
		//frame.setSize(3024, 1964);
		frame.setTitle("assistant app");
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		//frame.setResizable(false);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.gray);

	}
	
	public static void test(String a) {
		System.out.println(a);
	}

	
	
//	public static void createButton(String textOnButton, int size) {
//		

//	}
}
