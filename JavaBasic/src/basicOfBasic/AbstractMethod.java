package basicOfBasic;

public class AbstractMethod {
	
	abstract class A{
		//�߻�޼ҵ� : ������ ���� �޼ҵ� 
		abstract void methodA(); //�߰�ȣ ��� ; ������ ������ ���� �޼ҵ� -> ������ ���� �޼ҵ�� ����� abstract�� �ٿ��ش� -> �߻�޼ҵ�
		//abstract void methodA(){} �߰�ȣ�� ���� ������ �޼ҵ带 �����ѰŴ� 
		
		void methodB(){}
	}

	abstract class B extends A{ //��ӹ޴��� abstract�� ��ӹ����� �ڽŵ� abstract�� �ٿ�����
		
	}
	//class B extends A{
		//void methodA(){} �߻�޼ҵ带 ������ �޼ҵ�� �ٲ���� class �տ� ���� abstract�� ���� �� �ִ�
	//}


	class Test02 {
		public void main(String[] args) {
			
		}
	}

	//�߻�޼ҵ� : ������ ���� �޼ҵ�
	abstract class Instrument{

		String name;

		abstract void play();
	}

	class  WindInstrument extends Instrument{

		void play(){
			System.out.println("������ ���ָ� �ؿ�");
		}
	}

	class PercussionInstrument extends Instrument{

		void play(){
			System.out.println("�ε���� ���ָ� �ؿ�");
		}
	}

	class Piano extends PercussionInstrument{

		void play(){
			System.out.println("�հ��� 10���� �̿��ؼ� ������ ���ָ� �ؿ�");
		}
	}

	class Test01 {

		void play(Instrument instrument){
			instrument.play();         //��Ӱ��迡 �ְ� �������̵尡 �Ǿ��⶧���� �Ķ���Ϳ� �ǰ�ü�� ������������ ���� �����
		}

		PercussionInstrument getInstrument(){  //���� Ÿ���� Instrument  , ������ Ŭ����Ÿ���ϋ� Ŭ������ ���� �����Ѵ�
			PercussionInstrument instrument = new Piano();
			//return instrument;

			//return new Instrument();			//�߻�Ŭ������ new �Ҽ� ����
			//return new WindInstrument();		//��Ӱ��迡 �ִ� Ŭ������ ������ �� �ִ�
			return new PercussionInstrument();  //��Ӱ��迡 �ִ� Ŭ������ ������ �� �ִ�
			//return new Piano();					//��Ӱ��迡 �ִ� Ŭ������ ������ �� �ִ�  Piano -> PercussionInstrument -> Instrument  
			//Instrument�� ��ӹ��� Ŭ������ �� ���ִ�
			//PercussionInstrument�� ���������� �ϸ� PercussionInstrument�� Piano�� �� ���ִ� (�ڱ��ڽŰ� ��ӹ��� �ڽĸ� �� �� �ִ�) / ����, �θ� Ŭ���� �� �� ����
		}
		public void main(String[] args) {
			Test01 t1 = new Test01();
			//t1.play(new Instrument()); //�߻�Ŭ������ ��ü���� �Ұ���
			t1.play(new WindInstrument());
			t1.play(new PercussionInstrument());
			t1.play(new Piano());
		}
	}

}
