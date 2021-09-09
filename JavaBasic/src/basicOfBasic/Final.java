package basicOfBasic;
//final 예약어
//1.클레스 앞
//2.메소드 앞
//3.변수 앞
public class Final {
	//1.클레스 앞 : 상속 불가능한 클래스가 된다.
	final class ClassA{  //fanal이 붙은 클레스는 상속할 수 없다
	}

	//class classB extends ClassA{}


	//2.메소드 앞 : overiding 불가능
	class ClassC{
		final void methodA(){}
	}

	class ClassD extends ClassC{
		//void methodA(){}
	}

	//3.변수 앞 : 초기값 변경 불가능
	class ClassE{
		static final double PI = 3.14;  //변수 앞에 final이오면 대부분 static이 붙는다

		double getPI(){
			//PI = 1.14;
			return PI;
		}
	}

	//덤
	class ClassF{

		final double A; //객체변수에 finla을 설정하고 값을 할당하지 않으면 생성자에서 A값을 넣어줘야한다 // 매우 귀찮아짐

		ClassF(){A = 100;}
		ClassF(double A){this.A = A;}
	}

	class ClassG{

		static final double A =100; //객체변수에 finla을 설정하고 static변수로 선언해주면 무조건 처음부터 값을 할당해줘야한다

		//ClassG(){A = 100;}
		//ClassG(double A){this.A = A;}
	}

	class ClassH{
		
		ClassH(final double d){
			//d=100.0; 불가능
			final int i = 0;
			//i=5; 붕가능
		}
		
	}

		public static void main(String[] args) {
			System.out.println("Hello World!");
		}
}
