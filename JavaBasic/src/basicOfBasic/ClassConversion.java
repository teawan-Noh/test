package basicOfBasic;

public class ClassConversion {
	// Ŭ������(Ŭ���� �̸�) ����ȭ : ��Ӱ��迡���� �� �� �ִ�

	class Instrument {

		void play() {
			System.out.println("���ָ� �ؿ�");
		}
	}

	class WindInstrument extends Instrument {

		void play() {
			System.out.println("������ ���ָ� �ؿ�");
		}
	}

	class PercussionInstrument extends Instrument {

		void play() {
			System.out.println("�ε���� ���ָ� �ؿ�");
		}
	}

	class Test02 {
		public void main(String[] args) {
			// WindInstrument windInstrument = new WindInstrument();
			// Instrument instrument = windInstrument; //�ڽ��� �θ������� �������� �ڵ� ����ȯ

			Instrument instrument2 = new PercussionInstrument();
			PercussionInstrument percussionInstrument = (PercussionInstrument) instrument2; // �θ� �ڽ������� �������� ����ȯ�� �ʿ��ϴ�

			Instrument instrument3 = new WindInstrument();
			// WindInstrument windInstrument = (PercussionInstrument)instrument3; ///XXXXXX
			// �ȵ� ����ȯ�� �θ�� ���������� ���������� �Ұ���

			// ��������ȯ�� ��Ӱ��迡���� �����ϴ� !!!�߿�
			// instanceof�� ��ü Ÿ���� Ȯ���ϴ� �������̴�.

			// �����ϰ� ���� ����ȯ
			Instrument instrument4 = new WindInstrument();
			if (instrument4 instanceof WindInstrument) { // instanceof�� instrument4�� WindInstrument�� ������ �´��� Ȯ���ϴ� �����
				WindInstrument windInstrument = (WindInstrument) instrument4; // ���� ������� ����
			}
		}
	}

}
