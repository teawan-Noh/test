package basicOfBasic;
//final �����
//1.Ŭ���� ��
//2.�޼ҵ� ��
//3.���� ��
public class Final {
	//1.Ŭ���� �� : ��� �Ұ����� Ŭ������ �ȴ�.
	final class ClassA{  //fanal�� ���� Ŭ������ ����� �� ����
	}

	//class classB extends ClassA{}


	//2.�޼ҵ� �� : overiding �Ұ���
	class ClassC{
		final void methodA(){}
	}

	class ClassD extends ClassC{
		//void methodA(){}
	}

	//3.���� �� : �ʱⰪ ���� �Ұ���
	class ClassE{
		static final double PI = 3.14;  //���� �տ� final�̿��� ��κ� static�� �ٴ´�

		double getPI(){
			//PI = 1.14;
			return PI;
		}
	}

	//��
	class ClassF{

		final double A; //��ü������ finla�� �����ϰ� ���� �Ҵ����� ������ �����ڿ��� A���� �־�����Ѵ� // �ſ� ��������

		ClassF(){A = 100;}
		ClassF(double A){this.A = A;}
	}

	class ClassG{

		static final double A =100; //��ü������ finla�� �����ϰ� static������ �������ָ� ������ ó������ ���� �Ҵ�������Ѵ�

		//ClassG(){A = 100;}
		//ClassG(double A){this.A = A;}
	}

	class ClassH{
		
		ClassH(final double d){
			//d=100.0; �Ұ���
			final int i = 0;
			//i=5; �ذ���
		}
		
	}

		public static void main(String[] args) {
			System.out.println("Hello World!");
		}
}
