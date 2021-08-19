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
			
			textArea.append(textField.getText()+"\n"); //�ؽ�Ʈ �ʵ忡 �ۼ��Ѱ� textArea�� �߰�����
			textField.setText(""); //�߰��Ŀ� �ؽ�Ʈ �ʵ带 ��������
			textField.requestFocus(); // �ؽ�Ʈ�ʵ忡 Ŀ�� �÷���
	}
	
}
