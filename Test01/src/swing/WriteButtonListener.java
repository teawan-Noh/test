package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WriteButtonListener implements ActionListener {

	JTextArea textArea;
	JTextField textField;
	
	public WriteButtonListener(JTextArea textArea, JTextField textField) {
		this.textArea = textArea;
		this.textField = textField;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		textArea.append(textField.getText()+"\n");
		textField.setText("");
		textField.requestFocus();
		
	}
	

}
