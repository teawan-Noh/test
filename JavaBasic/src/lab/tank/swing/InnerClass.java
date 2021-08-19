package lab.tank.swing;

public class InnerClass {
	
	
	public static void main(String[] args) {
		Outer out = new Outer(); //�ܺθ� �����
		out.printOuter();
		
		Outer.Inner in = out.new Inner();  // �ܺ�.new Inner
		in.printInner(); //���� Ŭ���� �ȿ� ����� �޼ҵ� ȣ��
		
		//���� ���� Ŭ����
		Outer.StaticInner staticInner = new Outer.StaticInner();
		staticInner.printInner();
		
		//���� ���� Ŭ����
		Object refLocal = out.getLocal();
		System.out.println(refLocal.toString());
		
		//�͸� ���� Ŭ����
		Object refAnoymout = out.getAnoymous();
		System.out.println(refAnoymout.toString());
	}

}
