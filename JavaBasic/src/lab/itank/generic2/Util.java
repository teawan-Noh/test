package lab.itank.generic2;

public class Util {
	public void putAll(Pocket<?> pocket) {}  //아무거나 가능
	
	public void putJewel(Pocket<? extends Jewel> pocket) {} //Jewel을 포함하여 상속받은 클레스들 
	
	public void putRing(Pocket<? extends Ring> pocket) {}	//Ring을 포함하여 상속받은 클레스들 
	
	public void putEarRing(Pocket<? super EarRing > pocket) {}  //EarRing을 포함하여 부모인 클레스들
	
	//public <T extends Ring> void putRing(Pocket<T> pocket) {}  8번줄과 같음 T: Ring을 상속받은 T
	
	//public <T super EarRing> void putEarRing(Pocket<T> pocket) {}  // super는 이렇게 못씀 안됨 
	//public <T> void putRing(Pocket<T extends Ring> pocket) // <T>만 앞으로 빼놓고 <T extends Ring>: 상속받는거 안됨 12번줄만 가능
}
