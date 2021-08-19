package lab.itank.generic;

public class Util { //Class명에 <T>을 넣어주지 않으면 generic을 사용하고 싶은 각 파트에 <T>붙여준다
					//T는 타입이 안정해져 있으므로 필요한거 넣어서 사용 
	public Util(String s) {}
	
	public <T> Pocket<T> make(T t){ // <T> : generic class , T자리에는 Class 이름이 들어감 (정해지지 않았을땐 T)
		Pocket<T> pocket = new Pocket<>();
		pocket.setT(t);
		
		return pocket;
	}
	
	public <T> T give(Pocket<T> pocket) {
		return pocket.getT();
	}
	
	public static void main(String[] args) {
		
		Util util = new Util("asdasd");  
		Pocket<Integer> p1 = util.make(1234);
		System.out.println(util.give(p1));
	}
}