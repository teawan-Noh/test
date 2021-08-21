package lab.intank.lamdba;

public class LamdbaTest {
	//���ٽ� ���� : interface���� �ϰ� �߻�޼ҵ� 1���� ������ �־�� �Ѵ�.
	public static void main(String[] args) {
		A a = new A() {
			public void exec() {
				System.out.println("�͸� ���� Ŭ����");
			}
		};
		a.exec();
		
		A r01 = () -> {System.out.println("A ���ٽ�");}; //���ٽ� : 6~9���� �ڵ�� ����
		r01.exec();
		
		B b = new B() {
			public void exec(int time) {
				System.out.println("�͸� ���� Ŭ���� :" + time);
			}
		};
		b.exec(5);
		
		B r02 = (t) -> {System.out.println("�͸� ���� Ŭ���� :" + t);};
		r02.exec(7);
		
		//void run(int time, String name);
		C r03 = (t, n) -> {
			System.out.println(t);
			System.out.println(n);
		};
		r03.run(5, "�̸���");
		
		//String run(int time, String name);
		D r04 = (t, n) -> {
			System.out.println(t);
			System.out.println(n);
			return n + " �����尡" + t + "�� ���� ����Ǿ����ϴ�.";
		};
		
		System.out.println(r04.run(5, "main"));
		
		
	}

}
