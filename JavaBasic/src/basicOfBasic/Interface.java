package basicOfBasic;

interface Animal2{
	
	public abstract void eat();
	public abstract void sleep();

	public default void help(){
		System.out.println("�ڿ� ���°踦 ���������ش�.");
	}
}

interface Pet extends Animal2{  //�������̽����� ��ӹ����� extends
	
	public static void actCharming(){  //static�� �����޼ҵ�� ����� �������� ������(������), �θ��� Ŭ������(�������̽���)���� ȣ�����ְ�, ��ӵ� �ȵ�, �ڽĿ��� ��ü�����ϰ� ȣ���ص� ȣ�� �ȵ� 
		System.out.println("�ֱ��� ����");
	}

	public default void help(){  //interface���� default �Լ� �������Ҷ��� �״�� default�� ���ܳ����� class���� ������ �� ���� default�� ������Ѵ� (22����)
		System.out.println("����� �� �ܷӰ� ���ش�.");
	}
}

class Dog2 implements Pet{  //Ŭ������ interface�� ��ӹ��� �� implements
	public void eat(){}  //��ӹ��� ��� �߻�޼��带 ��� �����ؾ��Ѵ�
	public void sleep(){}  //�߻�޼��带 ���� ���ϸ� 22���� Ŭ���� �տ� abstract �ٿ���� �Ѵ�

	public void help(){
		System.out.println("����� ��̰� ���ش�.");
	}

}

class TestInterface{

	Animal test(Animal a){ //�Ķ���ͷ� �ü� �ִ� Ŭ������ 1��, �Ķ���Ϳ� ��ü �ּҸ� �޶�°ǵ� �߻�Ŭ������ ��ü�� ������ �� �����Ƿ� dogŬ������ �� �� �ִ�, �Ķ���Ϳ� �θ�Ŭ������ ������ �ڽ�Ŭ������ �޾ƿ��°� ����� ������ �Ѵ�
		
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

//		Animal dog3 = new Dog2(); //Interface�� ��ü ������ �� ����
//		dog3.eat();
//		dog3.sleep();
//		dog3.help();
	}
}

