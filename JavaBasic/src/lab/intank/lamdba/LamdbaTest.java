package lab.intank.lamdba;

public class LamdbaTest {
	//람다식 조건 : interface여야 하고 추상메소드 1개만 가지고 있어야 한다.
	public static void main(String[] args) {
		A a = new A() {
			public void exec() {
				System.out.println("익명 내부 클레스");
			}
		};
		a.exec();
		
		A r01 = () -> {System.out.println("A 람다식");}; //람다식 : 6~9번줄 코드와 같음
		r01.exec();
		
		B b = new B() {
			public void exec(int time) {
				System.out.println("익명 내부 클레스 :" + time);
			}
		};
		b.exec(5);
		
		B r02 = (t) -> {System.out.println("익명 내부 클레스 :" + t);};
		r02.exec(7);
		
		//void run(int time, String name);
		C r03 = (t, n) -> {
			System.out.println(t);
			System.out.println(n);
		};
		r03.run(5, "이름이");
		
		//String run(int time, String name);
		D r04 = (t, n) -> {
			System.out.println(t);
			System.out.println(n);
			return n + " 스레드가" + t + "초 동안 실행되었습니다.";
		};
		
		System.out.println(r04.run(5, "main"));
		
		
	}

}
