package lab.itank.collection;

import java.util.Stack;

public class StackTest {
	//설명 : 나중에 들어간 데이터가 먼저 소비된다.
	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<>();
		stack.push("메소드1실행");
		stack.push("메소드2실행");
		stack.push("메소드3실행");
		stack.push("메소드4실행");
		
		System.out.println("가장 위에 있는 데이터: " + stack.peek());
		
		while(!stack.isEmpty()) {
		System.out.println(stack.pop());
		}
		
		StackTest st = new StackTest();
		st.methodB();
	}
	
	void methodA() {methodC();}
	
	void methodB() {methodA();}
	
	void methodC() {}
}
