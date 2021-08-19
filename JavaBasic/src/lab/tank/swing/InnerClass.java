package lab.tank.swing;

public class InnerClass {
	
	
	public static void main(String[] args) {
		Outer out = new Outer(); //외부를 만들고
		out.printOuter();
		
		Outer.Inner in = out.new Inner();  // 외부.new Inner
		in.printInner(); //내부 클레스 안에 선언된 메소드 호출
		
		//정적 내부 클레스
		Outer.StaticInner staticInner = new Outer.StaticInner();
		staticInner.printInner();
		
		//지역 내부 클레스
		Object refLocal = out.getLocal();
		System.out.println(refLocal.toString());
		
		//익명 내부 클레스
		Object refAnoymout = out.getAnoymous();
		System.out.println(refAnoymout.toString());
	}

}
