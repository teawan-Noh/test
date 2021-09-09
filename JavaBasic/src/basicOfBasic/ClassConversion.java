package basicOfBasic;

public class ClassConversion {
	// 클래스형(클래스 이름) 형변화 : 상속관계에서만 할 수 있다

	class Instrument {

		void play() {
			System.out.println("연주를 해요");
		}
	}

	class WindInstrument extends Instrument {

		void play() {
			System.out.println("입으로 연주를 해요");
		}
	}

	class PercussionInstrument extends Instrument {

		void play() {
			System.out.println("두드려서 연주를 해요");
		}
	}

	class Test02 {
		public void main(String[] args) {
			// WindInstrument windInstrument = new WindInstrument();
			// Instrument instrument = windInstrument; //자식을 부모형으로 넣을때는 자동 형병환

			Instrument instrument2 = new PercussionInstrument();
			PercussionInstrument percussionInstrument = (PercussionInstrument) instrument2; // 부모를 자식형으로 넣으려면 형변환이 필요하다

			Instrument instrument3 = new WindInstrument();
			// WindInstrument windInstrument = (PercussionInstrument)instrument3; ///XXXXXX
			// 안됨 형변환은 부모는 가능하지만 형제끼리는 불가능

			// 강제형변환은 상속관계에서만 가능하다 !!!중요
			// instanceof는 객체 타입을 확인하는 연산자이다.

			// 안전하게 강제 형변환
			Instrument instrument4 = new WindInstrument();
			if (instrument4 instanceof WindInstrument) { // instanceof는 instrument4가 WindInstrument의 객차가 맞는지 확인하는 예약어
				WindInstrument windInstrument = (WindInstrument) instrument4; // 따라서 실행되지 않음
			}
		}
	}

}
