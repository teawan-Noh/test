package basicOfBasic;

interface C{
	//1.8이전엔 상수랑 추상메소드만
	//java 1.8 verson부터 정적메소드, 디폴트메소드 사용가능

	//정적메소드
	static void method01(){
		System.out.println("정적메소드는 인터페이스 이름으로 호출 가능합니다");
	}

	//디폴트메소드
	public default void method02(){
		System.out.println("인터페이스의 default 메소드 호출 aaaa");
	}

	//추상메소드
	void method03();
}

class CC implements C{

	public void method03(){System.out.println("인터페이스의 mehtod03 메소드 호출");}

	//디폴트 메소드 재정의 가능 but, 예약어(default) 빼야함
	public void method02(){
		System.out.println("인터페이스의 default 메소드 호출");
	}
}

interface DD extends C{

}

class F implements DD{
	
	public void method02(){
		System.out.println("F 메소드 호출");
	}
	
	public void method03(){}  //추상메소드 구현


}

class  interfaceTest2{
	public static void main(String[] args) {
		
		C.method01();  //가능
		//C.method02();//불가능

		CC cc = new CC();
		cc.method02(); //default 메소드 : implements 해서 구현없이 바로 사용가능
		cc.method03(); //추상메소드는 : implements 해서 구현해야 사용가능

		F f = new F();
		f.method02();

	}
}


