package lab.itank.collection;

import java.util.Stack;

public class StackTest {
	//���� : ���߿� �� �����Ͱ� ���� �Һ�ȴ�.
	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<>();
		stack.push("�޼ҵ�1����");
		stack.push("�޼ҵ�2����");
		stack.push("�޼ҵ�3����");
		stack.push("�޼ҵ�4����");
		
		System.out.println("���� ���� �ִ� ������: " + stack.peek());
		
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
