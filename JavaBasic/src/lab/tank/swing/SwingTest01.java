package lab.tank.swing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingTest01 { 

	JTextArea textArea;  // �׸�ڽ��� ������
	JTextField textField; // �׸�ڽ��ȿ� ����   
	JButton writeButton;
	JButton cancleButton;
	
	public static void main(String[] args) {
		
		SwingTest01 st = new SwingTest01();
		st.go();
	}

	public void go() {
		//gui ����
		JFrame frame = new JFrame("Swing Test"); //Ʋ�� �����
		JPanel mainPanel = new JPanel();  //�ǳ� �����
		
		textArea = new JTextArea(15, 30); //���� ���� ����
		textArea.setLineWrap(true); //�Է°��� �� ��� �� �Ѱ� ������� ����
		textArea.setEditable(false);//textArea�� ���� �����ϰ� ���� �Ұ����ϰ� ����  //false �Ұ���
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		textField = new JTextField(15);  //���α��� 
		writeButton = new JButton("write"); //��ư ���� ��Ÿ���� ���� //��ư ����
		cancleButton = new JButton("cancle");  //��ư����
		
		//������ ���
		writeButton.addActionListener(new WriteButtonListener(textArea, textField)); 
		cancleButton.addActionListener(new CancleButtonListener(textField));
		
		//���̱�
		mainPanel.add(scrollPane); //mainPanel�� ���δ�  //textArea�� scroll���� �ٿ������� ������ ����
		mainPanel.add(textField);
		mainPanel.add(writeButton);
		mainPanel.add(cancleButton);
		
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(400, 350);  //ũ��
		frame.setVisible(true);   //���̱�
	}

	
}
