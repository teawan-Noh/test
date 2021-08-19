package lab.tank.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WriteButtonListener implements ActionListener {

	JTextField textField;
	JTextArea textArea;
	
	public WriteButtonListener(JTextArea textArea, JTextField textField) {
		this.textArea = textArea;
		this.textField = textField;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			
			textArea.append(textField.getText()+"\n"); //텍스트 필드에 작성한걸 textArea에 추가해줘
			textField.setText(""); //추가후에 텍스트 필드를 리셋해줘
			textField.requestFocus(); // 텍스트필드에 커서 올려줘
	}
	
}
