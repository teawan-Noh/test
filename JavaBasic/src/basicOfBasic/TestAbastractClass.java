package basicOfBasic;

abstract class Animal{ //����
	abstract void eat();
	abstract void sleep();
}


abstract class Mammal extends Animal{//������  //�߻� Ŭ������ �߻�Ŭ������ ���
	abstract void bear();//����ϴ�
}

class Dog extends Mammal{
	void eat(){}
	void sleep(){}
	void bear(){}

}
class TestAbastractClass {

	Animal test(Animal a){ //�Ķ���ͷ� �ü� �ִ� Ŭ������ 1��, �Ķ���Ϳ� ��ü �ּҸ� �޶�°ǵ� �߻�Ŭ������ ��ü�� ������ �� �����Ƿ� dogŬ������ �� �� �ִ�, �Ķ���Ϳ� �θ�Ŭ������ ������ �ڽ�Ŭ������ �޾ƿ��°� ����� ������ �Ѵ�
		
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
