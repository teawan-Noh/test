package basicOfBasic;

interface C{
	//1.8������ ����� �߻�޼ҵ常
	//java 1.8 verson���� �����޼ҵ�, ����Ʈ�޼ҵ� ��밡��

	//�����޼ҵ�
	static void method01(){
		System.out.println("�����޼ҵ�� �������̽� �̸����� ȣ�� �����մϴ�");
	}

	//����Ʈ�޼ҵ�
	public default void method02(){
		System.out.println("�������̽��� default �޼ҵ� ȣ�� aaaa");
	}

	//�߻�޼ҵ�
	void method03();
}

class CC implements C{

	public void method03(){System.out.println("�������̽��� mehtod03 �޼ҵ� ȣ��");}

	//����Ʈ �޼ҵ� ������ ���� but, �����(default) ������
	public void method02(){
		System.out.println("�������̽��� default �޼ҵ� ȣ��");
	}
}

interface DD extends C{

}

class F implements DD{
	
	public void method02(){
		System.out.println("F �޼ҵ� ȣ��");
	}
	
	public void method03(){}  //�߻�޼ҵ� ����


}

class  interfaceTest2{
	public static void main(String[] args) {
		
		C.method01();  //����
		//C.method02();//�Ұ���

		CC cc = new CC();
		cc.method02(); //default �޼ҵ� : implements �ؼ� �������� �ٷ� ��밡��
		cc.method03(); //�߻�޼ҵ�� : implements �ؼ� �����ؾ� ��밡��

		F f = new F();
		f.method02();

	}
}


