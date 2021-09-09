package swing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingTest01 {
	
	JTextArea textArea;
	JTextField textField;
	JButton writerButton;
	JButton cancleButton;

	public static void main(String[] args) {
		
		SwingTest01 st = new SwingTest01();
		st.go();
	}

	public void go() {
		
		JFrame frame = new JFrame();
		JPanel mainPanel = new JPanel();
		
		textArea = new JTextArea(15, 30);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		textField = new JTextField(15);
		writerButton = new JButton("write");
		cancleButton = new JButton("cancle");
		
		writerButton.addActionListener(new WriteButtonListener(textArea, textField));
		cancleButton.addActionListener(new CancleButtonListener(textField));
		
		mainPanel.add(scrollPane);
		mainPanel.add(textField);
		mainPanel.add(writerButton);
		mainPanel.add(cancleButton);
		
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(400, 350);
		frame.setVisible(true);
	}
}
