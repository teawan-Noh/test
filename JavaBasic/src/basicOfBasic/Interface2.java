package basicOfBasic;

//인터페이스

interface A{

	//(v_1.7)
	//상수 : 변하지 않는 수, 변수명을 대문자로 쓴다
	//추상메소드
	//public static final double PI  = 3.14;
	double PI  = 3.14;  //인터페이스에는 상수와 추상메소드만 올 수 있으므로 앞부분(public static final) 생략

	//public abstract void methodA();
	void  methodA();	//인터페이스에는 상수와 추상메소드만 올 수 있으므로 앞부분(public abstract) 생략
	
}

interface H extends A{} //인터페이스간의 상속은 extends, class간의 상속도 extends

interface I{}

class X{}
//class B extends X implement A  extends에는 1개의 클래스만 가능 implement 뒤에는 여러개 가능 : implement A, .., .., ..
//class B extends X implements A, H, I{  //implements - 인터페이스를 구현했다, 상속효과가 있다
//	public void methodA(){}
//}
class B extends X implements I, H{  //implements - 인터페이스를 구현했다, 상속효과가 있다
	public void methodA(){}
}




class interfaceTest{
	
	public void methodA(X x){}
	public void methodB(H h){}
	public void methodC(I ksmd){}
	public void methodD(A a){}

	public static void main(String[] args) {
		//interface는 new 할 수 없다 (객체를 생성할 수 없다)


		X x = new B();
		H h = new B();
		I i = new B();
		A a = new B();

//		Test01 t1 = new Test01();
//		t1.methodA(new B());
//		t1.methodB(new B());
//		t1.methodC(new B());
//		t1.methodD(new B());
	}


}

