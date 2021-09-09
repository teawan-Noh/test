package basicOfBasic;

public class AbstractMethod {
	
	abstract class A{
		//추상메소드 : 구현을 안한 메소드 
		abstract void methodA(); //중괄호 대신 ; 넣으면 구현을 안한 메소드 -> 구현을 안한 메소드는 예약어 abstract를 붙여준다 -> 추상메소드
		//abstract void methodA(){} 중괄호를 열고 닫으면 메소드를 구현한거다 
		
		void methodB(){}
	}

	abstract class B extends A{ //상속받더라도 abstract을 상속받으면 자신도 abstract를 붙여야함
		
	}
	//class B extends A{
		//void methodA(){} 추상메소드를 구현한 메소드로 바꿔줘야 class 앞에 붙은 abstract를 없앨 수 있다
	//}


	class Test02 {
		public void main(String[] args) {
			
		}
	}

	//추상메소드 : 구현을 안한 메소드
	abstract class Instrument{

		String name;

		abstract void play();
	}

	class  WindInstrument extends Instrument{

		void play(){
			System.out.println("입으로 연주를 해요");
		}
	}

	class PercussionInstrument extends Instrument{

		void play(){
			System.out.println("두드려서 연주를 해요");
		}
	}

	class Piano extends PercussionInstrument{

		void play(){
			System.out.println("손가락 10개를 이용해서 열심히 연주를 해요");
		}
	}

	class Test01 {

		void play(Instrument instrument){
			instrument.play();         //상속관계에 있고 오버라이드가 되었기때문에 파라미터에 실객체에 뭐가오는지에 따라 실행됨
		}

		PercussionInstrument getInstrument(){  //리턴 타입이 Instrument  , 리턴이 클레스타입일떄 클레스를 만들어서 리턴한다
			PercussionInstrument instrument = new Piano();
			//return instrument;

			//return new Instrument();			//추상클레스는 new 할수 없다
			//return new WindInstrument();		//상속관계에 있는 클레스로 리턴할 수 있다
			return new PercussionInstrument();  //상속관계에 있는 클레스로 리턴할 수 있다
			//return new Piano();					//상속관계에 있는 클레스로 리턴할 수 있다  Piano -> PercussionInstrument -> Instrument  
			//Instrument를 상속받은 클레스가 올 수있다
			//PercussionInstrument을 리턴형으로 하면 PercussionInstrument와 Piano만 올 수있다 (자기자신과 상속받은 자식만 올 수 있다) / 형제, 부모 클레스 올 수 없음
		}
		public void main(String[] args) {
			Test01 t1 = new Test01();
			//t1.play(new Instrument()); //추상클레스는 객체생성 불가능
			t1.play(new WindInstrument());
			t1.play(new PercussionInstrument());
			t1.play(new Piano());
		}
	}

}
