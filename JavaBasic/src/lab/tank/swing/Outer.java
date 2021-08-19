package lab.tank.swing;
//일반 내부클레스    //클레스안에 클레스가 있을 수 있다 메소드 안에 클레스가 있을 수 있다  // 모르면 넘어가도 된다 
//정적 내부클레스   //인지하는 정도만 해도 된다
//지역 내부클레스
//익명 내부클레스

public class Outer {

	int outData = 100;
	static int staticOutData = 500;
	final int finalOutData = 700;
	
	public void printOuter() {
		
		System.out.println("Outer클레스의 printOuter() 메소드 호출");
	}
	
	public static void staticPrintOuter() {
		
		System.out.println("Outer클레스의 staticPrintOuter() 메소드 호출");
	}
	
	//일반 내부 클레스
	class Inner {
		
		int inData = 200;
		
		public void printInner() {
			System.out.println(inData);
			
			System.out.println(outData); //외부클레스의 변수를 가져다 쓸 수 있다.
			System.out.println(staticOutData);
			System.out.println(finalOutData);
			
			printOuter();       //외부클레스의 메소드 가져다 쓸 수 있다.
			staticPrintOuter();
		}
	}
	
	//정적 내부클레스 : 외부 클레스의 static 붙은것만 사용할 수 있다
	static class StaticInner {
		
		int inData = 200;
		
		public void printInner() {
			System.out.println(inData);
			
			//System.out.println(outData);  //static클레스에선 자기것과 static만 가져다 쓸 수 있다
			System.out.println(staticOutData);
			//System.out.println(finalOutData);  //static클레스에선 자기것과 static만 가져다 쓸 수 있다
			
			//printOuter();       
			staticPrintOuter();	 //static클레스에선 자기것과 static만 가져다 쓸 수 있다
		}
	}
	//지역 내부 클레스 : 메소드 안에 선언된 클레스 
	Object getLocal() {
		int localData = 10;
		final int finalLocalData = 5;
		
		class Local{
			
			public String toString() {
				String temp = "";
				temp += "\n Outer 클래스의 인스턴스 데이터 = " + outData;  //outData : 외부 클레스에 있음
				temp += "\n Outer 클래스의 static 데이터 = " + staticOutData;  //staticOutData : 외부 클레스에 있음
				temp += "\n Outer 클래스의 final 데이터 = " + finalOutData;  //finalOutData : 외부 클레스에 있음
				
				temp += "\n getLocal()의 non-final 데이터 = " + localData;  //localData : 메소드의 지역안에 있음
				temp += "\n getLocal()의 final 데이터 = " + finalLocalData;  //finalLocalData : 메소드의 지역안에 있음
				
				return temp;
			}
		}
		
		return new Local();
	}
	
	//익명내부 클레스
	Object getAnoymous() {
		
		int localData = 10;
		final int finalLocalData = 5;
		
		return (new Object() { //Object 자리에 인터페이스가 온다
			
			public String toString() {
				String temp = "";
				temp += "\n Outer 클래스의 인스턴스 데이터 = " + outData;  //outData : 외부 클레스에 있음
				temp += "\n Outer 클래스의 static 데이터 = " + staticOutData;  //staticOutData : 외부 클레스에 있음
				temp += "\n Outer 클래스의 final 데이터 = " + finalOutData;  //finalOutData : 외부 클레스에 있음
				
				temp += "\n getLocal()의 non-final 데이터 = " + localData;  //localData : 메소드의 지역안에 있음
				temp += "\n getLocal()의 final 데이터 = " + finalLocalData;  //finalLocalData : 메소드의 지역안에 있음
				
				return temp;
			}
		});
		
	}
}
