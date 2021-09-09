package basicOfBasic;

abstract class Animal{ //동물
	abstract void eat();
	abstract void sleep();
}


abstract class Mammal extends Animal{//포유류  //추상 클레스를 추상클레스로 상속
	abstract void bear();//출산하다
}

class Dog extends Mammal{
	void eat(){}
	void sleep(){}
	void bear(){}

}
class TestAbastractClass {

	Animal test(Animal a){ //파라미터로 올수 있는 클레스는 1개, 파라미터에 객체 주소를 달라는건데 추상클레스는 객체를 생성할 수 없으므로 dog클레스만 올 수 있다, 파라미터에 부모클레스가 왔을때 자식클래스를 받아오는건 상속을 전제로 한다
		
		return a;
	}
	public static void main(String[] args) {
		Dog dog1 = new Dog();
		dog1.eat();
		dog1.sleep();
		dog1.bear();

		Mammal dog2 = new Dog();
		dog2.eat();
		dog2.sleep();
		dog2.bear();

		Animal dog3 = new Dog();
		dog3.eat();
		dog3.sleep();
		
	}
}
