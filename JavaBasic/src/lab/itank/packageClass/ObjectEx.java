package lab.itank.packageClass;

//Object : 최상위 클레스 (유일하게 아무것도 상속받지 않음)
public class ObjectEx { //extends Object가 생략되어있음
	//부모 Object의 메소드 11개 생략되어있음
	public static void main(String[] args) {
		
		ObjectEx parent0 = new ObjectEx();
		
		System.out.println("hashCode() = "+ parent0.hashCode()); //객체의 고유한 번호 
		System.out.println("getClass() = "+ parent0.getClass()); //객체변수의 소속 정보를 보여줌
		System.out.println("toString() = "+ parent0.toString()); //
		System.out.println("toString() 생략 = "+ parent0); //
		
		ObjectEx parent1 = new ObjectEx();
		
		System.out.println(parent0.equals(parent1)); //객체가 같은지 묻는 함수 
		System.out.println(parent0.equals(parent0)); //객체가 같은지 묻는 함수 
		System.out.println(parent0 == parent0); //
		
		
	}
}
