package lab.tank.swing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingTest01 { 

	JTextArea textArea;  // 네모박스에 여러줄
	JTextField textField; // 네모박스안에 한줄   
	JButton writeButton;
	JButton cancleButton;
	
	public static void main(String[] args) {
		
		SwingTest01 st = new SwingTest01();
		st.go();
	}

	public void go() {
		//gui 구현
		JFrame frame = new JFrame("Swing Test"); //틀을 만든다
		JPanel mainPanel = new JPanel();  //판넬 만든다
		
		textArea = new JTextArea(15, 30); //세로 가로 길이
		textArea.setLineWrap(true); //입력값이 긴 경우 행 넘겨 출력할지 여부
		textArea.setEditable(false);//textArea를 편집 가능하게 할지 불가능하게 할지  //false 불가능
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		textField = new JTextField(15);  //가로길이 
		writeButton = new JButton("write"); //버튼 위에 나타나는 글자 //버튼 생성
		cancleButton = new JButton("cancle");  //버튼생성
		
		//리스너 등록
		writeButton.addActionListener(new WriteButtonListener(textArea, textField)); 
		cancleButton.addActionListener(new CancleButtonListener(textField));
		
		//붙이기
		mainPanel.add(scrollPane); //mainPanel에 붙인다  //textArea에 scroll까지 붙여놓은걸 가져다 붙임
		mainPanel.add(textField);
		mainPanel.add(writeButton);
		mainPanel.add(cancleButton);
		
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(400, 350);  //크기
		frame.setVisible(true);   //보이기
	}

	
}
