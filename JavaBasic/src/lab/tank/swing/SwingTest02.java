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

public class SwingTest02 { //내부클레스를 넣으면 외부클레스라고 한다

	JTextArea textArea;  // 네모박스에 여러줄
	JTextField textField; // 네모박스안에 한줄   
	JButton writeButton;
	JButton cancleButton;
	
	public static void main(String[] args) {
		
		SwingTest02 st = new SwingTest02();
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
		
		//1. 리스너 등록
		//writeButton.addActionListener(new WriteButtonListener(textArea, textField)); //내부 클레스 만들기 전 
		//cancleButton.addActionListener(new CancleButtonListener(textField)); //내부 클레스 만들기 전
		
		//2. 일반 내부 클레스 리스너 등록
		writeButton.addActionListener(new WriteButtonListener()); //내부 클레스 만든 후
		//cancleButton.addActionListener(new CancleButtonListener()); //내부 클레스 만든 후
		
		//3. 익명 내부 클레스 리스너 등록
		cancleButton.addActionListener(new ActionListener(){ //인터페이스는 new 할 수 없지만
			
			@Override
	 		public void actionPerformed(ActionEvent e) {
				textField.setText(""); 
				textField.requestFocus(); 
			}
		});
		
		//붙이기
		mainPanel.add(scrollPane); //mainPanel에 붙인다  //textArea에 scroll까지 붙여놓은걸 가져다 붙임
		mainPanel.add(textField);
		mainPanel.add(writeButton);
		mainPanel.add(cancleButton);
		
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(400, 350);  //크기
		frame.setVisible(true);   //보이기
	}
	//내부 클레스 : 클레스 안에 클레스 선언
 	public class WriteButtonListener implements ActionListener {

		//객체와 생성자 부분을 외부클레스에서 가져와 사용하므로 다시 만들 필요가 없다
		@Override
		public void actionPerformed(ActionEvent e) {
				
				textArea.append(textField.getText()+"\n"); //텍스트 필드에 작성한걸 textArea에 추가해줘
				textField.setText(""); //추가후에 텍스트 필드를 리셋해줘
				textField.requestFocus(); // 텍스트필드에 커서 올려줘
		}
	}
 	//3.익명 내부 클레스로 넣어줘서 가려줌  2번 까진 사용
 	//내부 클레스
 	//public class CancleButtonListener implements ActionListener{

 		//객체와 생성자 부분을 외부클레스에서 가져와 사용하므로 다시 만들 필요가 없다
// 		@Override
// 		public void actionPerformed(ActionEvent e) {
// 			
// 			textField.setText(""); //추가후에 텍스트 필드를 리셋해줘
// 			textField.requestFocus(); // 텍스트필드에 커서 올려줘
// 		}

// 	}
}
