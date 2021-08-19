package lab.tank.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingTest02 { //����Ŭ������ ������ �ܺ�Ŭ������� �Ѵ�

	JTextArea textArea;  // �׸�ڽ��� ������
	JTextField textField; // �׸�ڽ��ȿ� ����   
	JButton writeButton;
	JButton cancleButton;
	
	public static void main(String[] args) {
		
		SwingTest02 st = new SwingTest02();
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
		
		//1. ������ ���
		//writeButton.addActionListener(new WriteButtonListener(textArea, textField)); //���� Ŭ���� ����� �� 
		//cancleButton.addActionListener(new CancleButtonListener(textField)); //���� Ŭ���� ����� ��
		
		//2. �Ϲ� ���� Ŭ���� ������ ���
		writeButton.addActionListener(new WriteButtonListener()); //���� Ŭ���� ���� ��
		//cancleButton.addActionListener(new CancleButtonListener()); //���� Ŭ���� ���� ��
		
		//3. �͸� ���� Ŭ���� ������ ���
		cancleButton.addActionListener(new ActionListener(){ //�������̽��� new �� �� ������
			
			@Override
	 		public void actionPerformed(ActionEvent e) {
				textField.setText(""); 
				textField.requestFocus(); 
			}
		});
		
		//���̱�
		mainPanel.add(scrollPane); //mainPanel�� ���δ�  //textArea�� scroll���� �ٿ������� ������ ����
		mainPanel.add(textField);
		mainPanel.add(writeButton);
		mainPanel.add(cancleButton);
		
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(400, 350);  //ũ��
		frame.setVisible(true);   //���̱�
	}
	//���� Ŭ���� : Ŭ���� �ȿ� Ŭ���� ����
 	public class WriteButtonListener implements ActionListener {

		//��ü�� ������ �κ��� �ܺ�Ŭ�������� ������ ����ϹǷ� �ٽ� ���� �ʿ䰡 ����
		@Override
		public void actionPerformed(ActionEvent e) {
				
				textArea.append(textField.getText()+"\n"); //�ؽ�Ʈ �ʵ忡 �ۼ��Ѱ� textArea�� �߰�����
				textField.setText(""); //�߰��Ŀ� �ؽ�Ʈ �ʵ带 ��������
				textField.requestFocus(); // �ؽ�Ʈ�ʵ忡 Ŀ�� �÷���
		}
	}
 	//3.�͸� ���� Ŭ������ �־��༭ ������  2�� ���� ���
 	//���� Ŭ����
 	//public class CancleButtonListener implements ActionListener{

 		//��ü�� ������ �κ��� �ܺ�Ŭ�������� ������ ����ϹǷ� �ٽ� ���� �ʿ䰡 ����
// 		@Override
// 		public void actionPerformed(ActionEvent e) {
// 			
// 			textField.setText(""); //�߰��Ŀ� �ؽ�Ʈ �ʵ带 ��������
// 			textField.requestFocus(); // �ؽ�Ʈ�ʵ忡 Ŀ�� �÷���
// 		}

// 	}
}
