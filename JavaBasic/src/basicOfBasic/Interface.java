package basicOfBasic;

interface Animal2{
	
	public abstract void eat();
	public abstract void sleep();

	public default void help(){
		System.out.println("자연 생태계를 유지시켜준다.");
	}
}

interface Pet extends Animal2{  //인터페이스끼리 상속받을땐 extends
	
	public static void actCharming(){  //static은 정적메소드로 선언된 곳에서만 가진다(지거임), 부를때 클레스명(인터페이스명)으로 호출해주고, 상속도 안됨, 자식에서 객체생성하고 호출해도 호출 안됨 
		System.out.println("애교를 떨다");
	}

	public default void help(){  //interface에서 default 함수 재정의할때는 그대로 default를 남겨놓지만 class에서 재정의 할 때는 default를 빼줘야한다 (22번줄)
		System.out.println("사람을 덜 외롭게 해준다.");
	}
}

class Dog2 implements Pet{  //클레스가 interface를 상속받을 땐 implements
	public void eat(){}  //상속받은 모든 추상메서드를 모두 구현해야한다
	public void sleep(){}  //추상메서드를 구현 안하면 22번줄 클레스 앞에 abstract 붙여줘야 한다

	public void help(){
		System.out.println("사람을 즐겁게 해준다.");
	}

}

class TestInterface{

	Animal test(Animal a){ //파라미터로 올수 있는 클레스는 1개, 파라미터에 객체 주소를 달라는건데 추상클레스는 객체를 생성할 수 없으므로 dog클레스만 올 수 있다, 파라미터에 부모클레스가 왔을때 자식클래스를 받아오는건 상속을 전제로 한다
		
		return a;
	}
	public static void main(String[] args) {
		Pet.actCharming();
		
		Dog2 dog1 = new Dog2();
		dog1.eat();
		dog1.sleep();
		dog1.help();
		

		Pet dog2 = new Dog2();
		dog2.eat();
		dog2.sleep();
		dog2.help();

//		Animal dog3 = new Dog2(); //Interface로 객체 생성할 수 없다
//		dog3.eat();
//		dog3.sleep();
//		dog3.help();
	}
}

