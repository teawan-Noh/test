package lab.tank.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class CancleButtonListener implements ActionListener{

	JTextField textField;

	public CancleButtonListener(JTextField textField) {
		this.textField = textField;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		textField.setText(""); //추가후에 텍스트 필드를 리셋해줘
		textField.requestFocus(); // 텍스트필드에 커서 올려줘
	}

}
