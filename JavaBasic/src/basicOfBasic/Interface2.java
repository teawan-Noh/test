package basicOfBasic;

//�������̽�

interface A{

	//(v_1.7)
	//��� : ������ �ʴ� ��, �������� �빮�ڷ� ����
	//�߻�޼ҵ�
	//public static final double PI  = 3.14;
	double PI  = 3.14;  //�������̽����� ����� �߻�޼ҵ常 �� �� �����Ƿ� �պκ�(public static final) ����

	//public abstract void methodA();
	void  methodA();	//�������̽����� ����� �߻�޼ҵ常 �� �� �����Ƿ� �պκ�(public abstract) ����
	
}

interface H extends A{} //�������̽����� ����� extends, class���� ��ӵ� extends

interface I{}

class X{}
//class B extends X implement A  extends���� 1���� Ŭ������ ���� implement �ڿ��� ������ ���� : implement A, .., .., ..
//class B extends X implements A, H, I{  //implements - �������̽��� �����ߴ�, ���ȿ���� �ִ�
//	public void methodA(){}
//}
class B extends X implements I, H{  //implements - �������̽��� �����ߴ�, ���ȿ���� �ִ�
	public void methodA(){}
}




class interfaceTest{
	
	public void methodA(X x){}
	public void methodB(H h){}
	public void methodC(I ksmd){}
	public void methodD(A a){}

	public static void main(String[] args) {
		//interface�� new �� �� ���� (��ü�� ������ �� ����)


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

